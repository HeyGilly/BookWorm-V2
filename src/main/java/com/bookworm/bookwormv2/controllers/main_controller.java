package com.bookworm.bookwormv2.controllers;

import com.bookworm.bookwormv2.dto.FriendDTO;
import com.bookworm.bookwormv2.models.*;
import com.bookworm.bookwormv2.repository.*;
import com.bookworm.bookwormv2.service.BestFriendService;
import com.bookworm.bookwormv2.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class main_controller {
    //-- Book Repository to gather all books
    private final BookshelfRepository bookshelfRepo;
    //-- Review Repo to gather information
    private final ReviewRepository reviewRepository;
    //-- User Repo to gather information of user;
    private final UserRepository userRepository;
    //--
    public final FileService fileServiceRepository;
    //--All Genre
    private final GenreRepository genreRepository;
    //-- Favorite Genre
    private final FavoriteGenreRepository favoriteGenreRepository;

    //-- Favorite Book Data
    public final FavoriteBookRepository favoriteBookRepository;
    private final BestFriendRepository bestFriendRepository;

    //-- BestFriend Service
    private BestFriendService bestFriendService;

    //-- Liked Repo
    private final LikedRepository likedRepository;

    //-- Constructor
    public main_controller(BookshelfRepository bookshelfRepo, ReviewRepository reviewRepository, UserRepository userRepository, FileService fileServiceRepository, GenreRepository genreRepository, FavoriteGenreRepository favoriteGenreRepository, FavoriteBookRepository favoriteBookRepository, BestFriendRepository bestFriendRepository, BestFriendService bestFriendService, LikedRepository likedRepository) {
        this.bookshelfRepo = bookshelfRepo;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.fileServiceRepository = fileServiceRepository;
        this.genreRepository = genreRepository;
        this.favoriteGenreRepository = favoriteGenreRepository;
        this.favoriteBookRepository = favoriteBookRepository;
        this.bestFriendRepository = bestFriendRepository;
        this.bestFriendService = bestFriendService;
        this.likedRepository = likedRepository;
    }

    //-- This function is going to help us, so we don't have to repeat what we want as in the books by genre and the list of genres.
    private void addExistingDataToModel(Model model) {
        //-- Retrieves all books from database, using the bookshelf Repo
        List<Bookshelf> allBooks = bookshelfRepo.findAll();
        //-- Creates an empty list to store the unique genres
        //--  a forEach loop through each book in the allBooks list.
        List<String> uniqueGenres = new ArrayList<>();
        //-- Loops through the books and add unique genres to the array
        allBooks.forEach(book -> {
            if( book.getGenre() != null) {
                //-- Stores all books genre inside the genre variable
                String genre = book.getGenre().substring(0, 1).toUpperCase() + book.getGenre().substring(1);
                //-- This condition see if the empty array doesn't contain the genre
                if (!uniqueGenres.contains(genre)) {
                    //-- the empty array does NOT contain the genre, we add it to the empty array.
                    //-- This will capitalize the first character
                    uniqueGenres.add(genre.substring(0, 1).toUpperCase() + genre.substring(1));
                }
            }
        });
        // Pass the unique genres to the Thymeleaf template
        model.addAttribute("AllGenres", uniqueGenres);
    }
    //-- Welcome Pages
    @GetMapping("/welcome")
    public String home(Model model){
        //-- find By Thriller Genre
        model.addAttribute("ThrillerBooks", bookshelfRepo.findAllByGenre("thriller"));
        model.addAttribute("FictionBooks", bookshelfRepo.findAllByGenre("fiction"));
        //-- Genre
        addExistingDataToModel(model);
        return "main/introduction-page";
    }


    @GetMapping("/single/{id}")
    public String singleBook(Model model, @PathVariable("id") long bookId){

        //-- find user
        User currentUser =  userRepository.findUserById(11);
        model.addAttribute("user", currentUser);

        long BookByISBN = bookshelfRepo.findById(bookId).get().getIsbn();

        model.addAttribute("ISBNbook", BookByISBN);
        model.addAttribute("singleBookInfo", bookshelfRepo.findByIsbn(BookByISBN));
        //-- Find all books in our database based on main book genre
        String genre = bookshelfRepo.findByIsbn(BookByISBN).getGenre();
        model.addAttribute("booksOfSameGenre", bookshelfRepo.findAllByGenre(genre));

        long book_id = bookshelfRepo.findByIsbn(BookByISBN).getId();
        List<Reviews> allReviewFromBook = reviewRepository.findReviewByBookshelf_IdSorted(book_id);
        model.addAttribute("bookReview", allReviewFromBook);

        //-- For when reviews are written
        model.addAttribute("Reviews", new Reviews());

        //-- When a user favorite a book
        model.addAttribute("favBookObject", new FavoriteBook());

        List<FavoriteBook> favBooksList = favoriteBookRepository.findAllByUserId(currentUser);
        Bookshelf bookshelf = bookshelfRepo.findBookById(bookId);

        String isFavorite = "NotFaved";
        for (FavoriteBook favBook : favBooksList) {
            if (favBook.getBookId().getId() == bookshelf.getId()) {
                isFavorite = "AlreadyFaved";
                System.out.println("We have a book id that's in our favorites");
                break;
            }
        }

        model.addAttribute("faved", isFavorite);

        //-- For Users to like Reviews
        List<Boolean> userLikes = new ArrayList<>();
        for (Reviews singleReview : allReviewFromBook) {
            LikedReview userLikedReview = likedRepository.findByUserAndReview(currentUser, singleReview);
            // Add true if user liked the review, false otherwise
            userLikes.add(userLikedReview != null);
        }
        model.addAttribute("userLikes", userLikes);


        return "main/SingleBookPreview";
    }


    @PostMapping("/single/{id}")
    public String submitReview(@PathVariable("id") Long id, @ModelAttribute("Reviews") Reviews reviews) {
        Bookshelf bookshelf = bookshelfRepo.findById(id).orElseThrow(/* some exception */);

        //-- Review Setup
        reviews.setUser(userRepository.findUserById(11));
        reviews.setBookshelf(bookshelf);
        //-- reviews.setUser(reviews.getUser());
        System.out.println("After Setting: "+reviews.getBookshelf());
        reviewRepository.save(reviews);

        //-- Update Rating on Bookshelf
        bookshelf.calculateAverageRating();
        bookshelfRepo.save(bookshelf);

        return "redirect:/single/"+id;
    }




    @GetMapping("/in/{userId}")
    public String userProfile(Model model,@PathVariable("userId") long userId) {
        //-- User of Page
        User currentUser = userRepository.findUserById(userId);
        //-- find user
        model.addAttribute("user", currentUser);
        //-- Favorite Books
        List<FavoriteBook> favoriteBooks = favoriteBookRepository.findAllByUserId(currentUser);
        model.addAttribute("favoriteBooks", favoriteBooks);
        //-- find reviews of user
        model.addAttribute("usersReview", reviewRepository.findReviewByUserIdSorted(currentUser.getId()));
        //-- For the form to edit the review
        model.addAttribute("editReviewByNew", new Reviews());


        model.addAttribute("hideForNow", "hide");
        model.addAttribute("showForNow", "show");

        model.addAttribute("ListOfGenre", genreRepository.findAll());

        //-- Showing all friends
        List<FriendDTO> friends = bestFriendService.getFriendsForUser(currentUser.getId());
        model.addAttribute("allFriends", friends);

        //-- For Users to like Reviews
        List<Boolean> userLikes = new ArrayList<>();
        for (Reviews singleReview : reviewRepository.findReviewByUserIdSorted(currentUser.getId())) {
            LikedReview userLikedReview = likedRepository.findByUserAndReview(currentUser, singleReview);
            // Add true if user liked the review, false otherwise
            userLikes.add(userLikedReview != null);
        }
        model.addAttribute("userLikes", userLikes);

        return "main/userProfile";
    }


    @PostMapping("/in/{userId}")
    public String updateProfile(@RequestParam("favoriteGenres") String favoriteGenres,@ModelAttribute User userModel, @RequestParam("profilePictureFile") MultipartFile profilePictureFile, Model model, RedirectAttributes redirectAttributes){
        User user = userRepository.findUserById(userModel.getId());

        //-- Checks for an input value is empty.
        if (!favoriteGenres.isEmpty()) {
            long genreId = Long.parseLong(favoriteGenres);
            Genre genre = genreRepository.findById(genreId).orElse(null);
            //-- Checks if there is a genre or null
            if (genre != null) {
                // Check the number of favorite genres already associated with the user
                int favoriteGenreCount = favoriteGenreRepository.countByUserFavorite(user);
                //--Checks if you already have 5 genres in the database
                if (favoriteGenreCount < 5) {
                    // If less than 5 favorite genres, add the new one
                    FavoriteGenre favoriteGenre = new FavoriteGenre();
                    favoriteGenre.setUserFavorite(user);
                    favoriteGenre.setGenre(genre);
                    favoriteGenreRepository.save(favoriteGenre);
                } else {
                    // User already has 5 favorite genres
                    System.out.println("You already have 5 genres in your favorite. ");
                    //-- Shows a message if the user tries to get more than 5 genres
                    redirectAttributes.addFlashAttribute("hitMaxFavGenre", "You can only have a max of 5.");                }
            }
        }


        try {
            if (!profilePictureFile.isEmpty()) {
                // Handle the file and save its path to profilePicturePath
                // For example, you can save it to a directory and store the path in the database
                // Save the file and get the file path to the directory
                String filePath = fileServiceRepository.saveFile(profilePictureFile);
                // Set the file path in the user object
                user.setProfilePicturePath("img/profilePicture/" + filePath);
            }
            if (!userModel.getPassword().isEmpty()){
                user.setPassword(userModel.getPassword());
            }
            user.setFirst_name(userModel.getFirst_name());
            user.setLast_name(userModel.getLast_name());
            user.setEmail(userModel.getEmail());
            user.setUsername(userModel.getUsername());
            user.setBio(userModel.getBio());
            userRepository.save(user);


            return "redirect:/in/"+user.getId();
        } catch (IOException e) {
            // Handle file saving exception
            e.printStackTrace();
            return "redirect:/welcome"; // return an error page or redirect as needed
        }

    }
}
