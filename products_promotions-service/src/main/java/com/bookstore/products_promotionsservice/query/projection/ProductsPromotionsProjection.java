package com.bookstore.products_promotionsservice.query.projection;

import com.bookstore.products_promotionsservice.command.data.ProductsPromotions;
import com.bookstore.products_promotionsservice.command.data.ProductsPromotionsRepository;
import com.bookstore.products_promotionsservice.query.model.ProductsPromotionsResponseModel;
import com.bookstore.products_promotionsservice.query.queries.GetAllProductsPromotionsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsPromotionsProjection {

    @Autowired
    private ProductsPromotionsRepository repository;

    @QueryHandler
    public List<ProductsPromotionsResponseModel> getAllBook(GetAllProductsPromotionsQuery getAll) {
        List<ProductsPromotionsResponseModel> list = new ArrayList<>();
        List<ProductsPromotions> List = repository.findAll();
        List.forEach(book -> {
            ProductsPromotionsResponseModel model = new ProductsPromotionsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
