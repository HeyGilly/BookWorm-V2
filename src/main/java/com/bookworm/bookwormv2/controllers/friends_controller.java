package com.bookworm.bookwormv2.controllers;


import com.bookworm.bookwormv2.dto.FriendDTO;
import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import com.bookworm.bookwormv2.service.BestFriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class friends_controller {
    private final UserRepository userRepository;
    private final BestFriendService bestFriendService;

    public friends_controller(UserRepository userRepository, BestFriendService bestFriendService) {
        this.userRepository = userRepository;
        this.bestFriendService = bestFriendService;
    }

    @GetMapping("/in/{userId}/friends")
    public String bestFriends(Model model, @PathVariable("userId") Long userId){
        //-- User of Page
        User currentUser = userRepository.findUserById(userId);
        model.addAttribute("user", currentUser);

        //-- Showing all friends
        List<FriendDTO> friends = bestFriendService.getFriendsForUser(currentUser.getId());
        model.addAttribute("allFriends", friends);
        return "main/bestFriends";
    }


}
