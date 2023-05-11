package com.bookstore.authorservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, String> {

    List<Author> findByNameContainingIgnoreCase(String name);
}
