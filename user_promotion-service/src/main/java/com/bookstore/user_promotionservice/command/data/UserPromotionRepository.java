package com.bookstore.user_promotionservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPromotionRepository extends JpaRepository<UserPromotion, String> {
}
