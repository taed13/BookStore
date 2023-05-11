package com.bookstore.categoriesservice.query.projection;

import com.bookstore.categoriesservice.command.data.Categories;
import com.bookstore.categoriesservice.command.data.CategoriesRepository;
import com.bookstore.categoriesservice.query.model.CategoriesResponseModel;
import com.bookstore.categoriesservice.query.queries.GetAllCategoriesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

@Component
public class CategoriesProjection {

    @Autowired
    private CategoriesRepository repository;

    @QueryHandler
    public List<CategoriesResponseModel> getAllBook(GetAllCategoriesQuery getAll) {
        List<CategoriesResponseModel> list = new ArrayList<>();
        List<Categories> List = repository.findAll();
        List.forEach(book -> {
            CategoriesResponseModel model = new CategoriesResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
