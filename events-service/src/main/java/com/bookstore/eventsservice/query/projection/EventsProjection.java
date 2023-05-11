package com.bookstore.eventsservice.query.projection;

import com.bookstore.eventsservice.command.data.Events;
import com.bookstore.eventsservice.command.data.EventsRepository;
import com.bookstore.eventsservice.query.model.EventsResponseModel;
import com.bookstore.eventsservice.query.queries.GetAllEventsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventsProjection {
    @Autowired
    private EventsRepository repository;

    @QueryHandler
    public List<EventsResponseModel> getAllBook(GetAllEventsQuery getAll) {
        List<EventsResponseModel> list = new ArrayList<>();
        List<Events> List = repository.findAll();
        List.forEach(book -> {
            EventsResponseModel model = new EventsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
