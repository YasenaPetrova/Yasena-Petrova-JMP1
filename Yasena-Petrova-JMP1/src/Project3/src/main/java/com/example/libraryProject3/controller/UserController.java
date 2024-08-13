package com.example.libraryProject3.controller;

import com.example.libraryProject3.DTO.UserDTO;
import com.example.libraryProject3.enums.Role;
import com.example.libraryProject3.models.User;
import com.example.libraryProject3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.isActive());
        user.setRole(userDTO.getRole());

        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/lock/{userId}")
    public ResponseEntity<?> lockUser(@RequestHeader("username") String username, @PathVariable int userId) {
        if (userService.getUserByUsername(username).getRole() == Role.ADMIN) {
            userService.lockUser(userId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PutMapping("/unlock/{userId}")
    public ResponseEntity<?> unlockUser(@RequestHeader("username") String username, @PathVariable int userId) {
        if (userService.getUserByUsername(username).getRole() == Role.ADMIN) {
            userService.unlockUser(userId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/library/{userId}")
    public ResponseEntity<?> getUserLibrary(@RequestHeader("username") String username, @PathVariable int userId) {
        if (userService.getUserByUsername(username).getRole() == Role.READER) {
            return ResponseEntity.ok(userService.getUserLibrary(userId));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/recent/{userId}")
    public ResponseEntity<?> getRecentBooks(@RequestHeader("username") String username, @PathVariable int userId) {
        if (userService.getUserByUsername(username).getRole() == Role.READER) {
            return ResponseEntity.ok(userService.getRecentBooks(userId));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
