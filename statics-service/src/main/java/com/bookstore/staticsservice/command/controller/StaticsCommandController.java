package com.bookstore.staticsservice.command.controller;

import com.bookstore.staticsservice.command.command.CreateStaticsCommand;
import com.bookstore.staticsservice.command.command.DeleteStaticsCommand;
import com.bookstore.staticsservice.command.command.UpdateStaticsCommand;
import com.bookstore.staticsservice.command.model.StaticsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/statics")
public class StaticsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody StaticsRequestModel model) {
        CreateStaticsCommand command = new CreateStaticsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody StaticsRequestModel model) {
        UpdateStaticsCommand command = new UpdateStaticsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{staticsId}")
    public String deleteBook(@PathVariable String staticsId) {
        DeleteStaticsCommand command = new DeleteStaticsCommand(staticsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
