package com.bookstore.ratingsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Ratings, String> {
}
