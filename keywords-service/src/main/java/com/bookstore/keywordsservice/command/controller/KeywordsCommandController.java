package com.bookstore.keywordsservice.command.controller;

import com.bookstore.keywordsservice.command.command.CreateKeywordsCommand;
import com.bookstore.keywordsservice.command.command.DeleteKeywordsCommand;
import com.bookstore.keywordsservice.command.command.UpdateKeywordsCommand;
import com.bookstore.keywordsservice.command.model.KeywordsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/keywords")
public class KeywordsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody KeywordsRequestModel model) {
        CreateKeywordsCommand command = new CreateKeywordsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody KeywordsRequestModel model) {
        UpdateKeywordsCommand command = new UpdateKeywordsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{keywordsId}")
    public String deleteBook(@PathVariable String keywordsId) {
        DeleteKeywordsCommand command = new DeleteKeywordsCommand(keywordsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
