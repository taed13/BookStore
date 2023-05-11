package com.bookstore.publisherservice.command.controller;


import com.bookstore.publisherservice.command.command.CreatePublisherCommand;
import com.bookstore.publisherservice.command.command.DeletePublisherCommand;
import com.bookstore.publisherservice.command.command.UpdatePublisherCommand;
import com.bookstore.publisherservice.command.model.PublisherRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody PublisherRequestModel model) {
        CreatePublisherCommand command = new CreatePublisherCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody PublisherRequestModel model) {
        UpdatePublisherCommand command = new UpdatePublisherCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{publisherId}")
    public String deleteBook(@PathVariable String publisherId) {
        DeletePublisherCommand command = new DeletePublisherCommand(publisherId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
