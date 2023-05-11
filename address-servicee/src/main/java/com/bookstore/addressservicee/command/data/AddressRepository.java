package com.bookstore.addressservicee.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
    Address findByUserId(Long userId);
}
