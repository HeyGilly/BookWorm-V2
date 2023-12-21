package com.bookworm.bookwormv2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "FAVORITE_BOOKS")
public class FavoriteBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_FAVORITE_BOOK_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;


    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Bookshelf bookId;

    public FavoriteBook() {}

    public FavoriteBook(long id, User userId, Bookshelf bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Bookshelf getBookId() {
        return bookId;
    }

    public void setBookId(Bookshelf bookId) {
        this.bookId = bookId;
    }
}
