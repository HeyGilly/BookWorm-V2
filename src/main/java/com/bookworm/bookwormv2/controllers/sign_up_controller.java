package com.bookworm.bookwormv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sign_up_controller {

    @GetMapping("/login")
    public String login(){
        return "SignUp/login";
    }

    @GetMapping("/Sign-up")
    public String signUp(){
        return "SignUp/register";
    }


}
