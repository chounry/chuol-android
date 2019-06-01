package com.group6.choul.models;

import com.squareup.moshi.Json;

public class UserModel {
    @Json(name = "id")
    int id;
    @Json(name = "username")
    String username;
    @Json(name = "fname")
    String fname;
    @Json(name = "lname")
    String lname;
    @Json(name = "phone")
    String phone;
    @Json(name = "email")
    String email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
