package com.bookworm.bookwormv2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER_REVIEWS")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private long id;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String Body;

    @ManyToOne
    @JoinColumn (name = "BOOKSHELF_ID")
    private Bookshelf bookshelf;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<LikedReview> likedReviews;

    @Column(name = "LIKED_COUNT")
    private long likedCount;

    public Reviews() {}

    public Reviews(long id, int rating, String title, String body, Bookshelf bookshelf, User user, List<LikedReview> likedReviews, long likedCount) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        Body = body;
        this.bookshelf = bookshelf;
        this.user = user;
        this.likedReviews = likedReviews;
        this.likedCount = likedCount;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getBody() {return Body;}
    public void setBody(String body) {Body = body;}

    public Bookshelf getBookshelf() {return bookshelf;}
    public void setBookshelf(Bookshelf bookshelf) {this.bookshelf = bookshelf;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public List<LikedReview> getLikedReviews() {
        return likedReviews;
    }

    public void setLikedReviews(List<LikedReview> likedReviews) {
        this.likedReviews = likedReviews;
    }

    public long getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(long likedCount) {
        this.likedCount = likedCount;
    }

    public long addLikeCount(){
       return this.likedCount += 1L;
    }

    public long minusLikeCount(){
        return this.likedCount -= 1L;
    }

}
