package com.bookworm.bookwormv2.models;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

//-- Entity refers to a Java class that represents an object or record in your database.
//-- Serves as a bridge between your Java application and the database.
//-- The annotation Entity tells spring data JPA that this class is an entity and should be mapped ot the database table.
@Entity
//-- Used to specify the name of the database table that corresponds to your entity class.
//-- Used to customize the table name if it should be different from the default naming convention.
@Table(name = "USER")
public class User {
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="FIRST_NAME")
    private String first_name;
    @Column(name="LAST_NAME")
    private String last_name;
    @Column(name="USERNAME")
    private String username;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="BIO")
    private String bio;
    @Column(name="PROFILE_PICTURE_PATH")
    private String profilePicturePath;  // Store the file path or metadata here


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Reviews> reviewsList;

    @OneToMany(mappedBy = "userFavorite", cascade = CascadeType.ALL)
    private List<FavoriteGenre> favoriteGenres;

    //--Empty Constructor
    public User() {
    }

    //-- Whole Constructor


    public User(long id, String first_name, String last_name, String username, String email, String password, String bio, String profilePicturePath, List<Reviews> reviewsList, List<FavoriteGenre> favoriteGenres) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePicturePath = profilePicturePath;
        this.reviewsList = reviewsList;
        this.favoriteGenres = favoriteGenres;
    }

    //-- Getters and Setters
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getBio() {return bio;}
    public void setBio(String bio) {this.bio = bio;}

    public List<Reviews> getReviewsList() {return reviewsList;}
    public void setReviewsList(List<Reviews> reviewsList) {this.reviewsList = reviewsList;}

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public List<FavoriteGenre> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(List<FavoriteGenre> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }
}
