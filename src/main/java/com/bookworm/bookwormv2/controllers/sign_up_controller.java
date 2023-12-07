package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import com.bookworm.bookwormv2.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class sign_up_controller {
    public final UserRepository userRepository;
    public final FileService fileServiceRepository;


    public sign_up_controller(UserRepository userRepository, FileService fileServiceRepository) {
        this.userRepository = userRepository;
        this.fileServiceRepository = fileServiceRepository;
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
    public String greetingSubmit(Model model, @ModelAttribute("user") User user, @RequestParam("profilePictureFile") MultipartFile profilePictureFile) {


        List<String> errorMessages = new ArrayList<>();

        if (3 > user.getFirst_name().length() || user.getFirst_name().length() > 25 || user.getFirst_name().isEmpty()) {
            errorMessages.add("First name must be between 3-25 characters");
        }

        if (3 > user.getLast_name().length() || user.getLast_name().length() > 25 || user.getLast_name().isEmpty()) {
            errorMessages.add("Last name must be between 3-25 characters");
        }

        if (5 > user.getUsername().length() || user.getUsername().length() > 15 || user.getUsername().isEmpty()) {
            errorMessages.add("Username must be between 5-15 characters");
        }

        if (!user.getEmail().contains("@") || (!user.getEmail().endsWith(".com") && !user.getEmail().endsWith(".edu") && !user.getEmail().endsWith(".org"))) {
            errorMessages.add("Email must be a valid email address");
        }

        if (!errorMessages.isEmpty()) {
            // There are validation errors, so add error messages to the model and return
                model.addAttribute("errorMessages", errorMessages);
            return "SignUp/register";
        }


        try {

            if (!profilePictureFile.isEmpty()){
                // Handle the file and save its path to profilePicturePath
                // For example, you can save it to a directory and store the path in the database
                // Save the file and get the file path to the directory
                String filePath = fileServiceRepository.saveFile(profilePictureFile);

                // Set the file path in the user object
                user.setProfilePicturePath("img/profilePicture/" +filePath);
            }

            // Creates a new User in the Database
            userRepository.save(user);
            return "redirect:/login";
        } catch (IOException e) {
            // Handle file saving exception
            e.printStackTrace();
            return "redirect:/sign-up"; // return an error page or redirect as needed
        }


    }
}
