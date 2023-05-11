package com.bookstore.publisherservice.query.projection;

import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.query.GetProductByPublisherQuery;
import com.bookstore.publisherservice.command.data.Publisher;
import com.bookstore.publisherservice.command.data.PublisherRepository;
import com.bookstore.publisherservice.query.model.PublisherResponseModel;
import com.bookstore.publisherservice.query.queries.GetAllPublisherByNameQuery;
import com.bookstore.publisherservice.query.queries.GetAllPublisherQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherProjection {

    @Autowired
    private PublisherRepository repository;

    @Autowired
    private QueryGateway queryGateway;

    @QueryHandler
    public List<PublisherResponseModel> getAllBook(GetAllPublisherQuery getAllBookQuery) {
        List<PublisherResponseModel> list = new ArrayList<>();
        List<Publisher> bookList = repository.findAll();
        bookList.forEach(book -> {
            PublisherResponseModel model = new PublisherResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }

    @QueryHandler
    public List<ProductResponseCommonModel> getAllBook(GetAllPublisherByNameQuery getAllPublisherByNameQuery) {
        List<ProductResponseCommonModel> product = new ArrayList<>();
        List<Publisher> Publisher = repository.findByNameContainingIgnoreCase(getAllPublisherByNameQuery.getPublisherName());
        if (Publisher.size() > 0) {
            for (int i = 0; i < Publisher.size(); i++) {
                GetProductByPublisherQuery getProductByPublisherQuery = new GetProductByPublisherQuery(Publisher.get(i).getId());
                product = queryGateway.query(getProductByPublisherQuery, ResponseTypes.multipleInstancesOf(
                        ProductResponseCommonModel.class
                )).join();
            }
        }
        return product;
    }
    
}
