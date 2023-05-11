package com.bookstore.keywordsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordsRepository extends JpaRepository<Keywords, String> {
}
