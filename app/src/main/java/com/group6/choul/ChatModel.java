package com.group6.choul;

public class ChatModel {
    private String name,time;
    private int img_id, imgProfile;

    public ChatModel(int imgProfile, String name, String time, int img_id) {
        this.imgProfile = imgProfile;
        this.name = name;
        this.time = time;
        this.img_id = img_id;
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
}
