package com.bookstore.categoriesservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, String> {
}
