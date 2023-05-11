package com.bookstore.categoriesservice.query.controller;

import com.bookstore.categoriesservice.query.model.CategoriesResponseModel;
import com.bookstore.categoriesservice.query.queries.GetAllCategoriesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<CategoriesResponseModel> getAll() {
        GetAllCategoriesQuery getAllBookQuery = new GetAllCategoriesQuery();
        List<CategoriesResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(CategoriesResponseModel.class)).join();
        return list;
    }
}
