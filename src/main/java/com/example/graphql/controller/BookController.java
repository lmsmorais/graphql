package com.example.graphql.controller;

import com.example.graphql.model.Book;
import com.example.graphql.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return repository.getBookById(id);
    }

    @QueryMapping
    public String hello() {
        return "Hello, GraphQL!";
    }

    @MutationMapping
    public Book addBook(@Argument String id, @Argument String title, @Argument String author) {
        return repository.addBook(id, title, author);
    }

}
