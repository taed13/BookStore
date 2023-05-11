package com.bookstore.user_favouriteservice.query.projection;

import com.bookstore.user_favouriteservice.command.data.UserFavourite;
import com.bookstore.user_favouriteservice.command.data.UserFavouriteRepository;
import com.bookstore.user_favouriteservice.query.model.UserFavouriteResponseModel;
import com.bookstore.user_favouriteservice.query.queries.GetAllUserFavouriteQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFavouriteProjection {

    @Autowired
    private UserFavouriteRepository repository;

    @QueryHandler
    public List<UserFavouriteResponseModel> getAllBook(GetAllUserFavouriteQuery getAll) {
        List<UserFavouriteResponseModel> list = new ArrayList<>();
        List<UserFavourite> List = repository.findAll();
        List.forEach(book -> {
            UserFavouriteResponseModel model = new UserFavouriteResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
