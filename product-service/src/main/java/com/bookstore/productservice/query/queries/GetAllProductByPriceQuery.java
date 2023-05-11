package com.bookstore.productservice.query.queries;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductByPriceQuery {

    private Double minPrice;

    private Double maxPrice;
}
