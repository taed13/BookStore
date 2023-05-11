package com.bookstore.bill_promotionservice.query.projection;

import com.bookstore.bill_promotionservice.command.data.BillPromotion;
import com.bookstore.bill_promotionservice.command.data.BillPromotionRepository;
import com.bookstore.bill_promotionservice.query.model.BillPromotionResponseModel;
import com.bookstore.bill_promotionservice.query.queries.GetAllBillPromotionQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillPromotionProjection {

    @Autowired
    private BillPromotionRepository repository;

    @QueryHandler
    public List<BillPromotionResponseModel> getAllBook(GetAllBillPromotionQuery getAll) {
        List<BillPromotionResponseModel> list = new ArrayList<>();
        List<BillPromotion> List = repository.findAll();
        List.forEach(book -> {
            BillPromotionResponseModel model = new BillPromotionResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
