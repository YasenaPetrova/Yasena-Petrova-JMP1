package com.example.libraryProject3.RepositoryTest;

import com.example.libraryProject3.enums.Role;
import com.example.libraryProject3.models.User;
import com.example.libraryProject3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    public void testAddUser() {

        UserRepository userRepository = new UserRepository(jdbcTemplate);
        String name = "Yasena";
        String username = "yasena";
        String password = "password";
        boolean isActive = true;
        Role role= Role.READER;


        userRepository.registerUser(name, username, password, isActive,role);


        verify(jdbcTemplate).update(
                "INSERT INTO user (name, username, password, isActive) VALUES (:name, :username, :password, :isActive)",
                new MapSqlParameterSource()
                        .addValue("name", name)
                        .addValue("username", username)
                        .addValue("password", password)
                        .addValue("isActive", isActive)
        );
    }

}