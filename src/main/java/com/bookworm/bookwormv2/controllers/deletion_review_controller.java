package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Reviews;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class deletion_review_controller {
    private final ReviewRepository reviewRepository;

    public deletion_review_controller(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable("id") Long id){
        System.out.println("Anything");
            Optional<Reviews> review = reviewRepository.findById(id);
            User currentUser = review.get().getUser();
        reviewRepository.delete(review.get());
        System.out.println( "Review deleted successfully.");
        return "redirect:/in/"+ currentUser.getId();
    }
}
