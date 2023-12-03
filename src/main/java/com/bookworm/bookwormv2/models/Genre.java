package com.bookworm.bookwormv2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENRE_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<FavoriteGenre> usersWhoLike;

    public Genre() {}

    public Genre(long id, String name, List<FavoriteGenre> usersWhoLike) {
        this.id = id;
        this.name = name;
        this.usersWhoLike = usersWhoLike;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FavoriteGenre> getUsersWhoLike() {
        return usersWhoLike;
    }

    public void setUsersWhoLike(List<FavoriteGenre> usersWhoLike) {
        this.usersWhoLike = usersWhoLike;
    }
}
