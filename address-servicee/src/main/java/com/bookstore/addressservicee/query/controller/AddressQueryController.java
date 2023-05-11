package com.bookstore.addressservicee.query.controller;

import com.bookstore.addressservicee.query.model.AddressResponseModel;
import com.bookstore.addressservicee.query.queries.GetAllAddressQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<AddressResponseModel> getAllBook() {
        GetAllAddressQuery getAllBookQuery = new GetAllAddressQuery();
        List<AddressResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(AddressResponseModel.class)).join();
        return list;
    }
}
