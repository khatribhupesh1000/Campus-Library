package com.example.campuslibrary.controller;

import com.example.campuslibrary.model.Author;
import com.example.campuslibrary.model.Book;
import com.example.campuslibrary.repository.AuthorRepository;
import com.example.campuslibrary.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class LibraryController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // --- Queries ---

    @QueryMapping
    @Transactional(readOnly = true)
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public Author author(@Argument Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public List<Book> books() {
        return bookRepository.findAll();
    }

    // --- Mutations ---

    @MutationMapping
    @Transactional
    public Book addBook(@Argument String title, @Argument Integer year, @Argument Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found: " + authorId));

        Book book = new Book(title, year, author);
        return bookRepository.save(book);
    }
}
