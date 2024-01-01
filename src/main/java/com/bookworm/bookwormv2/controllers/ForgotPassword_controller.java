package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class ForgotPassword_controller {

    private final UserRepository userRepository;

    public ForgotPassword_controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(){
        return "SignUp/forgotPassword";
    }


    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        // Email
        String email = request.getParameter("email");
        System.out.println(email);

        if (!email.isEmpty()) {
            //Search for user with that email
            User userWhomForgotPassword = userRepository.findUserByEmail(email);

            if (userWhomForgotPassword != null) {
                // Generate a 36 random number that the user will have to verify to change password
                String keptSecret = UUID.randomUUID().toString();
                // Sets the token
                userWhomForgotPassword.setResetToken(keptSecret);
                //Save token to the Database
                userRepository.save(userWhomForgotPassword);
                //-- Send message that password change email has be sent.
                model.addAttribute("message", "We have sent a reset password link to your email.");
            } else {
                //No user found with the provided email.
                model.addAttribute("error", "No user found with the provided email.");
            }

        } else {
            model.addAttribute("error", "Provide an email please.");

        }
        return "SignUp/forgotPassword";
    }




}
