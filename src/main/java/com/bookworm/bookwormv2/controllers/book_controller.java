package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.http.ResponseEntity;


@RestController
public class book_controller {

    private final BookshelfRepository bookshelfRepository;

    public book_controller(BookshelfRepository bookshelfRepository) {
        this.bookshelfRepository = bookshelfRepository;
    }

    @GetMapping("/book/search")
    public ResponseEntity<List<Bookshelf>> searchBooks(@RequestParam String title) {
        try {
            List<Bookshelf> books = bookshelfRepository.findByTitleContaining(title);
            if (books.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            // Log the exception details for debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

