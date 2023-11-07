package com.bookworm.bookwormv2.models;

public class user {

    private long id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private String bio;

    //--Empty Constructor
    public user() {
    }

    //-- Whole Constructor
    public user(long id, String first_name, String last_name, String username, String email, String password, String bio) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
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


}
