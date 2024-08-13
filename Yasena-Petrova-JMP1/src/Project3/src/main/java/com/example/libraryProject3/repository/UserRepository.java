package com.example.libraryProject3.repository;


import com.example.libraryProject3.mapper.UserMapper;
import com.example.libraryProject3.models.User;
import com.example.libraryProject3.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private UserMapper userMapper;


    @Autowired
    public UserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void registerUser(String name, String username, String password, boolean isActive, Role role) {
        jdbcTemplate.update("INSERT INTO users (name, username, password, isActive, role) VALUES (:name, :username, :password, :isActive, :role)",
                new MapSqlParameterSource().addValue("name", name)
                        .addValue("username", username)
                        .addValue("password", password)
                        .addValue("isActive", isActive)
                        .addValue("role", role.name()));
    }


    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = :username";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("username", username), new UserMapper());
    }

    public void lockUser(int userId) {
        jdbcTemplate.update("UPDATE users SET isActive = false WHERE id = :id",
                new MapSqlParameterSource("id", userId));
    }


    public void unlockUser(int userId) {
        jdbcTemplate.update("UPDATE users SET isActive = true WHERE id = :id", new MapSqlParameterSource("id", userId));
    }
}