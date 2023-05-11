package com.bookstore.commentsservice.query.controller;

import com.bookstore.commentsservice.query.model.CommentsResponseModel;
import com.bookstore.commentsservice.query.queries.GetAllCommentsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<CommentsResponseModel> getAll() {
        GetAllCommentsQuery getAllBookQuery = new GetAllCommentsQuery();
        List<CommentsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(CommentsResponseModel.class)).join();
        return list;
    }
}
