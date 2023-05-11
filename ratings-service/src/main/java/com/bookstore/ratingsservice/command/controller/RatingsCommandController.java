package com.bookstore.ratingsservice.command.controller;

import com.bookstore.ratingsservice.command.command.CreateRatingsCommand;
import com.bookstore.ratingsservice.command.command.DeleteRatingsCommand;
import com.bookstore.ratingsservice.command.command.UpdateRatingsCommand;
import com.bookstore.ratingsservice.command.model.RatingsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody RatingsRequestModel model) {
        CreateRatingsCommand command = new CreateRatingsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody RatingsRequestModel model) {
        UpdateRatingsCommand command = new UpdateRatingsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{ratingsId}")
    public String deleteBook(@PathVariable String ratingsId) {
        DeleteRatingsCommand command = new DeleteRatingsCommand(ratingsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
