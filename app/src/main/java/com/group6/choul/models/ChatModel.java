package com.group6.choul.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.group6.choul.R;
import com.squareup.moshi.Json;

public class ChatModel {
    private int img_id, imgProfile;
    @Json(name = "username")
    String name;
    @Json(name = "time")
    String time;
    @Json(name = "title")
    String title;
    @Json(name = "message")
    String message;


    public ChatModel() {
        this.imgProfile = R.drawable.rick;
        this.img_id = R.drawable.house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
