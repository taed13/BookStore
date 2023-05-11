package com.bookstore.addressservicee.query.projection;

import com.bookstore.addressservicee.command.data.Address;
import com.bookstore.addressservicee.command.data.AddressRepository;
import com.bookstore.addressservicee.query.model.AddressResponseModel;
import com.bookstore.addressservicee.query.queries.GetAllAddressQuery;
import com.bookstore.commonservice.model.AddressResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsAddressQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressProjection {

    @Autowired
    private AddressRepository repository;

    @QueryHandler
    public List<AddressResponseModel> getAllBook(GetAllAddressQuery getAllBookQuery) {
        List<AddressResponseModel> list = new ArrayList<>();
        List<Address> bookList = repository.findAll();
        bookList.forEach(book -> {
            AddressResponseModel model = new AddressResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public AddressResponseCommonModel handle(GetDetailsAddressQuery getDetailsAddressQuery) {
        AddressResponseCommonModel model = new AddressResponseCommonModel();
        Address Address = repository.findByUserId(getDetailsAddressQuery.getId());
        BeanUtils.copyProperties(Address, model);
        return model;
    }
}
