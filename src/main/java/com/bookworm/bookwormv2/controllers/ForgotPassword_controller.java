package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.UserRepository;
import com.bookworm.bookwormv2.service.EmailService;
import jakarta.mail.internet.AddressException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ForgotPassword_controller {

    private final UserRepository userRepository;

    private final EmailService emailService;

    public ForgotPassword_controller(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(){
        return "SignUp/forgotPassword";
    }


    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) throws AddressException {
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

                String siteURL = request.getRequestURL().toString().replace(request.getServletPath(), "");

                String resetPasswordLink = siteURL + "/reset?token=" + userWhomForgotPassword.getResetToken();

                String content = "To change password, click on link. Thank you! " + resetPasswordLink;

                //send email to user
                emailService.sendSimpleEmail("noreply@bookworm.com",userWhomForgotPassword.getEmail(), "Password Reset", content);

            } else {
                //No user found with the provided email.
                model.addAttribute("error", "No user found with the provided email.");
            }

        } else {
            model.addAttribute("error", "Provide an email please.");

        }
        return "SignUp/forgotPassword";
    }


    //=== Process reset password form
    @GetMapping("/reset")
    public String displayResetPasswordPage(@RequestParam("token") String token, Model model){
        User currentUser = userRepository.findUserByResetToken(token);

        if (currentUser != null){
            model.addAttribute("token", token);
        }else{
            model.addAttribute("error", "This is an invalid password reset link.");
        }

        return "SignUp/resetPassword";
    }

    //
    @PostMapping("/reset")
    public String setNewPassword(HttpServletRequest request, Model model) throws AddressException {
        String newPassword = request.getParameter("newPasswordInput");
        String token = request.getParameter("token");

        User currentUser = userRepository.findUserByResetToken(token);

        if (currentUser != null){
            //-- Update Password
            currentUser.setPassword(newPassword);
            //-- Reset Token
            currentUser.setResetToken(null);
            //-- Save Token
            userRepository.save(currentUser);
            //-- Email sent out to notify successful
            emailService.sendSimpleEmail("noreply@bookworm.com" ,currentUser.getEmail(), "Password Completed", "You have successfully changed your password.");
            return "redirect:/";
        }else{
            //-- Send Message Out - error
            model.addAttribute("error", "Something went wrong!?");
        }
        return "SignUp/resetPassword";
    }




}
