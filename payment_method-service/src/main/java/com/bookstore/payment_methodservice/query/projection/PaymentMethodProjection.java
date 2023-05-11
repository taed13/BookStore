package com.bookstore.payment_methodservice.query.projection;

import com.bookstore.commonservice.model.PaymentMethodResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsPaymentMethodQuery;
import com.bookstore.payment_methodservice.command.data.PaymentMethod;
import com.bookstore.payment_methodservice.command.data.PaymentMethodRepository;
import com.bookstore.payment_methodservice.query.model.PaymentMethodResponseModel;
import com.bookstore.payment_methodservice.query.queries.GetAllPaymentMethodQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PaymentMethodProjection {

    @Autowired
    private PaymentMethodRepository repository;

    @QueryHandler
    public List<PaymentMethodResponseModel> getAllBook(GetAllPaymentMethodQuery getAll) {
        List<PaymentMethodResponseModel> list = new ArrayList<>();
        List<PaymentMethod> List = repository.findAll();
        List.forEach(book -> {
            PaymentMethodResponseModel model = new PaymentMethodResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public PaymentMethodResponseCommonModel getAllBook(GetDetailsPaymentMethodQuery getAll) {
        PaymentMethodResponseCommonModel model = new PaymentMethodResponseCommonModel();
        PaymentMethod method = repository.findById(getAll.getPaymentMethodId());
       if (method != null) {
           BeanUtils.copyProperties(method, model);
       }
       return model;
    }
}
