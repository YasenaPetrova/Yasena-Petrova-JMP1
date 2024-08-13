package com.example.libraryProject3.mapper;

import com.example.libraryProject3.enums.Role;
import com.example.libraryProject3.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setActive(rs.getBoolean("isActive"));
        user.setRole(Role.valueOf(rs.getString("role")));

        return user;
    }
}