package com.example.graphql.repository;

import com.example.graphql.model.Book;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        books.put("1", new Book("1", "Clean Code", "Robert C. Martin"));
        books.put("2", new Book("2", "Effective Java", "Joshua Bloch"));
    }

    public Book getBookById(String id) {
        return books.get(id);
    }

    public Book addBook(String id, String title, String author) {
        Book newBook = new Book(id, title, author);
        books.put(id, newBook);
        return newBook;
    }

}
