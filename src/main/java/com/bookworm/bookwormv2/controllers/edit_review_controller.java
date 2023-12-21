package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Reviews;
import com.bookworm.bookwormv2.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class edit_review_controller {
    private final ReviewRepository reviewRepository;

    public edit_review_controller(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/review/{id}")
    public String edit_Review(@PathVariable("id") Long id, @ModelAttribute("editReviewByNew")Reviews reviews, BindingResult result){

        if (result.hasErrors()) {
            return "redirect:/welcome";
        }
        System.out.println("url id: "+id);
        Reviews singleReview = reviewRepository.findReviewById(id);
        System.out.println("__________________");
        System.out.println("user id: "+singleReview.getUser().getId());
        System.out.println("Username: "+singleReview.getUser().getUsername());
        System.out.println("__________ORIGINAL________");
        System.out.println("original Title: "+singleReview.getTitle());
        System.out.println("original Body: "+singleReview.getBody());
        System.out.println("original Rating: "+singleReview.getRating());

        System.out.println("_________INPUT_________");
        System.out.println("Input Title: " + reviews.getTitle());
        System.out.println("Input Body: " + reviews.getBody());
        System.out.println("Input Rating: " + reviews.getRating());
        System.out.println("__________________");
        System.out.println("reviews: "+singleReview);

        if (!Objects.equals(singleReview.getTitle(), reviews.getTitle()) && !reviews.getTitle().isEmpty()){
            System.out.println("The Inputs title does not match");
            singleReview.setTitle(reviews.getTitle());
            System.out.println("Setting the title");
        }else{
            singleReview.setTitle(singleReview.getTitle());
            System.out.println("Keeping the title");
        }

        if (!reviews.getBody().isEmpty()){
            System.out.println("There was an input in the body review");
            singleReview.setBody(reviews.getBody());
            System.out.println("Setting the body");
        }else{
            singleReview.setBody(singleReview.getBody());
            System.out.println("Keeping the same body");
        }

        singleReview.setRating(reviews.getRating());

        reviewRepository.save(singleReview);






        //-- Updating the review with new values from the form
         /*       singleReview.setTitle(reviews.getTitle());
        singleReview.setBody(reviews.getBody());
        */


        return "redirect:/in/11";
    }
}
