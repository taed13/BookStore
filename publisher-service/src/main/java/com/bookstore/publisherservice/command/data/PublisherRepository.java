package com.bookstore.publisherservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, String> {

    List<Publisher> findByNameContainingIgnoreCase(String publisherName);
}
