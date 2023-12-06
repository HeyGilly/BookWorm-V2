package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.models.FavoriteGenre;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import com.bookworm.bookwormv2.repository.ReviewRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
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
    //-- Review Repo to gather information
    private final ReviewRepository reviewRepository;
    //-- User Repo to gather information of user;
    private final UserRepository userRepository;

    //-- Constructor
    public main_controller(BookshelfRepository bookshelfRepo, ReviewRepository reviewRepository, UserRepository userRepository) {
        this.bookshelfRepo = bookshelfRepo;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
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

    @PostMapping("/welcome-page")
    public String processSearch(@ModelAttribute("searchTerm") String searchTerm, Model model) {

        // Prepare the search term for the API request
        String conCatSearchTerm = String.join("+", searchTerm.split("\\s+"));

        // Create the API request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + conCatSearchTerm + "&printType=books"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {

            // Send the API request and get the response
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode apiResponseJson = objectMapper.readTree(response.body());
            Thread.sleep(1500);
            // Add the JSON response to the model
            model.addAttribute("apiResponse", apiResponseJson);
            // Add the search term to the model to be used in the template
            model.addAttribute("searchTerm", searchTerm);
        } catch (IOException | InterruptedException e) {
            // Handle exceptions
            e.printStackTrace();
        }

        // The data for the rest of the page
        addExistingDataToModel(model);
        // Return the view name
        return "main/introduction-page";
    }











    @GetMapping("/single-book")
    public String singleBook(Model model){


        model.addAttribute("singleBookInfo", bookshelfRepo.findByIsbn(9781982131807L));
        String genre = bookshelfRepo.findByIsbn(9781982131807L).getGenre();
        model.addAttribute("bookGenre", bookshelfRepo.findAllByGenre(genre));

        long book_id = bookshelfRepo.findByIsbn(9781982131807L).getId();
        model.addAttribute("bookReview", reviewRepository.findReviewByBookshelf_Id(book_id));

        return "main/SingleBookPreview";
    }



    @GetMapping("/userProfile")
    public String userProfile(Model model){
        //-- Genre
        List<FavoriteGenre> favoriteGenres = userRepository.findUserById(16).getFavoriteGenres();
        model.addAttribute("favoriteGenres", favoriteGenres);
        // User image
        String pathway = String.valueOf(userRepository.findUserById(16).getProfilePicturePath());
        model.addAttribute("profilePathway", pathway);
        //-- find user
        model.addAttribute("user",userRepository.findUserById(16));
        //-- find reviews of user
        model.addAttribute("usersReview",reviewRepository.findReviewByUserId(16));
        return "main/userProfile";
    }



}
