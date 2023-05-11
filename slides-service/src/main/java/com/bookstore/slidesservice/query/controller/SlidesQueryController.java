package com.bookstore.slidesservice.query.controller;

import com.bookstore.slidesservice.query.model.SlidesResponseModel;
import com.bookstore.slidesservice.query.queries.GetAllSlidesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/slides")
public class SlidesQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<SlidesResponseModel> getAll() {
        GetAllSlidesQuery getAllBookQuery = new GetAllSlidesQuery();
        List<SlidesResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(SlidesResponseModel.class)).join();
        return list;
    }
}
