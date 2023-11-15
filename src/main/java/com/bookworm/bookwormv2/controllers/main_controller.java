package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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



    @GetMapping("/welcome-page")
    public String home(Model model){
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
            String genre = book.getGenre().toLowerCase();
            //-- This condition see if the empty array doesn't contain the genre
            if (!uniqueGenres.contains(genre)) {
                //-- the empty array does NOT contain the genre, we add it to the empty array.
                uniqueGenres.add(genre);
            }
        });
        // Pass the unique genres to the Thymeleaf template
        model.addAttribute("AllGenres", uniqueGenres);


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
