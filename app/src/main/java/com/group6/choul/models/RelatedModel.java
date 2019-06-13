package com.group6.choul.models;

public class RelatedModel {
    private String title,price,img,estate_id;
    private boolean room;

    public RelatedModel(String title, String price, String img, String estate_id) {
        this.estate_id = estate_id;
        this.title = title;
        this.price = price;
        this.img = img;
    }

    public RelatedModel() {

    }

    public String getTitle() {
        return title;
    }

    public String getEstate_id() {
        return estate_id;
    }

    public void setEstate_id(String estate_id) {
        this.estate_id = estate_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptino() {
        return price;
    }

    public void setDescriptino(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isRoom() {
        return room;
    }

    public void setRoom(boolean room) {
        this.room = room;
    }
}
