package com.bookstore.bill_promotionservice.query.controller;

import com.bookstore.bill_promotionservice.query.model.BillPromotionResponseModel;
import com.bookstore.bill_promotionservice.query.queries.GetAllBillPromotionQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billPromotion")
public class BillPromotionQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<BillPromotionResponseModel> getAll() {
        GetAllBillPromotionQuery getAllBookQuery = new GetAllBillPromotionQuery();
        List<BillPromotionResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(BillPromotionResponseModel.class)).join();
        return list;
    }
}
