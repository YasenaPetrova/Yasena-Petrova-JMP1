package com.example.libraryProject3.service;

import com.example.libraryProject3.models.Book;
import com.example.libraryProject3.models.BookRating;
import com.example.libraryProject3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void insertBook(Book book) {
        bookRepository.insertBookDB(book);
    }

    public List<Book> searchBooks(String title, String author) {
        return bookRepository.searchBooks(title, author);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    public void rateBook(BookRating rating) {
        bookRepository.rateBook(rating);
    }
}
