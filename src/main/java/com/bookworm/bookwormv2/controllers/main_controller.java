package com.bookworm.bookwormv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main_controller {

    @GetMapping("/welcome-page")
    public String home(){
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
