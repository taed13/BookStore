package com.bookstore.paymentsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, String> {
}
