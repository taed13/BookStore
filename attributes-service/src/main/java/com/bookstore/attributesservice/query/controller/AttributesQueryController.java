package com.bookstore.attributesservice.query.controller;

import com.bookstore.attributesservice.query.model.AttributesResponseModel;
import com.bookstore.attributesservice.query.queries.GetAllAttributesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attributes")
public class AttributesQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<AttributesResponseModel> getAll() {
        GetAllAttributesQuery getAllBookQuery = new GetAllAttributesQuery();
        List<AttributesResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(AttributesResponseModel.class)).join();
        return list;
    }
}
