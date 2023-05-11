package com.bookstore.keywordsservice.query.projection;

import com.bookstore.keywordsservice.command.data.Keywords;
import com.bookstore.keywordsservice.command.data.KeywordsRepository;
import com.bookstore.keywordsservice.query.model.KeywordsResponseModel;
import com.bookstore.keywordsservice.query.queries.GetAllKeywordsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class KeywordsProjection {

    @Autowired
    private KeywordsRepository repository;

    @QueryHandler
    public List<KeywordsResponseModel> getAllBook(GetAllKeywordsQuery getAll) {
        List<KeywordsResponseModel> list = new ArrayList<>();
        List<Keywords> List = repository.findAll();
        List.forEach(book -> {
            KeywordsResponseModel model = new KeywordsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
