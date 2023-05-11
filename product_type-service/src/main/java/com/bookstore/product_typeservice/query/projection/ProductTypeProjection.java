package com.bookstore.product_typeservice.query.projection;

import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.query.GetProductByProductTypeQuery;
import com.bookstore.product_typeservice.command.data.ProductType;
import com.bookstore.product_typeservice.command.data.ProductTypeRepository;
import com.bookstore.product_typeservice.query.model.ProductTypeResponseModel;
import com.bookstore.product_typeservice.query.queries.GetAllProductTypeByNameQuery;
import com.bookstore.product_typeservice.query.queries.GetAllProductTypeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTypeProjection {

    @Autowired
    private ProductTypeRepository repository;

    @Autowired
    private QueryGateway queryGateway;

    @QueryHandler
    public List<ProductTypeResponseModel> getAllBook(GetAllProductTypeQuery getAllBookQuery) {
        List<ProductTypeResponseModel> list = new ArrayList<>();
        List<ProductType> bookList = repository.findAll();
        bookList.forEach(book -> {
            ProductTypeResponseModel model = new ProductTypeResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public List<ProductResponseCommonModel> getAllBook(GetAllProductTypeByNameQuery nameQuery) {
        List<ProductResponseCommonModel> product = new ArrayList<>();
        List<ProductType> productTypes = repository.findByNameIn(nameQuery.getName());
        if (productTypes.size() > 0) {
            for (int i = 0; i < productTypes.size(); i++) {
                GetProductByProductTypeQuery getProductByAuthorQuery = new GetProductByProductTypeQuery(productTypes.get(i).getId());
                product = queryGateway.query(getProductByAuthorQuery, ResponseTypes.multipleInstancesOf(
                        ProductResponseCommonModel.class
                )).join();
            }
        }
        return product;
    }
}
