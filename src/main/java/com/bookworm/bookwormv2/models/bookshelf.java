package com.bookworm.bookwormv2.models;

public class bookshelf {

    private long id;
    private long isbn;
    private String title;
    private String author;
    private String book_image;
    private String description;
    private String genre;
    private int page_count;
    private String date_published;
    private int rating;

    //-- Empty Constructor
    public bookshelf() {}

    //-- Whole Container
    public bookshelf(long id, long isbn, String title, String author, String book_image, String description, String genre, int page_count, String date_published, int rating) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.book_image = book_image;
        this.description = description;
        this.genre = genre;
        this.page_count = page_count;
        this.date_published = date_published;
        this.rating = rating;
    }

    //-- Getters and Setters
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public long getIsbn() {return isbn;}
    public void setIsbn(long isbn) {this.isbn = isbn;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getBook_image() {return book_image;}
    public void setBook_image(String book_image) {this.book_image = book_image;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}

    public int getPage_count() {return page_count;}
    public void setPage_count(int page_count) {this.page_count = page_count;}

    public String getDate_published() {return date_published;}
    public void setDate_published(String date_published) {this.date_published = date_published;}

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}
}