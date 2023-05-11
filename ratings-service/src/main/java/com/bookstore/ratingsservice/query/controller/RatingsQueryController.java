package com.bookstore.ratingsservice.query.controller;

import com.bookstore.ratingsservice.query.model.RatingsResponseModel;
import com.bookstore.ratingsservice.query.queries.GetAllRatingsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<RatingsResponseModel> getAll() {
        GetAllRatingsQuery getAllBookQuery = new GetAllRatingsQuery();
        List<RatingsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(RatingsResponseModel.class)).join();
        return list;
    }
}
