package com.bookstore.shippingservice.query.controller;

import com.bookstore.shippingservice.query.model.ShippingResponseModel;
import com.bookstore.shippingservice.query.queries.GetAllShippingQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ShippingResponseModel> getAll() {
        GetAllShippingQuery getAllBookQuery = new GetAllShippingQuery();
        List<ShippingResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ShippingResponseModel.class)).join();
        return list;
    }
}
