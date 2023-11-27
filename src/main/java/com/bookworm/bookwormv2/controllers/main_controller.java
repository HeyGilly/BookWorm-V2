package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class main_controller {
    //-- Book Repository to gather all books
    private final BookshelfRepository bookshelfRepo;

    //-- Constructor
    public main_controller(BookshelfRepository bookshelfRepo) {
        this.bookshelfRepo = bookshelfRepo;
    }
    //-- getter
    public BookshelfRepository getBookshelfRepo() {
        return bookshelfRepo;
    }


    //-- This function is going to help us so we dont have to repeat what we want as in the books by genre and the list of genres.
    private void addExistingDataToModel(Model model) {
        //-- find By Thriller Genre
        model.addAttribute("ThrillerBooks", bookshelfRepo.findAllByGenre("thriller"));
        model.addAttribute("FictionBooks", bookshelfRepo.findAllByGenre("fiction"));
        //-- Retrieves all books from database, using the bookshelf Repo
        List<Bookshelf> allBooks = bookshelfRepo.findAll();
        //-- Creates an empty list to store the unique genres
        //--  a forEach loop through each book in the allBooks list.
        List<String> uniqueGenres = new ArrayList<>();
        //-- Loops through the books and add unique genres to the array
        allBooks.forEach(book -> {
            //-- Stores all books genre inside the genre variable
            String genre = book.getGenre().substring(0, 1).toUpperCase() + book.getGenre().substring(1);
            //-- This condition see if the empty array doesn't contain the genre
            if (!uniqueGenres.contains(genre)) {
                //-- the empty array does NOT contain the genre, we add it to the empty array.
                //-- This will capitalize the first character
                uniqueGenres.add(genre.substring(0, 1).toUpperCase() + genre.substring(1));
            }
        });
        // Pass the unique genres to the Thymeleaf template
        model.addAttribute("AllGenres", uniqueGenres);
    }




    @GetMapping("/welcome-page")
    public String home(Model model){
        // Add the existing data to the model
        addExistingDataToModel(model);
        return "main/introduction-page";
    }

    @PostMapping("/process-search")
    public String processSearch(@ModelAttribute("searchTerm") String searchTerm, Model model) {
        // Use the searchTerm in your logic
        System.out.println("Received search term: " + searchTerm);

        // == Turns String into an array then concats them with a + for a proper search in the URL
        String delimiter = " ";
        String[] splitString = searchTerm.split(delimiter);
        String conCatSearchTerm = String.join("+", splitString);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + conCatSearchTerm + "&printType=books"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode apiResponseJson = objectMapper.readTree(response.body());

            // Get the 'items' array from the JSON response
            JsonNode itemsNode = apiResponseJson.get("items");

            // Process each item in the 'items' array
            itemsNode.forEach(itemNode -> {
                // Get the 'volumeInfo' object from each item
                JsonNode volumeInfoNode = itemNode.get("volumeInfo");

                // Get the title from the 'volumeInfo' object
                String title = volumeInfoNode.get("title").asText();

                // Do something with the title, e.g., add it to a list
                // ...

                // Print the title to the console as an example
                System.out.println("Title: " + title);
            });

            // Add the entire JSON response to the model if needed
            model.addAttribute("apiResponse", apiResponseJson);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // Add the existing data to the model
        addExistingDataToModel(model);

        return "main/introduction-page";
    }










    @GetMapping("/single-book")
    public String singleBook(){
        return "main/SingleBookPreview";
    }

    @GetMapping("/userProfile")
    public String userProfile(){
        return "main/userProfile";
    }



}
