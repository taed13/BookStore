package com.bookstore.warehouseservice.query.projection;

import com.bookstore.warehouseservice.command.data.Warehouse;
import com.bookstore.warehouseservice.command.data.WarehouseRepository;
import com.bookstore.warehouseservice.query.model.WarehouseResponseModel;
import com.bookstore.warehouseservice.query.queries.GetAllWarehouseQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WarehouseProjection {

    @Autowired
    private WarehouseRepository repository;

    @QueryHandler
    public List<WarehouseResponseModel> getAllBook(GetAllWarehouseQuery getAll) {
        List<WarehouseResponseModel> list = new ArrayList<>();
        List<Warehouse> List = repository.findAll();
        List.forEach(book -> {
            WarehouseResponseModel model = new WarehouseResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
