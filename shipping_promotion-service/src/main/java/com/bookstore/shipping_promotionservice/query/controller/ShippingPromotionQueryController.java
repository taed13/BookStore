package com.bookstore.shipping_promotionservice.query.controller;

import com.bookstore.shipping_promotionservice.query.model.ShippingPromotionResponseModel;
import com.bookstore.shipping_promotionservice.query.queries.GetAllShippingPromotionQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippingPromotion")
public class ShippingPromotionQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ShippingPromotionResponseModel> getAll() {
        GetAllShippingPromotionQuery getAllBookQuery = new GetAllShippingPromotionQuery();
        List<ShippingPromotionResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ShippingPromotionResponseModel.class)).join();
        return list;
    }
}
