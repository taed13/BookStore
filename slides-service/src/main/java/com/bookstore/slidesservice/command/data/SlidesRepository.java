package com.bookstore.slidesservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SlidesRepository extends JpaRepository<Slides, String> {
}
