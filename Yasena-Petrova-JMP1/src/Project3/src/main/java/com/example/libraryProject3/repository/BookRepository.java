package com.example.libraryProject3.repository;

import com.example.libraryProject3.mapper.BookMapper;
import com.example.libraryProject3.models.Book;
import com.example.libraryProject3.models.BookRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private BookMapper BookMapper;
    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void insertBookDB(Book book) {
        String sql = "INSERT INTO books (BookTitle, Genre, Pages, Rating, AuthorID, InPublic) " +
                "VALUES (:title, :genre, :pages, :rating, :authorId, :inPublic)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", book.getNameBook());
        parameters.put("genre", book.getGenre());
        parameters.put("pages", book.getPages());
        parameters.put("rating", book.getStars());
        parameters.put("authorId", book.getAuthorID());
        parameters.put("inPublic", book.isMakePublic());

        jdbcTemplate.update(sql, parameters);
    }

    public List<Book> searchBooks(String title, String author) {
        String query = "SELECT * FROM books WHERE BookTitle LIKE :title AND AuthorID IN (SELECT id FROM users WHERE name LIKE :author)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("title", "%" + title + "%")
                .addValue("author", "%" + author + "%");
        return jdbcTemplate.query(query, params, new BookMapper());
    }
    public Book getBookById(long id) {
        return null;
    }

    public void rateBook(BookRating rating) {

    }
    public List<Book> getAllBooks() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, new BookMapper());
    }
}
