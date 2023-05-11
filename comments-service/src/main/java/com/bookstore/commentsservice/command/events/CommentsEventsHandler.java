package com.bookstore.commentsservice.command.events;

import com.bookstore.commentsservice.command.data.Comments;
import com.bookstore.commentsservice.command.data.CommentsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentsEventsHandler {

    @Autowired
    private CommentsRepository repository;

    @EventHandler
    public void on(CommentsCreateEvent event) {
        Comments articles = new Comments();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(CommentsUpdateEvent event) {
        Comments articles = new Comments();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(CommentsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}
