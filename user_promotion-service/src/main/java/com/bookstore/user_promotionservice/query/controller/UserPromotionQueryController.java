package com.bookstore.user_promotionservice.query.controller;

import com.bookstore.user_promotionservice.query.model.UserPromotionResponseModel;
import com.bookstore.user_promotionservice.query.query.GetAllUserPromotionQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userPromotion")
public class UserPromotionQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<UserPromotionResponseModel> getAll() {
        GetAllUserPromotionQuery getAllBookQuery = new GetAllUserPromotionQuery();
        List<UserPromotionResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(UserPromotionResponseModel.class)).join();
        return list;
    }
}
