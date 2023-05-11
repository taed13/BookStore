package com.bookstore.user_promotionservice.query.projection;

import com.bookstore.user_promotionservice.command.data.UserPromotion;
import com.bookstore.user_promotionservice.command.data.UserPromotionRepository;
import com.bookstore.user_promotionservice.query.model.UserPromotionResponseModel;
import com.bookstore.user_promotionservice.query.query.GetAllUserPromotionQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserPromotionProjection {

    @Autowired
    private UserPromotionRepository repository;

    @QueryHandler
    public List<UserPromotionResponseModel> getAllBook(GetAllUserPromotionQuery getAll) {
        List<UserPromotionResponseModel> list = new ArrayList<>();
        List<UserPromotion> List = repository.findAll();
        List.forEach(book -> {
            UserPromotionResponseModel model = new UserPromotionResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
