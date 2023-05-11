package com.bookstore.products_keywordsservice.query.projection;

import com.bookstore.products_keywordsservice.command.data.ProductsKeywords;
import com.bookstore.products_keywordsservice.command.data.ProductsKeywordsRepository;
import com.bookstore.products_keywordsservice.query.model.ProductsKeywordsResponseModel;
import com.bookstore.products_keywordsservice.query.queries.GetAllProductsKeywordsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsKeywordsProjection {

    @Autowired
    private ProductsKeywordsRepository repository;

    @QueryHandler
    public List<ProductsKeywordsResponseModel> getAllBook(GetAllProductsKeywordsQuery getAll) {
        List<ProductsKeywordsResponseModel> list = new ArrayList<>();
        List<ProductsKeywords> List = repository.findAll();
        List.forEach(book -> {
            ProductsKeywordsResponseModel model = new ProductsKeywordsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
