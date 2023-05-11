package com.bookstore.manage_warehouseservice.query.controller;

import com.bookstore.manage_warehouseservice.query.model.ManageWarehouseResponseModel;
import com.bookstore.manage_warehouseservice.query.queries.GetAllManageWarehouseQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manageWarehouse")
public class ManageWarehouseQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ManageWarehouseResponseModel> getAll() {
        GetAllManageWarehouseQuery getAllBookQuery = new GetAllManageWarehouseQuery();
        List<ManageWarehouseResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ManageWarehouseResponseModel.class)).join();
        return list;
    }
}
