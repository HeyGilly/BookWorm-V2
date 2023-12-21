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
    public String edit_Review(@PathVariable("id") Long id, @ModelAttribute("editReviewByNew")Reviews reviews){

        //-- Grabs the data of the review you wanted to edit. The Original Data
        Reviews singleReview = reviewRepository.findReviewById(id);

        //-- Checks whether the input and original title are the same and ifs it's not empty
        if (!Objects.equals(singleReview.getTitle(), reviews.getTitle()) && !reviews.getTitle().isEmpty()){
            //-- Saves the input that changed.
            singleReview.setTitle(reviews.getTitle());
        }else{
            //-- Keeping the title the same.
            singleReview.setTitle(singleReview.getTitle());
        }

        //-- Checks If the input value is not empty
        if (!reviews.getBody().isEmpty()){
            //-- Saves the value that changed.
            singleReview.setBody(reviews.getBody());
        }else{
            //-- Saves the original body
            singleReview.setBody(singleReview.getBody());
        }

        //-- What ever we get from the value from the rating, we shall save.
        singleReview.setRating(reviews.getRating());

        //-- Save all the info in the database.
        reviewRepository.save(singleReview);


        return "redirect:/in/"+ singleReview.getUser().getId();
    }
}
