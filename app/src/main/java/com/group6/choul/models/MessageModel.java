package com.group6.choul.models;


public class MessageModel {
    private String message;
    private MemberDataForChat memberData;
    private boolean response;

    public MessageModel(String message, boolean response, MemberDataForChat memberData) {
        this.message = message;
        this.response = response;
        this.memberData = memberData;
    }

    public MemberDataForChat getMemberData() {
        return memberData;
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
}
