package com.bookstore.publisherservice.query.controller;

import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.publisherservice.query.model.PublisherResponseModel;
import com.bookstore.publisherservice.query.queries.GetAllPublisherByNameQuery;
import com.bookstore.publisherservice.query.queries.GetAllPublisherQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<PublisherResponseModel> getAllBook() {
        GetAllPublisherQuery getAllBookQuery = new GetAllPublisherQuery();
        List<PublisherResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(PublisherResponseModel.class)).join();
        return list;
    }

    @GetMapping("/products/publisherName")
    public List<ProductResponseCommonModel> getAllBook(@RequestParam(required = false) String publisherName) {
        GetAllPublisherByNameQuery PublisherQuery = new GetAllPublisherByNameQuery(publisherName);
        List<ProductResponseCommonModel> list = queryGateway.query(PublisherQuery,
                ResponseTypes.multipleInstancesOf(ProductResponseCommonModel.class)).join();
        return list;
    }
    
}
