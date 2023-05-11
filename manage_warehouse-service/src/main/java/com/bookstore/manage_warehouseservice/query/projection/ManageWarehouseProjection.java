package com.bookstore.manage_warehouseservice.query.projection;

import com.bookstore.manage_warehouseservice.command.data.ManageWarehouse;
import com.bookstore.manage_warehouseservice.command.data.ManageWarehouseRepository;
import com.bookstore.manage_warehouseservice.query.model.ManageWarehouseResponseModel;
import com.bookstore.manage_warehouseservice.query.queries.GetAllManageWarehouseQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManageWarehouseProjection {

    @Autowired
    private ManageWarehouseRepository repository;

    @QueryHandler
    public List<ManageWarehouseResponseModel> getAllBook(GetAllManageWarehouseQuery getAll) {
        List<ManageWarehouseResponseModel> list = new ArrayList<>();
        List<ManageWarehouse> List = repository.findAll();
        List.forEach(book -> {
            ManageWarehouseResponseModel model = new ManageWarehouseResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
