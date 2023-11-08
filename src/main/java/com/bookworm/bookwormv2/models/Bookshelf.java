package com.bookworm.bookwormv2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOKSHELF")
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private long id;
    @Column(name = "ISBN")
    private long isbn;
    @Column(name = "BOOK_TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "DATA_PUBLISHED")
    private String date_published;
    @Column(name = "COVER_PAGE")
    private String cover_page;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "PAGE_COUNT")
    private int page_count;
    @Column(name = "RATING")
    private int rating;

    //-- Empty Constructor
    public Bookshelf() {}

    //-- Whole Container
    public Bookshelf(long id, long isbn, String title, String author, String cover_page, String description, String genre, int page_count, String date_published, int rating) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.cover_page =cover_page;
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

    public String getCover_page() {return cover_page;}
    public void setCover_page(String cover_page) {this.cover_page = cover_page;}

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
