package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.models.FavoriteGenre;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import com.bookworm.bookwormv2.repository.ReviewRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import com.bookworm.bookwormv2.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

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
    //--
    public final FileService fileServiceRepository;


    //-- Constructor
    public main_controller(BookshelfRepository bookshelfRepo, ReviewRepository reviewRepository, UserRepository userRepository, FileService fileServiceRepository) {
        this.bookshelfRepo = bookshelfRepo;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.fileServiceRepository = fileServiceRepository;
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




    @GetMapping("/welcome")
    public String home(Model model){
        // Add the existing data to the model
        addExistingDataToModel(model);
        return "main/introduction-page";
    }


    @GetMapping("/single/{id}")
    public String singleBook(Model model, @PathVariable("id") long bookId){
        long BookByISBN = bookshelfRepo.findById(bookId).get().getIsbn();

        model.addAttribute("ISBNbook", BookByISBN);
        model.addAttribute("singleBookInfo", bookshelfRepo.findByIsbn(BookByISBN));
        String genre = bookshelfRepo.findByIsbn(BookByISBN).getGenre();
        model.addAttribute("bookGenre", bookshelfRepo.findAllByGenre(genre));

        long book_id = bookshelfRepo.findByIsbn(BookByISBN).getId();
        model.addAttribute("bookReview", reviewRepository.findReviewByBookshelf_Id(book_id));

        return "main/SingleBookPreview";
    }



    @GetMapping("/in/{userId}")
    public String userProfile(Model model,@PathVariable("userId") long userId) {
        //-- Genre
        List<FavoriteGenre> favoriteGenres = userRepository.findUserById(userId).getFavoriteGenres();
        model.addAttribute("favoriteGenres", favoriteGenres);
        // User image
        String pathway = String.valueOf(userRepository.findUserById(userId).getProfilePicturePath());
        model.addAttribute("profilePathway", pathway);
        //-- find user
        model.addAttribute("user", userRepository.findUserById(userId));
        //-- find reviews of user
        model.addAttribute("usersReview", reviewRepository.findReviewByUserId(userId));
        return "main/userProfile";
    }

    @PostMapping("/in/{userId}")
    public String updateProfile(@ModelAttribute User userModel, @RequestParam("profilePictureFile") MultipartFile profilePictureFile){
        User user = userRepository.findUserById(userModel.getId());
        try {
            if (!profilePictureFile.isEmpty()) {
                // Handle the file and save its path to profilePicturePath
                // For example, you can save it to a directory and store the path in the database
                // Save the file and get the file path to the directory
                String filePath = fileServiceRepository.saveFile(profilePictureFile);
                // Set the file path in the user object
                user.setProfilePicturePath("img/profilePicture/" + filePath);
            }
            if (!userModel.getPassword().isEmpty()){
                user.setPassword(userModel.getPassword());
            }
            user.setFirst_name(userModel.getFirst_name());
            user.setLast_name(userModel.getLast_name());
            user.setEmail(userModel.getEmail());
            user.setUsername(userModel.getUsername());
            user.setBio(userModel.getBio());
            userRepository.save(user);

            return "redirect:/in/"+user.getId();
        } catch (IOException e) {
            // Handle file saving exception
            e.printStackTrace();
            return "redirect:/welcome"; // return an error page or redirect as needed
        }

    }











}
