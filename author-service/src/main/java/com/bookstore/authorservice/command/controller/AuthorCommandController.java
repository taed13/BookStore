package com.bookstore.authorservice.command.controller;

import com.bookstore.authorservice.command.command.CreateAuthorCommand;
import com.bookstore.authorservice.command.command.DeleteAuthorCommand;
import com.bookstore.authorservice.command.command.UpdateAuthorCommand;
import com.bookstore.authorservice.command.model.AuthorRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody AuthorRequestModel model) {
        CreateAuthorCommand command = new CreateAuthorCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody AuthorRequestModel model) {
        UpdateAuthorCommand command = new UpdateAuthorCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{authorId}")
    public String deleteBook(@PathVariable String authorId) {
        DeleteAuthorCommand command = new DeleteAuthorCommand(authorId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
