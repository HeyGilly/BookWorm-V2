package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class sign_up_controller {
    public final UserRepository userRepository;

    public sign_up_controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "SignUp/login";
    }


    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "SignUp/register";
    }


    @PostMapping("/sign-up")
    public String greetingSubmit(@ModelAttribute("user") User user) {

        //-- Creates a new User in Database
        userRepository.save(user);
        return "redirect:/login";
    }


}
