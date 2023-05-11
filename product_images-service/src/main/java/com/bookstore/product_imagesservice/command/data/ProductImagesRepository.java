package com.bookstore.product_imagesservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagesRepository extends JpaRepository<ProductImages, String> {
}
