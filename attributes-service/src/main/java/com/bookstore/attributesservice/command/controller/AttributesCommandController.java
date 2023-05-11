package com.bookstore.attributesservice.command.controller;

import com.bookstore.attributesservice.command.command.CreateAttributesCommand;
import com.bookstore.attributesservice.command.command.DeleteAttributesCommand;
import com.bookstore.attributesservice.command.command.UpdateAttributesCommand;
import com.bookstore.attributesservice.command.model.AttributesRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/attributes")
public class AttributesCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody AttributesRequestModel model) {
        CreateAttributesCommand command = new CreateAttributesCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody AttributesRequestModel model) {
        UpdateAttributesCommand command = new UpdateAttributesCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{attributesId}")
    public String deleteBook(@PathVariable String attributesId) {
        DeleteAttributesCommand command = new DeleteAttributesCommand(attributesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
