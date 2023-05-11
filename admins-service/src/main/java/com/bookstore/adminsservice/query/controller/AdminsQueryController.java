package com.bookstore.adminsservice.query.controller;

import com.bookstore.adminsservice.query.model.AdminsResponseModel;
import com.bookstore.adminsservice.query.queries.GetAllAdminsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<AdminsResponseModel> getAllBook() {
        GetAllAdminsQuery getAllBookQuery = new GetAllAdminsQuery();
        List<AdminsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(AdminsResponseModel.class)).join();
        return list;
    }
}
