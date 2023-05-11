package com.bookstore.shipping_promotionservice.query.projection;

import com.bookstore.shipping_promotionservice.command.data.ShippingPromotion;
import com.bookstore.shipping_promotionservice.command.data.ShippingPromotionRepository;
import com.bookstore.shipping_promotionservice.query.model.ShippingPromotionResponseModel;
import com.bookstore.shipping_promotionservice.query.queries.GetAllShippingPromotionQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShippingPromotionProjection {

    @Autowired
    private ShippingPromotionRepository repository;

    @QueryHandler
    public List<ShippingPromotionResponseModel> getAllBook(GetAllShippingPromotionQuery getAll) {
        List<ShippingPromotionResponseModel> list = new ArrayList<>();
        List<ShippingPromotion> List = repository.findAll();
        List.forEach(book -> {
            ShippingPromotionResponseModel model = new ShippingPromotionResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
