package com.bookstore.bill_shippingservice.query.controller;

import com.bookstore.bill_shippingservice.query.model.BillShippingResponseModel;
import com.bookstore.bill_shippingservice.query.queries.GetAllBillShippingQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billShipping")
public class BillShippingQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<BillShippingResponseModel> getAll() {
        GetAllBillShippingQuery getAllBookQuery = new GetAllBillShippingQuery();
        List<BillShippingResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(BillShippingResponseModel.class)).join();
        return list;
    }
}
