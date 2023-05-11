package com.bookstore.shipping_methodservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, String> {
}
