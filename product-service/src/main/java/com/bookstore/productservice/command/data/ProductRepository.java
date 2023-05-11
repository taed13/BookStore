package com.bookstore.productservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByAuthorId(String authorId);

    List<Product> findByPublisherId(String publisherId);

    List<Product> findByPublishedDateAfter(LocalDate startDate);

    List<Product> findByPublishedDateBefore(LocalDate endDate);

    List<Product> findByPublishedDateBetween(LocalDate startDate, LocalDate endDate);

    List<Product> findByPriceBefore(Double maxPrice);

    List<Product> findByPriceAfter(Double minPrice);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Product> findByConditionContainingIgnoreCase(String condition);

    List<Product> findByBindingContainingIgnoreCase(String binding);
}
