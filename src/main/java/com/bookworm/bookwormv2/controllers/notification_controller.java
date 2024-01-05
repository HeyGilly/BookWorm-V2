package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.BestFriends;
import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.BestFriendRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    @PostMapping("/notification/newFriend/{id}")
    public String addingNewFriends(HttpServletRequest request, Model model, @PathVariable("id") Long id){
        BestFriends currentFriendship = BestFriendRepository.findByFriendshipId(id);

        if (currentFriendship != null) {
            currentFriendship.setStatus("accepted");
            currentFriendship.setUpdatedAt(new Date());
            BestFriendRepository.save(currentFriendship);
            System.out.println("Friendship found and processed.");
        } else {
            System.out.println("No friendship found with id: " + id);
            model.addAttribute("errorMessage", "No friendship found for the given ID");
        }

        // Get the referer URL from the request
        String referer = request.getHeader("Referer");
        // Redirect to the referer URL
        return "redirect:" + referer;
    }

    @PostMapping("/notification/unfriend/{id}")
    public String unfriend(HttpServletRequest request, Model model, @PathVariable("id") Long id){
        System.out.println("unfriending with id: " + id);

        BestFriends currentFriendship = BestFriendRepository.findByFriendshipId(id);

        if (currentFriendship != null) {
            BestFriendRepository.delete(currentFriendship);
            System.out.println("Friendship found and Denied.");
        } else {
            System.out.println("No friendship found with id: " + id);
            model.addAttribute("errorMessage", "Something happen, we got you cover. ");
        }

        // Get the referer URL from the request
        String referer = request.getHeader("Referer");
        // Redirect to the referer URL
        return "redirect:" + referer;
    }




}
