package com.bookstore.product_typeservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, String> {

    List<ProductType> findByNameIn(List<String> name);
}
