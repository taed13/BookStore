package com.bookstore.staticsservice.query.controller;

import com.bookstore.staticsservice.query.model.StaticsResponseModel;
import com.bookstore.staticsservice.query.queries.GetAllStaticsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statics")
public class StaticsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<StaticsResponseModel> getAll() {
        GetAllStaticsQuery getAllBookQuery = new GetAllStaticsQuery();
        List<StaticsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(StaticsResponseModel.class)).join();
        return list;
    }
}
