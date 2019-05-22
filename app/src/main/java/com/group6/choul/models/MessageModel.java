package com.group6.choul.models;

import android.support.annotation.Nullable;

public class MessageModel {
    private String message, user_img;
    private boolean response;

    public MessageModel(String message,  String user_img, boolean response) {
        this.message = message;
        this.user_img = user_img;
        this.response = response;
    }
    public MessageModel(String message, boolean response) {
        this.message = message;
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }
}
