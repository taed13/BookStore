package com.bookstore.carrierservice.query.controller;

import com.bookstore.carrierservice.query.model.CarrierResponseModel;
import com.bookstore.carrierservice.query.queries.GetAllCarrierQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attributes/carrier")
public class CarrierQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<CarrierResponseModel> getAll() {
        GetAllCarrierQuery getAllBookQuery = new GetAllCarrierQuery();
        List<CarrierResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(CarrierResponseModel.class)).join();
        return list;
    }
}
