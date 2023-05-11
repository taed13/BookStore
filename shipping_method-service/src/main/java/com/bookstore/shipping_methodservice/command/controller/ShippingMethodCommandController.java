package com.bookstore.shipping_methodservice.command.controller;

import com.bookstore.shipping_methodservice.command.command.CreateShippingMethodCommand;
import com.bookstore.shipping_methodservice.command.command.DeleteShippingMethodCommand;
import com.bookstore.shipping_methodservice.command.command.UpdateShippingMethodCommand;
import com.bookstore.shipping_methodservice.command.model.ShippingMethodRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shippingMethod")
public class ShippingMethodCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ShippingMethodRequestModel model) {
        CreateShippingMethodCommand command = new CreateShippingMethodCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ShippingMethodRequestModel model) {
        UpdateShippingMethodCommand command = new UpdateShippingMethodCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{shippingMethodId}")
    public String deleteBook(@PathVariable String shippingMethodId) {
        DeleteShippingMethodCommand command = new DeleteShippingMethodCommand(shippingMethodId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
