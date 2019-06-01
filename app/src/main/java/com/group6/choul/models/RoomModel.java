package com.group6.choul.models;

public class RoomModel {

    private String title, price, address, location, img_url;
    private int id;
    public RoomModel( String title, String price, String address, String location, String img_url, int id) {
        this.title = title;
        this.price = price;
        this.address = address;
        this.location = location;
        this.img_url = img_url;
        this.id = id;
    }

    public RoomModel() {

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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setId(int id) {
        this.id = id;
    }
}
