package com.hairsaloon.demo.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullname;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private String phoneNo;
    @NotBlank(message = "role is mandatory")
    private String role;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
    // These are constructor

//    public  User(){// This is no args constructor
//
//    }
//    // This is all argument Constructor
//    // This req while creating user.
//    public User(String fullname,
//                String email,
//                String username,
//                String phoneNo,
//                String role,
//                String password,
//                LocalDateTime createdAt,
//                LocalDateTime updatedAt) {
//        this.fullname = fullname;
//        this.email = email;
//        this.username=username;
//        this.password=password;
//        this.phoneNo = phoneNo;
//        this.role = role;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    // These are getter setter method
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//}

