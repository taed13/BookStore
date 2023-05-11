package com.bookstore.promotionsservice.query.controller;

import com.bookstore.promotionsservice.query.model.PromotionsResponseModel;
import com.bookstore.promotionsservice.query.queries.GetAllPromotionsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<PromotionsResponseModel> getAll() {
        GetAllPromotionsQuery getAllBookQuery = new GetAllPromotionsQuery();
        List<PromotionsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(PromotionsResponseModel.class)).join();
        return list;
    }
}
