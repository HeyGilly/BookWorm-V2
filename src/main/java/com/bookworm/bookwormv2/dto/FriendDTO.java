package com.bookworm.bookwormv2.dto;

public class FriendDTO {
    private String friendUsername;
    private String status;

    public FriendDTO() {
    }

    public FriendDTO(String friendUsername, String status) {
        this.friendUsername = friendUsername;
        this.status = status;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
