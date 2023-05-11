package com.bookstore.billservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, String> {
    Bill findByIdAndUserId(String id, Long userId);

    void deleteByIdAndUserId(String id, Long userId);

}
