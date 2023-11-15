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
