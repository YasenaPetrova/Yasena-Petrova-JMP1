package com.example.libraryProject3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class BookDTO {
    @NotBlank
    private String nameBook;

    @NotBlank
    private String genre;

    @NotNull
    private Integer pages;

    @NotNull
    private Integer stars;

    @NotNull
    private Integer authorID;

    private boolean makePublic;

}
