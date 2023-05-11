package com.bookstore.ratingsservice.query.projection;

import com.bookstore.ratingsservice.command.data.Ratings;
import com.bookstore.ratingsservice.command.data.RatingsRepository;
import com.bookstore.ratingsservice.query.model.RatingsResponseModel;
import com.bookstore.ratingsservice.query.queries.GetAllRatingsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingsProjection {

    @Autowired
    private RatingsRepository repository;

    @QueryHandler
    public List<RatingsResponseModel> getAllBook(GetAllRatingsQuery getAll) {
        List<RatingsResponseModel> list = new ArrayList<>();
        List<Ratings> List = repository.findAll();
        List.forEach(book -> {
            RatingsResponseModel model = new RatingsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
