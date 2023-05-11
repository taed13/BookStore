package com.bookstore.staticsservice.query.projection;

import com.bookstore.staticsservice.command.data.Statics;
import com.bookstore.staticsservice.command.data.StaticsRepository;
import com.bookstore.staticsservice.query.model.StaticsResponseModel;
import com.bookstore.staticsservice.query.queries.GetAllStaticsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaticsProjection {

    @Autowired
    private StaticsRepository repository;

    @QueryHandler
    public List<StaticsResponseModel> getAllBook(GetAllStaticsQuery getAll) {
        List<StaticsResponseModel> list = new ArrayList<>();
        List<Statics> List = repository.findAll();
        List.forEach(book -> {
            StaticsResponseModel model = new StaticsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
