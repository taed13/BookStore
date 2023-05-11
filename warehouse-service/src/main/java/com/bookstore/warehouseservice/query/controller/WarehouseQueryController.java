package com.bookstore.warehouseservice.query.controller;

import com.bookstore.warehouseservice.query.model.WarehouseResponseModel;
import com.bookstore.warehouseservice.query.queries.GetAllWarehouseQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<WarehouseResponseModel> getAll() {
        GetAllWarehouseQuery getAllBookQuery = new GetAllWarehouseQuery();
        List<WarehouseResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(WarehouseResponseModel.class)).join();
        return list;
    }
}
