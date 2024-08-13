package com.example.libraryProject3.DTO;

import lombok.Data;

@Data
public class BookRatingDTO {
    private long bookId;
    private int userId;
    private int rating;
}
