package com.bookstore.provinceservice.query.controller;

import com.bookstore.provinceservice.query.model.ProvinceResponseModel;
import com.bookstore.provinceservice.query.queries.GetAllProvinceQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/province")
public class ProvinceQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProvinceResponseModel> getAll() {
        GetAllProvinceQuery getAllBookQuery = new GetAllProvinceQuery();
        List<ProvinceResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ProvinceResponseModel.class)).join();
        return list;
    }
}
