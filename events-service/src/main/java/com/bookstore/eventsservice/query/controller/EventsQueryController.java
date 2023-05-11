package com.bookstore.eventsservice.query.controller;

import com.bookstore.eventsservice.query.model.EventsResponseModel;
import com.bookstore.eventsservice.query.queries.GetAllEventsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventsQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<EventsResponseModel> getAll() {
        GetAllEventsQuery getAllBookQuery = new GetAllEventsQuery();
        List<EventsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(EventsResponseModel.class)).join();
        return list;
    }
}
