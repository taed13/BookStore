package com.bookstore.attributesservice.query.projection;

import com.bookstore.attributesservice.command.data.Attributes;
import com.bookstore.attributesservice.command.data.AttributesRepository;
import com.bookstore.attributesservice.query.model.AttributesResponseModel;
import com.bookstore.attributesservice.query.queries.GetAllAttributesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttributesProjection {

    @Autowired
    private AttributesRepository repository;

    @QueryHandler
    public List<AttributesResponseModel> getAllBook(GetAllAttributesQuery getAll) {
        List<AttributesResponseModel> list = new ArrayList<>();
        List<Attributes> List = repository.findAll();
        List.forEach(book -> {
            AttributesResponseModel model = new AttributesResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
