package com.group6.choul.models;

public class MemberDataForChat {
    private String name;
    private String img;

    public MemberDataForChat(String name, String img) {
        this.name = name;
        this.img = img;
    }

    // Add an empty constructor so we can later parse JSON into MemberData using Jackson
    public MemberDataForChat() {
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }
}
