package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class notification_controller {

    private final UserRepository userRepository;

    public notification_controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/notification")
    public String notificationPage(Model model){

        User currentUser = userRepository.findUserById(11);
        model.addAttribute("user", currentUser);

        return "main/notification";

    }




}
