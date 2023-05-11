package com.bookstore.shipping_promotionservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingPromotionRepository extends JpaRepository<ShippingPromotion, String> {
}
