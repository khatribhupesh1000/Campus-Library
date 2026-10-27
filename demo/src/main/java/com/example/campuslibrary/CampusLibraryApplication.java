package com.example.campuslibrary;

import com.example.campuslibrary.model.Author;
import com.example.campuslibrary.model.Book;
import com.example.campuslibrary.repository.AuthorRepository;
import com.example.campuslibrary.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampusLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusLibraryApplication.class, args);
    }

    // Seeds initial sample authors & books if table is empty
    @Bean
    public CommandLineRunner initDatabase(AuthorRepository authorRepo, BookRepository bookRepo) {
        return args -> {
            if (authorRepo.count() == 0) {
                Author asha = authorRepo.save(new Author("Asha Patel", "India"));
                Author ravi = authorRepo.save(new Author("Ravi Kumar", "India"));

                bookRepo.save(new Book("Databases 101", 2020, asha));
                bookRepo.save(new Book("SQL in Practice", 2022, asha));
                bookRepo.save(new Book("Web Services Basics", 2023, ravi));

                System.out.println(">>> Sample authors and books seeded successfully!");
            }
        };
    }
}