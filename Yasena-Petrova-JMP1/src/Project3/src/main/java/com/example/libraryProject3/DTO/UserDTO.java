package com.example.libraryProject3.DTO;

import com.example.libraryProject3.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private boolean isActive;

    private Role role;
}
