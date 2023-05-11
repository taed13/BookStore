package com.bookstore.bill_shippingservice.query.projection;

import com.bookstore.bill_shippingservice.command.data.BillShipping;
import com.bookstore.bill_shippingservice.command.data.BillShippingRepository;
import com.bookstore.bill_shippingservice.query.model.BillShippingResponseModel;
import com.bookstore.bill_shippingservice.query.queries.GetAllBillShippingQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillShippingProjection {

    @Autowired
    private BillShippingRepository repository;

    @QueryHandler
    public List<BillShippingResponseModel> getAllBook(GetAllBillShippingQuery getAll) {
        List<BillShippingResponseModel> list = new ArrayList<>();
        List<BillShipping> List = repository.findAll();
        List.forEach(book -> {
            BillShippingResponseModel model = new BillShippingResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
