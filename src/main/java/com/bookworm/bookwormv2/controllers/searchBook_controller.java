package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.repository.BookshelfRepository;
import com.bookworm.bookwormv2.repository.ReviewRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class searchBook_controller {

    private final BookshelfRepository bookshelfRepository;
    private final ReviewRepository reviewRepository;

    public searchBook_controller(BookshelfRepository bookshelfRepository, ReviewRepository reviewRepository) {
        this.bookshelfRepository = bookshelfRepository;
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/api/book")
    public String createBook(@ModelAttribute Bookshelf bookshelf, Model model, HttpServletRequest request) {

        System.out.println(bookshelf);
        System.out.println(bookshelf.getIsbn());
        System.out.println(bookshelf.getTitle());
        System.out.println(bookshelf.getRating());
        System.out.println(bookshelf.getGenre());
        System.out.println(bookshelf.getAuthor());
        System.out.println(bookshelf.getCover_page());
        System.out.println(bookshelf.getDescription());
        System.out.println(bookshelf.getDate_published());
        System.out.println(bookshelf.getPage_count());
        System.out.println(bookshelf.getGoogle_play());

        //Changing rating double to a rating int
        double googleAPIRatingDouble = bookshelf.getRating();
        int googleAPIRating = (int) bookshelf.getRating();
        bookshelf.setRating(googleAPIRating);
        System.out.println("Reg: "+bookshelf.getRating());
        System.out.println("Int: "+googleAPIRating);
        System.out.println("Double: "+googleAPIRatingDouble);

        // Assuming findBookByTitle returns a Bookshelf object if found, null otherwise
        Bookshelf existingBook = bookshelfRepository.findBookByIsbn(bookshelf.getIsbn());
        System.out.println("Does the book exist? "+existingBook);

        long book_id = 0;

        if (existingBook != null) {
            System.out.println("There is a book with the same ISBN");
            // You can process the existing book as needed
//            String referer = request.getHeader("Referer");
//            return "redirect:" + referer;
            // Other processing
            model.addAttribute("singleBookInfo", existingBook);
            model.addAttribute("singleBookCover", existingBook.getCover_page());

            //-- Find the Genre of certain book, then find all book with that genre
            String genre = bookshelfRepository.findByIsbn(existingBook.getIsbn()).getGenre();
            model.addAttribute("bookGenre", bookshelfRepository.findAllByGenre(genre));
//
            //-- Find the book id, then find all reviews associated with the book id.
            book_id = bookshelfRepository.findByIsbn(existingBook.getIsbn()).getId();
            model.addAttribute("bookReview", reviewRepository.findReviewByBookshelf_Id(book_id));

        } else {
            System.out.println("Book before saved!");
            bookshelfRepository.save(bookshelf);
            System.out.println("Book saved!");
            // Other processing
            model.addAttribute("singleBookInfo", bookshelf);
            model.addAttribute("singleBookCover", bookshelf.getCover_page());

            //-- Find the Genre of certain book, then find all book with that genre
            String genre = bookshelfRepository.findByIsbn(bookshelf.getIsbn()).getGenre();
            model.addAttribute("bookGenre", bookshelfRepository.findAllByGenre(genre));
//
            //-- Find the book id, then find all reviews associated with the book id.
            book_id = bookshelfRepository.findByIsbn(bookshelf.getIsbn()).getId();
            model.addAttribute("bookReview", reviewRepository.findReviewByBookshelf_Id(book_id));
        }

        return "redirect:/single/"+book_id;
    }
}




