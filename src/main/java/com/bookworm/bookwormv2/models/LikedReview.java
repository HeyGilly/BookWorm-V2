package com.bookworm.bookwormv2.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LIKED_REVIEWS")
public class LikedReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "REVIEW_ID", referencedColumnName = "REVIEW_ID")
    private Reviews review;

    @Column(name = "LIKED_DATE")
    private Date likedDate;

    public LikedReview() {}

    public LikedReview(long id, User user, Reviews review, Date likedDate) {
        this.id = id;
        this.user = user;
        this.review = review;
        this.likedDate = likedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reviews getReview() {
        return review;
    }

    public void setReview(Reviews review) {
        this.review = review;
    }

    public Date getLikedDate() {
        return likedDate;
    }

    public void setLikedDate(Date likedDate) {
        this.likedDate = likedDate;
    }
}
