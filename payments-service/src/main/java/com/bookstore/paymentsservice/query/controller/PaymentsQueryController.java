package com.bookstore.paymentsservice.query.controller;

import com.bookstore.paymentsservice.query.model.PaymentsResponseModel;
import com.bookstore.paymentsservice.query.queries.GetAllPaymentsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<PaymentsResponseModel> getAll() {
        GetAllPaymentsQuery getAllBookQuery = new GetAllPaymentsQuery();
        List<PaymentsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(PaymentsResponseModel.class)).join();
        return list;
    }
}
