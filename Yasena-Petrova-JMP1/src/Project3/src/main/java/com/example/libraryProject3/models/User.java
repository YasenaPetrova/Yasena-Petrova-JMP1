package com.example.libraryProject3.models;

import com.example.libraryProject3.repository.UserRepository;

import com.example.libraryProject3.enums.Role;
import java.util.Scanner;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private boolean isActive = false;
    private Role role;

    public User() {}

    public User(int id, String name, String username, String password, boolean isActive, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public User(String admin, String admin1, Role role) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
