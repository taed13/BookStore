package com.bookstore.eventsservice.command.controller;

import com.bookstore.eventsservice.command.command.CreateEventsCommand;
import com.bookstore.eventsservice.command.command.DeleteEventsCommand;
import com.bookstore.eventsservice.command.command.UpdateEventsCommand;
import com.bookstore.eventsservice.command.model.EventsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
public class EventsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody EventsRequestModel model) {
        CreateEventsCommand command = new CreateEventsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody EventsRequestModel model) {
        UpdateEventsCommand command = new UpdateEventsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{eventsId}")
    public String deleteBook(@PathVariable String eventsId) {
        DeleteEventsCommand command = new DeleteEventsCommand(eventsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
