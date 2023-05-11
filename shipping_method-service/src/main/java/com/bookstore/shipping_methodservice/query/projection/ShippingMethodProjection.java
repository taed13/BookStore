package com.bookstore.shipping_methodservice.query.projection;

import com.bookstore.shipping_methodservice.command.data.ShippingMethod;
import com.bookstore.shipping_methodservice.command.data.ShippingMethodRepository;
import com.bookstore.shipping_methodservice.query.model.ShippingMethodResponseModel;
import com.bookstore.shipping_methodservice.query.queries.GetAllShippingMethodQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShippingMethodProjection {
    @Autowired
    private ShippingMethodRepository repository;

    @QueryHandler
    public List<ShippingMethodResponseModel> getAllBook(GetAllShippingMethodQuery getAll) {
        List<ShippingMethodResponseModel> list = new ArrayList<>();
        List<ShippingMethod> List = repository.findAll();
        List.forEach(book -> {
            ShippingMethodResponseModel model = new ShippingMethodResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
