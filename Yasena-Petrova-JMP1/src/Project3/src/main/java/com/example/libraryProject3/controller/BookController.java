package com.example.libraryProject3.controller;


import com.example.libraryProject3.DTO.BookDTO;
import com.example.libraryProject3.DTO.BookRatingDTO;
import com.example.libraryProject3.DTO.UserBookDTO;
import com.example.libraryProject3.DTO.UserDTO;
import com.example.libraryProject3.enums.Role;
import com.example.libraryProject3.models.User;
import com.example.libraryProject3.service.BookService;
import com.example.libraryProject3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library/book")
public class BookController {

    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public BookController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.isActive());
        user.setRole(userDTO.getRole());

        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

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

    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rate-book")
    public ResponseEntity<?> rateBook(@RequestBody BookRatingDTO ratingDTO) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-to-library")
    public ResponseEntity<?> addToLibrary(@RequestBody UserBookDTO userBookDTO) {
        return ResponseEntity.ok().build();
    }
}
