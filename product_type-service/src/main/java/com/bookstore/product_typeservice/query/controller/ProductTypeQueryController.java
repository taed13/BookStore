package com.bookstore.product_typeservice.query.controller;

import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.product_typeservice.query.model.ProductTypeResponseModel;
import com.bookstore.product_typeservice.query.queries.GetAllProductTypeByNameQuery;
import com.bookstore.product_typeservice.query.queries.GetAllProductTypeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productType")
public class ProductTypeQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductTypeResponseModel> getAllBook() {
        GetAllProductTypeQuery getAllBookQuery = new GetAllProductTypeQuery();
        List<ProductTypeResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProductTypeResponseModel.class)).join();
        return list;
    }

    @GetMapping("/products/productTypeName")
    public List<ProductResponseCommonModel> getAllBook(@RequestParam(required = false) List<String> productTypeName) {
        GetAllProductTypeByNameQuery productTypeByNameQuery = new GetAllProductTypeByNameQuery(productTypeName);
        List<ProductResponseCommonModel> list = queryGateway.query(productTypeByNameQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseCommonModel.class)).join();
        return list;
    }
}
