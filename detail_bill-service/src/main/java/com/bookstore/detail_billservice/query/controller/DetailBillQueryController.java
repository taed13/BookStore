package com.bookstore.detail_billservice.query.controller;

import com.bookstore.detail_billservice.query.model.DetailBillResponseModel;
import com.bookstore.detail_billservice.query.queries.GetAllDetailBillQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/detailBill")
public class DetailBillQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<DetailBillResponseModel> getAll() {
        GetAllDetailBillQuery getAllBookQuery = new GetAllDetailBillQuery();
        List<DetailBillResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(DetailBillResponseModel.class)).join();
        return list;
    }
}
