package com.bookstore.provinceservice.query.projection;

import com.bookstore.commonservice.model.ProvinceResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsProvinceQuery;
import com.bookstore.provinceservice.command.data.Province;
import com.bookstore.provinceservice.command.data.ProvinceRepository;
import com.bookstore.provinceservice.query.model.ProvinceResponseModel;
import com.bookstore.provinceservice.query.queries.GetAllProvinceQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProvinceProjection {
    @Autowired
    private ProvinceRepository repository;

    @QueryHandler
    public List<ProvinceResponseModel> getAllBook(GetAllProvinceQuery getAll) {
        List<ProvinceResponseModel> list = new ArrayList<>();
        List<Province> List = repository.findAll();
        List.forEach(book -> {
            ProvinceResponseModel model = new ProvinceResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public ProvinceResponseCommonModel handle(GetDetailsProvinceQuery getDetailsProvinceQuery) {
        ProvinceResponseCommonModel model = new ProvinceResponseCommonModel();
        Province province = repository.getReferenceById(getDetailsProvinceQuery.getProvinceId());
        BeanUtils.copyProperties(province, model);
        return model;
    }
}
