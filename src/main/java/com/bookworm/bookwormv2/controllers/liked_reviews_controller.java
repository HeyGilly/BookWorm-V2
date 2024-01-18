package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.LikedReview;
import com.bookworm.bookwormv2.models.Reviews;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.ReviewRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import com.bookworm.bookwormv2.repository.LikedRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class liked_reviews_controller {
    private final ReviewRepository reviewRepository;
    private final LikedRepository likedRepository;
    private final UserRepository userRepository;

    public liked_reviews_controller(ReviewRepository reviewRepository,
                                    LikedRepository likedRepository,
                                    UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.likedRepository = likedRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/likedReview/{reviewId}")
    public String likeReview(@PathVariable("reviewId") long reviewId, Model model, HttpServletRequest request) {
        System.out.println("I Like this review.");
        Reviews currentReview = reviewRepository.findReviewById(reviewId);
        User currentUser = userRepository.findUserById(currentReview.getUser().getId());
        System.out.println("Creating a new LikedReview");
        LikedReview newLike = new LikedReview();
        newLike.setReview(currentReview);
        newLike.setUser(currentUser);
        newLike.setLikedDate(new Date());
        likedRepository.save(newLike);
        System.out.println("new Liked saved");
        System.out.println("Set Count");
        currentReview.setLikedCount(currentReview.addLikeCount());
        reviewRepository.save(currentReview);
        System.out.println("Count Saved?");
        // Redirect back to the single bookshelf view
        // Get the referring URL
        String referer = request.getHeader("Referer");

        // Redirect back to the referring URL
        return "redirect:" + referer;
    }

    @PostMapping("/unlikedReview/{reviewId}")
    public String unlikeReview(@PathVariable("reviewId") long reviewId, Model model, HttpServletRequest request) {
        System.out.println("I do not like this review.");
        //-- Find the current review
        Reviews currentReview = reviewRepository.findReviewById(reviewId);
        //-- Find Logged in User
        User currentUser = userRepository.findUserById(3);

        //-- find your spot in the Liked Reviews
        LikedReview currentStatus = likedRepository.findByUserAndReview(currentUser, currentReview);
        likedRepository.delete(currentStatus);

        //-- Decrease liked count
        currentReview.setLikedCount(currentReview.minusLikeCount());
        reviewRepository.save(currentReview);

        // Get the referring URL
        String referer = request.getHeader("Referer");

        // Redirect back to the referring URL
        return "redirect:" + referer;
    }




}