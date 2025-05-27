package com.examly.springappuser.model;

import java.lang.annotation.Inherited;

import jakarta.persistence.Entity;

@Entity
@Table(name="users")
public class User {
    @Id private Long userId;
    private String email;
    private String password;
    private String username;
    private String userRole;
    private String mobileNumber;

    
}
