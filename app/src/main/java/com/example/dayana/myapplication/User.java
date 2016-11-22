package com.example.dayana.myapplication;

/**
 * Created by dayana on 11/21/16.
 */

public class User {

    private String name;
    private String email;
    private String phone;
    private String pass;
    private String type;

    public User (String name, String email, String phone, String pass, String type){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(String type) {
        this.type = type;
    }
}
