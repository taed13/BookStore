package com.bookstore.shopping_cartservice.query.controller;

import com.bookstore.shopping_cartservice.query.model.ShoppingCartResponseModel;
import com.bookstore.shopping_cartservice.query.queries.GetAllShoppingCartQuery;
import com.bookstore.shopping_cartservice.query.queries.GetListShoppingCartByUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppingCart")
public class ShoppingCartQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ShoppingCartResponseModel> getAll() {
        List<ShoppingCartResponseModel> list = queryGateway.query(new GetAllShoppingCartQuery(),
                ResponseTypes.multipleInstancesOf(ShoppingCartResponseModel.class)).join();
        return list;
    }

    @GetMapping("/{userId}")
    public List<ShoppingCartResponseModel> getBorrowingByEmployee(@PathVariable Long userId){
        GetListShoppingCartByUserQuery getListShoppingCartByUserQuery = new GetListShoppingCartByUserQuery();
        getListShoppingCartByUserQuery.setUserId(userId);
        List<ShoppingCartResponseModel> list =
                queryGateway.query(getListShoppingCartByUserQuery, ResponseTypes.multipleInstancesOf(ShoppingCartResponseModel.class))
                        .join();
        return list;
    }
}
