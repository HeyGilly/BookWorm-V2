package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.FavoriteGenre;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.FavoriteGenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class deletion_favGenre_controller {
    private final FavoriteGenreRepository favoriteGenreRepository;

    public deletion_favGenre_controller(FavoriteGenreRepository favoriteGenreRepository) {
        this.favoriteGenreRepository = favoriteGenreRepository;
    }

    @PostMapping("/favoriteGenre/delete/{id}")
    public String deleteReview(@PathVariable("id") Long id){
        System.out.println("Delete Genre");
        Optional<FavoriteGenre> genre = favoriteGenreRepository.findById(id);
        User currentUser = genre.get().getUserFavorite();

        favoriteGenreRepository.delete(genre.get());
        System.out.println( "Fav Genre deleted successfully.");
        return "redirect:/in/"+ currentUser.getId();
    }

}
