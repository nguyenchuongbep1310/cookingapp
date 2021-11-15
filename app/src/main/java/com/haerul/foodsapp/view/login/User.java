package com.haerul.foodsapp.view.login;

import android.text.TextUtils;
import android.util.Patterns;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    public boolean isValidEmail() {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword() {
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }

//    public boolean isValidEmail() {
//        if (email.equals("trantrunghau0102")) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public boolean isValidPassword() {
//        if (password.equals("12345678")) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

}
