package com.bookstore.shippingservice.command.data;

import com.bookstore.commonservice.model.ShippingResponseCommonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, String> {
    Shipping findByUserId(Long id);
}
