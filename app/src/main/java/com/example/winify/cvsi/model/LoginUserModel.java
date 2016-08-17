package com.example.winify.cvsi.model;

/**
 * Created by diana on 8/17/16.
 */
public class LoginUserModel {

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

    private String email;
    private String password;

    public LoginUserModel() {
        this.email = "cvsiserver@gmail.com";
        this.password = "cvsiserver";
    }
}