package com.bookstore.shippingservice.command.controller;

import com.bookstore.shippingservice.command.command.CreateShippingCommand;
import com.bookstore.shippingservice.command.command.DeleteShippingCommand;
import com.bookstore.shippingservice.command.command.UpdateShippingCommand;
import com.bookstore.shippingservice.command.model.ShippingRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ShippingRequestModel model) {
        CreateShippingCommand command = new CreateShippingCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ShippingRequestModel model) {
        UpdateShippingCommand command = new UpdateShippingCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{shippingId}")
    public String deleteBook(@PathVariable String shippingId) {
        DeleteShippingCommand command = new DeleteShippingCommand(shippingId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
