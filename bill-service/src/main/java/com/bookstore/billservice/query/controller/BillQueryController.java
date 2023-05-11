package com.bookstore.billservice.query.controller;

import com.bookstore.billservice.query.model.BillResponseModel;
import com.bookstore.billservice.query.queries.GetAllBillQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<BillResponseModel> getAll() {
        GetAllBillQuery getAllBookQuery = new GetAllBillQuery();
        List<BillResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(BillResponseModel.class)).join();
        return list;
    }
}
