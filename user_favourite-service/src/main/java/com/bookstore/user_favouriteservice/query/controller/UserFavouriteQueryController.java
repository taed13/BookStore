package com.bookstore.user_favouriteservice.query.controller;

import com.bookstore.user_favouriteservice.query.model.UserFavouriteResponseModel;
import com.bookstore.user_favouriteservice.query.queries.GetAllUserFavouriteQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userFavourite")
public class UserFavouriteQueryController {
    
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<UserFavouriteResponseModel> getAll() {
        GetAllUserFavouriteQuery getAllBookQuery = new GetAllUserFavouriteQuery();
        List<UserFavouriteResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(UserFavouriteResponseModel.class)).join();
        return list;
    }
}
