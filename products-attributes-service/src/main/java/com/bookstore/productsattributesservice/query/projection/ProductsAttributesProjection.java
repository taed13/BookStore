package com.bookstore.productsattributesservice.query.projection;

import com.bookstore.productsattributesservice.command.data.ProductsAttributes;
import com.bookstore.productsattributesservice.command.data.ProductsAttributesRepository;
import com.bookstore.productsattributesservice.query.model.ProductsAttributesResponseModel;
import com.bookstore.productsattributesservice.query.queries.GetAllProductsAttributesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsAttributesProjection {
    @Autowired
    private ProductsAttributesRepository repository;

    @QueryHandler
    public List<ProductsAttributesResponseModel> getAllBook(GetAllProductsAttributesQuery getAll) {
        List<ProductsAttributesResponseModel> list = new ArrayList<>();
        List<ProductsAttributes> List = repository.findAll();
        List.forEach(book -> {
            ProductsAttributesResponseModel model = new ProductsAttributesResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
