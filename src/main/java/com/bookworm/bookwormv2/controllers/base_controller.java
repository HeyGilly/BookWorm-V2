package com.bookworm.bookwormv2.controllers;

import org.springframework.ui.Model;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class base_controller {

    private final BookshelfRepository bookshelfRepository;

    public base_controller(BookshelfRepository bookshelfRepository) {
        this.bookshelfRepository = bookshelfRepository;
    }


    @GetMapping("/")
    public String home(Model model){
        // The Reviews are going to be in descending order
        model.addAttribute("bookshelf", bookshelfRepository.findAll());
        return "base/index";}


    @GetMapping("/aboutBookworm")
    public String aboutPage(){
        return "base/about";
    }

}
