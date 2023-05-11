package com.bookstore.payment_methodservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {

    PaymentMethod findById(String id);
}
