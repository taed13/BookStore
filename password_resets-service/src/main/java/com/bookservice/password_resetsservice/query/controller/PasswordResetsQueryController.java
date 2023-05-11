package com.bookservice.password_resetsservice.query.controller;

import com.bookservice.password_resetsservice.query.model.PasswordResetsResponseModel;
import com.bookservice.password_resetsservice.query.queries.GetAllPasswordResetsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passwordResets")
public class PasswordResetsQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<PasswordResetsResponseModel> getAll() {
        GetAllPasswordResetsQuery getAllBookQuery = new GetAllPasswordResetsQuery();
        List<PasswordResetsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(PasswordResetsResponseModel.class)).join();
        return list;
    }
}
