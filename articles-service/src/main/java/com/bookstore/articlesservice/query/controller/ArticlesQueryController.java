package com.bookstore.articlesservice.query.controller;

import com.bookstore.articlesservice.query.model.ArticlesResponseModel;
import com.bookstore.articlesservice.query.queries.GetAllArticlesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticlesQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ArticlesResponseModel> getAll() {
        GetAllArticlesQuery getAllBookQuery = new GetAllArticlesQuery();
        List<ArticlesResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ArticlesResponseModel.class)).join();
        return list;
    }
}
