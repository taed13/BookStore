package com.bookstore.articlesservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles, String> {
}
