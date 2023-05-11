package com.bookstore.products_promotionsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsPromotionsRepository extends JpaRepository<ProductsPromotions, String> {
}
