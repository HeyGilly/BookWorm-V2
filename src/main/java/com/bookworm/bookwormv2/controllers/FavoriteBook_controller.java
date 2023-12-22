package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.models.FavoriteBook;
import com.bookworm.bookwormv2.models.Reviews;
import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import com.bookworm.bookwormv2.repository.FavoriteBookRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class FavoriteBook_controller {

    private final UserRepository userRepository;
    private final BookshelfRepository bookshelfRepository;
    private final FavoriteBookRepository favoriteBookRepository;

    public FavoriteBook_controller(UserRepository userRepository,
                                   BookshelfRepository bookshelfRepository,
                                   FavoriteBookRepository favoriteBookRepository) {
        this.userRepository = userRepository;
        this.bookshelfRepository = bookshelfRepository;
        this.favoriteBookRepository = favoriteBookRepository;
    }

    @PostMapping("/favoriteBook/{userId}/{bookId}")
    public String favoriteBook(@ModelAttribute("favBookObject") FavoriteBook favoriteBook, @PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {

        User currentUser = userRepository.findUserById(userId);
        Bookshelf currentFavBook = bookshelfRepository.findBookById(bookId);

        favoriteBook.setUserId(currentUser);
        favoriteBook.setBookId(currentFavBook);

        favoriteBookRepository.save(favoriteBook);
        return "redirect:/single/"+currentFavBook.getId();
    }

    @PostMapping("/unFavoriteBook/{userId}/{bookId}")
    public String unFavoriteBook(@ModelAttribute("favBookObject") FavoriteBook favoriteBook, @PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {

        User currentUser = userRepository.findUserById(userId);
        Bookshelf currentFavBook = bookshelfRepository.findBookById(bookId);

        FavoriteBook favBook = favoriteBookRepository.findByUserIdAndBookId(currentUser, currentFavBook);

        favoriteBookRepository.delete(favBook);

        return "redirect:/single/"+currentFavBook.getId();
    }


}
