package com.bookstore.productsattributesservice.query.controller;

import com.bookstore.productsattributesservice.query.model.ProductsAttributesResponseModel;
import com.bookstore.productsattributesservice.query.queries.GetAllProductsAttributesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productsAttributes")
public class ProductsAttributesQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductsAttributesResponseModel> getAll() {
        GetAllProductsAttributesQuery getAllBookQuery = new GetAllProductsAttributesQuery();
        List<ProductsAttributesResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProductsAttributesResponseModel.class)).join();
        return list;
    }
}
