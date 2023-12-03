package com.bookworm.bookwormv2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "FAVORITE_GENRE")
public class FavoriteGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_FAVORITE_GENRE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userFavorite;


    @ManyToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;


    public FavoriteGenre() {
    }

    public FavoriteGenre(long id, User userFavorite, Genre genre) {
        this.id = id;
        this.userFavorite = userFavorite;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserFavorite() {
        return userFavorite;
    }

    public void setUserFavorite(User userFavorite) {
        this.userFavorite = userFavorite;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}





