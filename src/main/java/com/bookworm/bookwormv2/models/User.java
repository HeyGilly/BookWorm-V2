package com.bookworm.bookwormv2.models;


import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

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
    @Column(name="ROLE")
    private String role;

    //== This is used to handle the file upload.
    //== When Using Transient, meaning that you are usually saving the image to a file system, or a cloud storage.
    @Transient //== Meaning the file itself won't be stored in the database
    private MultipartFile profilePictureFile;

    //== This is used to store the path associated with the profile picture.
    @Column(name="PROFILE_PICTURE_PATH")
    private String profilePicturePath;  // Store the file path or metadata here

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Reviews> reviewsList;

    @OneToMany(mappedBy = "userFavorite", cascade = CascadeType.ALL)
    private List<FavoriteGenre> favoriteGenres;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<FavoriteBook> favoriteBookList;

    @Column(name = "RESET_TOKEN")
    private String resetToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<BestFriends> friendships;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LikedReview> likedReviews;

    //--Empty Constructor
    public User() {
    }

    //-- Whole Constructor
    public User(long id, String first_name, String last_name, String username, String email, String password, String bio, String role, MultipartFile profilePictureFile, String profilePicturePath, List<Reviews> reviewsList, List<FavoriteGenre> favoriteGenres, List<FavoriteBook> favoriteBookList, String resetToken, Set<BestFriends> friendships, List<LikedReview> likedReviews) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.role = role;
        this.profilePictureFile = profilePictureFile;
        this.profilePicturePath = profilePicturePath;
        this.reviewsList = reviewsList;
        this.favoriteGenres = favoriteGenres;
        this.favoriteBookList = favoriteBookList;
        this.resetToken = resetToken;
        this.friendships = friendships;
        this.likedReviews = likedReviews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MultipartFile getProfilePictureFile() {
        return profilePictureFile;
    }

    public void setProfilePictureFile(MultipartFile profilePictureFile) {
        this.profilePictureFile = profilePictureFile;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public List<Reviews> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<Reviews> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public List<FavoriteGenre> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(List<FavoriteGenre> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public List<FavoriteBook> getFavoriteBookList() {
        return favoriteBookList;
    }

    public void setFavoriteBookList(List<FavoriteBook> favoriteBookList) {
        this.favoriteBookList = favoriteBookList;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Set<BestFriends> getFriendships() {
        return friendships;
    }

    public void setFriendships(Set<BestFriends> friendships) {
        this.friendships = friendships;
    }

    public List<LikedReview> getLikedReviews() {
        return likedReviews;
    }

    public void setLikedReviews(List<LikedReview> likedReviews) {
        this.likedReviews = likedReviews;
    }
}
