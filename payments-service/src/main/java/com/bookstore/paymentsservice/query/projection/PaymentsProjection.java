package com.bookstore.paymentsservice.query.projection;

import com.bookstore.paymentsservice.command.data.Payments;
import com.bookstore.paymentsservice.command.data.PaymentsRepository;
import com.bookstore.paymentsservice.query.model.PaymentsResponseModel;
import com.bookstore.paymentsservice.query.queries.GetAllPaymentsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentsProjection {

    @Autowired
    private PaymentsRepository repository;

    @QueryHandler
    public List<PaymentsResponseModel> getAllBook(GetAllPaymentsQuery getAll) {
        List<PaymentsResponseModel> list = new ArrayList<>();
        List<Payments> List = repository.findAll();
        List.forEach(book -> {
            PaymentsResponseModel model = new PaymentsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
