package com.bookstore.product_imagesservice.query.controller;

import com.bookstore.product_imagesservice.query.model.ProductImagesResponseModel;
import com.bookstore.product_imagesservice.query.queries.GetAllProductImagesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productImages")
public class ProductImagesQueryController {


    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductImagesResponseModel> getAll() {
        GetAllProductImagesQuery getAllBookQuery = new GetAllProductImagesQuery();
        List<ProductImagesResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProductImagesResponseModel.class)).join();
        return list;
    }
}
