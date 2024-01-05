package com.bookworm.bookwormv2.models;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "BEST_FRIENDS")
public class BestFriends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FRIENDSHIP_ID")
    private long friendshipId;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "FRIEND_ID")
    private User friend_id;
    @Column(name = "STATUS")
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", updatable = false)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    public BestFriends() {
    }

    public BestFriends(long friendshipId, User user, User friend_id, String status, Date createdAt, Date updatedAt) {
        this.friendshipId = friendshipId;
        this.user = user;
        this.friend_id = friend_id;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(long friendshipId) {
        this.friendshipId = friendshipId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(User friend_id) {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}
