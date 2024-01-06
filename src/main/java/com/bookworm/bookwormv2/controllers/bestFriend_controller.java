package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.BestFriends;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.BestFriendRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class bestFriend_controller {

    private final UserRepository userRepository;
    private final BestFriendRepository bestFriendRepository;

    public bestFriend_controller(UserRepository userRepository, BestFriendRepository bestFriendRepository) {
        this.userRepository = userRepository;
        this.bestFriendRepository = bestFriendRepository;
    }

    @PostMapping("/addFriend/{id}/in/{userId}")
    public String favoriteBook(@PathVariable("id") long id, @PathVariable("userId") long userId) {

        System.out.println("The user with: "+id+" wants to add "+ userId);

        User loggedOnMember = userRepository.findUserById(id);
        User pageOwner = userRepository.findUserById(userId);

        BestFriends buddies = new BestFriends();
        buddies.setUser(loggedOnMember);
        buddies.setFriend(pageOwner);
        buddies.setStatus("pending");

        bestFriendRepository.save(buddies);

        return "redirect:/in/11";
    }



}
