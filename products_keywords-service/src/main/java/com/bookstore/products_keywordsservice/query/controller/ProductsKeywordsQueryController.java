package com.bookstore.products_keywordsservice.query.controller;

import com.bookstore.products_keywordsservice.query.model.ProductsKeywordsResponseModel;
import com.bookstore.products_keywordsservice.query.queries.GetAllProductsKeywordsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productsKeywords")
public class ProductsKeywordsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductsKeywordsResponseModel> getAll() {
        GetAllProductsKeywordsQuery getAllBookQuery = new GetAllProductsKeywordsQuery();
        List<ProductsKeywordsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProductsKeywordsResponseModel.class)).join();
        return list;
    }
}
