package com.example.seguimiento13.model;

public class User {
    private String bankPassword;
    private String content;

    public User(String bankPassword, String content) {
        this.bankPassword = bankPassword;
        this.content = content;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
