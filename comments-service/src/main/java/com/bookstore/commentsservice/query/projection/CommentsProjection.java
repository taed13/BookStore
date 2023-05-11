package com.bookstore.commentsservice.query.projection;

import com.bookstore.commentsservice.command.data.Comments;
import com.bookstore.commentsservice.command.data.CommentsRepository;
import com.bookstore.commentsservice.query.model.CommentsResponseModel;
import com.bookstore.commentsservice.query.queries.GetAllCommentsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentsProjection {

    @Autowired
    private CommentsRepository repository;

    @QueryHandler
    public List<CommentsResponseModel> getAllBook(GetAllCommentsQuery getAll) {
        List<CommentsResponseModel> list = new ArrayList<>();
        List<Comments> List = repository.findAll();
        List.forEach(book -> {
            CommentsResponseModel model = new CommentsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
