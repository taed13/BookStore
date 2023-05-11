package com.bookstore.billservice.query.projection;

import com.bookstore.billservice.command.data.Bill;
import com.bookstore.billservice.command.data.BillRepository;
import com.bookstore.billservice.query.model.BillResponseModel;
import com.bookstore.billservice.query.queries.GetAllBillQuery;
import com.bookstore.commonservice.model.AddressResponseCommonModel;
import com.bookstore.commonservice.model.BillResponseCommonModel;
import com.bookstore.commonservice.model.ProvinceResponseCommonModel;
import com.bookstore.commonservice.model.UserResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsAddressQuery;
import com.bookstore.commonservice.query.GetDetailsBillQuery;
import com.bookstore.commonservice.query.GetDetailsProvinceQuery;
import com.bookstore.commonservice.query.GetDetailsUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillProjection {

    @Autowired
    private BillRepository repository;

    @QueryHandler
    public List<BillResponseModel> getAllBook(GetAllBillQuery getAll) {
        List<BillResponseModel> list = new ArrayList<>();
        List<Bill> List = repository.findAll();
        List.forEach(book -> {
            BillResponseModel billResponseModel = new BillResponseModel();
            BeanUtils.copyProperties(book, billResponseModel);
            list.add(billResponseModel);
        });
        return list;
    }

    @QueryHandler
    public BillResponseCommonModel getBillById(GetDetailsBillQuery query) {
        BillResponseCommonModel model = new BillResponseCommonModel();
        Bill bill= repository.findByIdAndUserId(query.getBillId(), query.getUserId());
        if (bill != null) {
            BeanUtils.copyProperties(bill, model);
        }
        return model;
    }

}
