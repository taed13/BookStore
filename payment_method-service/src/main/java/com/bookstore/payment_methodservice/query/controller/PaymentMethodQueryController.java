package com.bookstore.payment_methodservice.query.controller;

import com.bookstore.payment_methodservice.query.model.PaymentMethodResponseModel;
import com.bookstore.payment_methodservice.query.queries.GetAllPaymentMethodQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paymentMethod")
public class PaymentMethodQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<PaymentMethodResponseModel> getAll() {
        GetAllPaymentMethodQuery getAllBookQuery = new GetAllPaymentMethodQuery();
        List<PaymentMethodResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(PaymentMethodResponseModel.class)).join();
        return list;
    }
}
