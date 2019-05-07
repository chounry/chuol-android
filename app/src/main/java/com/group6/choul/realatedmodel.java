package com.group6.choul;

public class realatedmodel {
    private String title,descriptino,img;

    public realatedmodel(String title, String descriptino, String img) {
        this.title = title;
        this.descriptino = descriptino;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptino() {
        return descriptino;
    }

    public void setDescriptino(String descriptino) {
        this.descriptino = descriptino;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
