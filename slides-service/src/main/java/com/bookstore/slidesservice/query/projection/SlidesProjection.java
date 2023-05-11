package com.bookstore.slidesservice.query.projection;

import com.bookstore.slidesservice.command.data.Slides;
import com.bookstore.slidesservice.command.data.SlidesRepository;
import com.bookstore.slidesservice.query.model.SlidesResponseModel;
import com.bookstore.slidesservice.query.queries.GetAllSlidesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SlidesProjection {
    @Autowired
    private SlidesRepository repository;

    @QueryHandler
    public List<SlidesResponseModel> getAllBook(GetAllSlidesQuery getAll) {
        List<SlidesResponseModel> list = new ArrayList<>();
        List<Slides> List = repository.findAll();
        List.forEach(book -> {
            SlidesResponseModel model = new SlidesResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
