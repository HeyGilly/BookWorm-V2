package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import com.bookworm.bookwormv2.service.FileService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@Controller
public class sign_up_controller {
    public final UserRepository userRepository;

    private final FileService fileService;

    public sign_up_controller(UserRepository userRepository, FileService fileService) {
        this.userRepository = userRepository;
        this.fileService = fileService;
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
    public String greetingSubmit(@ModelAttribute("user") @Valid User user, @RequestParam("profilePicturePath") MultipartFile file) {
        try {
            // Check if img is uploaded
            if (!file.isEmpty()) {
                //== Create a unique file name with filename and a random number generator
                String fileName = "user_" + UUID.randomUUID() + "_" + file.getOriginalFilename();
                //== Calling the File Service to run its method
                fileService.saveFile(file, fileName);
                // Set the file path in the User object
                //== Will update the Database with the directory and File name
                user.setProfilePicturePath("img/profilePicture/" + fileName);
            }
            // Creates a new User in the Database
            userRepository.save(user);
            return "redirect:/login";
        } catch (IOException e) {
            System.out.println("Error occurred during file processing: " + e.getMessage());
            return "redirect:/sign-up"; // Redirect back to the login page with an error message
        }
    }


}
