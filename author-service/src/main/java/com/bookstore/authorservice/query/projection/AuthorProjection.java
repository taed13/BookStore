package com.bookstore.authorservice.query.projection;

import com.bookstore.authorservice.command.data.Author;
import com.bookstore.authorservice.command.data.AuthorRepository;
import com.bookstore.authorservice.query.model.AuthorResponseModel;
import com.bookstore.authorservice.query.queries.GetAllAuthorByNameQuery;
import com.bookstore.authorservice.query.queries.GetAllAuthorQuery;
import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.query.GetProductByAuthorQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorProjection {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private QueryGateway queryGateway;

    @QueryHandler
    public List<AuthorResponseModel> getAllBook(GetAllAuthorQuery getAllBookQuery) {
        List<AuthorResponseModel> list = new ArrayList<>();
        List<Author> bookList = repository.findAll();
        bookList.forEach(book -> {
            AuthorResponseModel model = new AuthorResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public List<ProductResponseCommonModel> getAllBook(GetAllAuthorByNameQuery getAllAuthorByNameQuery) {
        List<ProductResponseCommonModel> product = new ArrayList<>();
        List<Author> author = repository.findByNameContainingIgnoreCase(getAllAuthorByNameQuery.getAuthorName());
        if (author.size() > 0) {
            for (int i = 0; i < author.size(); i++) {
                GetProductByAuthorQuery getProductByAuthorQuery = new GetProductByAuthorQuery(author.get(i).getId());
                product = queryGateway.query(getProductByAuthorQuery, ResponseTypes.multipleInstancesOf(
                        ProductResponseCommonModel.class
                )).join();
            }
        }
        return product;
    }

}
