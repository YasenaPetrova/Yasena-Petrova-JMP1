package com.example.libraryProject3.mapper;

import com.example.libraryProject3.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book(

                rs.getString("BookTitle"),
                rs.getString("Genre"),
                rs.getInt("Pages"),
                rs.getInt("Rating"),
                rs.getInt("AuthorID"),
                rs.getBoolean("InPublic")
        );
        book.setId(rs.getLong("id"));
        return book;
    }
}

