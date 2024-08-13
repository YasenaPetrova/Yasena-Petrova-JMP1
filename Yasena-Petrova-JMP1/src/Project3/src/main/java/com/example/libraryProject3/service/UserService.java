package com.example.libraryProject3.service;
import com.example.libraryProject3.enums.Role;
import com.example.libraryProject3.models.User;
import com.example.libraryProject3.models.UserBook;
import com.example.libraryProject3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.registerUser(user.getName(), user.getUsername(), user.getPassword(), user.isActive(), user.getRole());
    }

    public void lockUser(int userId) {
        userRepository.lockUser(userId);
    }

    public void unlockUser(int userId) {
        userRepository.unlockUser(userId);
    }

    public List<UserBook> getUserLibrary(int userId) {
        return null;
    }

    public List<UserBook> getRecentBooks(int userId) {

        return null;
    }

    public void addToLibrary(UserBook userBook) {

    }
}