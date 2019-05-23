package com.group6.choul.models;

public class HomeModel {
    private String title, price, address, location, type,img_url;

    public HomeModel(String title, String price, String address, String location, String type, String img_url) {
        this.title = title;
        this.price = price;
        this.address = address;
        this.location = location;
        this.type = type;
        this.img_url = img_url;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
