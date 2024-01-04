package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.BestFriends;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.BestFriendRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class notification_controller {

    private final UserRepository userRepository;
    private final BestFriendRepository BestFriendRepository;

    public notification_controller(UserRepository userRepository, com.bookworm.bookwormv2.repository.BestFriendRepository bestFriendRepository) {
        this.userRepository = userRepository;
        BestFriendRepository = bestFriendRepository;
    }

    @GetMapping("/notification")
    public String notificationPage(Model model){

        User currentUser = userRepository.findUserById(3);
        model.addAttribute("user", currentUser);

        List<BestFriends> allFriends = BestFriendRepository.findAllByUser(currentUser);
        model.addAttribute("allFriends", allFriends);

        return "main/notification";

    }




}
