package com.bookstore.products_promotionsservice.query.controller;

import com.bookstore.products_promotionsservice.query.model.ProductsPromotionsResponseModel;
import com.bookstore.products_promotionsservice.query.queries.GetAllProductsPromotionsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productsPromotions")
public class ProductsPromotionsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductsPromotionsResponseModel> getAll() {
        GetAllProductsPromotionsQuery getAllBookQuery = new GetAllProductsPromotionsQuery();
        List<ProductsPromotionsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProductsPromotionsResponseModel.class)).join();
        return list;
    }
}
