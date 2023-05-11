package com.bookstore.carrierservice.query.projection;

import com.bookstore.carrierservice.command.data.Carrier;
import com.bookstore.carrierservice.command.data.CarrierRepository;
import com.bookstore.carrierservice.query.model.CarrierResponseModel;
import com.bookstore.carrierservice.query.queries.GetAllCarrierQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarrierProjection {

    @Autowired
    private CarrierRepository repository;

    @QueryHandler
    public List<CarrierResponseModel> getAllBook(GetAllCarrierQuery getAll) {
        List<CarrierResponseModel> list = new ArrayList<>();
        List<Carrier> List = repository.findAll();
        List.forEach(book -> {
            CarrierResponseModel model = new CarrierResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
