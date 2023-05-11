package com.bookstore.commentsservice.command.controller;

import com.bookstore.commentsservice.command.command.CreateCommentsCommand;
import com.bookstore.commentsservice.command.command.DeleteCommentsCommand;
import com.bookstore.commentsservice.command.command.UpdateCommentsCommand;
import com.bookstore.commentsservice.command.model.CommentsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody CommentsRequestModel model) {
        CreateCommentsCommand command = new CreateCommentsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody CommentsRequestModel model) {
        UpdateCommentsCommand command = new UpdateCommentsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{commentsId}")
    public String deleteBook(@PathVariable String commentsId) {
        DeleteCommentsCommand command = new DeleteCommentsCommand(commentsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
