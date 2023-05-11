package com.bookstore.keywordsservice.query.controller;

import com.bookstore.keywordsservice.query.model.KeywordsResponseModel;
import com.bookstore.keywordsservice.query.queries.GetAllKeywordsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/keywords")
public class KeywordsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<KeywordsResponseModel> getAll() {
        GetAllKeywordsQuery getAllBookQuery = new GetAllKeywordsQuery();
        List<KeywordsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(KeywordsResponseModel.class)).join();
        return list;
    }
}

