package com.bookstore.shipping_methodservice.query.controller;

import com.bookstore.shipping_methodservice.query.model.ShippingMethodResponseModel;
import com.bookstore.shipping_methodservice.query.queries.GetAllShippingMethodQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippingMethod")
public class ShippingMethodQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ShippingMethodResponseModel> getAll() {
        GetAllShippingMethodQuery getAllBookQuery = new GetAllShippingMethodQuery();
        List<ShippingMethodResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ShippingMethodResponseModel.class)).join();
        return list;
    }
}
