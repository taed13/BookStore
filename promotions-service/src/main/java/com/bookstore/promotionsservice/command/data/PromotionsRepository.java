package com.bookstore.promotionsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionsRepository extends JpaRepository<Promotions, String> {
}
