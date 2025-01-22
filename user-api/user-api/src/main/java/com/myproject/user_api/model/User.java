package com.myproject.user_api.model;

public class User {
    private String username;
    private String password;
    private String email;

    //Constructor
    public User(String username, String password, String email ){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters ve Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




