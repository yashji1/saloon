package com.hairsaloon.demo.modals;

import java.time.LocalDateTime;

public class User {
    private String fullname;

    private String email;

    private String phoneNo;

    private String role;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;

    // These are constructor

    public  User(){// This is no args constructor

    }
    // This is all argument Constructor
    // This req while creating user.
    public User(String fullname,
                String email,
                String phoneNo,
                String role,
                LocalDateTime createdAt,
                LocalDateTime updatedAt) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    // These are getter setter method

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

