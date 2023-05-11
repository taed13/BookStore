package com.bookstore.product_imagesservice.query.projection;

import com.bookstore.product_imagesservice.command.data.ProductImages;
import com.bookstore.product_imagesservice.command.data.ProductImagesRepository;
import com.bookstore.product_imagesservice.query.model.ProductImagesResponseModel;
import com.bookstore.product_imagesservice.query.queries.GetAllProductImagesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductImagesProjection {

    @Autowired
    private ProductImagesRepository repository;

    @QueryHandler
    public List<ProductImagesResponseModel> getAllBook(GetAllProductImagesQuery getAll) {
        List<ProductImagesResponseModel> list = new ArrayList<>();
        List<ProductImages> List = repository.findAll();
        List.forEach(book -> {
            ProductImagesResponseModel model = new ProductImagesResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
