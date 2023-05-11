package com.bookstore.menuservice.query.controller;

import com.bookstore.menuservice.query.model.MenuResponseModel;
import com.bookstore.menuservice.query.queries.GetAllMenuQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<MenuResponseModel> getAll() {
        GetAllMenuQuery getAllBookQuery = new GetAllMenuQuery();
        List<MenuResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(MenuResponseModel.class)).join();
        return list;
    }
}
