package com.bookworm.bookwormv2.dto;

public class FriendDTO {
    private Long userId;
    private String friendUsername;
    private String status;
    private String profilePicture;

    public FriendDTO() {
    }

    public FriendDTO(Long userId, String friendUsername, String status, String profilePicture) {
        this.userId = userId;
        this.friendUsername = friendUsername;
        this.status = status;
        this.profilePicture = profilePicture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
