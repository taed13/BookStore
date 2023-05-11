package com.bookstore.detail_billservice.query.projection;

import com.bookstore.detail_billservice.command.data.DetailBill;
import com.bookstore.detail_billservice.command.data.DetailBillRepository;
import com.bookstore.detail_billservice.query.model.DetailBillResponseModel;
import com.bookstore.detail_billservice.query.queries.GetAllDetailBillQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailBillProjection {

    @Autowired
    private DetailBillRepository repository;

    @QueryHandler
    public List<DetailBillResponseModel> getAllBook(GetAllDetailBillQuery getAll) {
        List<DetailBillResponseModel> list = new ArrayList<>();
        List<DetailBill> List = repository.findAll();
        List.forEach(book -> {
            DetailBillResponseModel model = new DetailBillResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
