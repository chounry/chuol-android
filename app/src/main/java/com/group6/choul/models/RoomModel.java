package com.group6.choul.models;

public class RoomModel {
    private  String free_wifi, parking_space_avalible , AC, title, price, address, location, img_url;
    private int size, estate_id;


    public RoomModel(String free_wifi, String parking_space_avalible, String AC, int size, Integer estate_id, String title, String price, String address, String location, String img_url) {
        this.free_wifi = free_wifi;
        this.parking_space_avalible = parking_space_avalible;
        this.AC = AC;
        this.size = size;
        this.estate_id = estate_id;
        this.title = title;
        this.price = price;
        this.address = address;
        this.location = location;
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

    public String getFree_wifi() {
        return free_wifi;
    }

    public void setFree_wifi(String free_wifi) {
        this.free_wifi = free_wifi;
    }

    public String getParking_space_avalible() {
        return parking_space_avalible;
    }

    public void setParking_space_avalible(String parking_space_avalible) {
        this.parking_space_avalible = parking_space_avalible;
    }

    public String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEstate_id() {
        return estate_id;
    }

    public void setEstate_id(int estate_id) {
        this.estate_id = estate_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
