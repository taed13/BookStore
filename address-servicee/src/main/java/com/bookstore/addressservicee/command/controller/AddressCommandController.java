package com.bookstore.addressservicee.command.controller;

import com.bookstore.addressservicee.command.command.CreateAddressCommand;
import com.bookstore.addressservicee.command.command.DeleteAddressCommand;
import com.bookstore.addressservicee.command.command.UpdateAddressCommand;
import com.bookstore.addressservicee.command.model.AddressRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
public class AddressCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody AddressRequestModel model) {
        CreateAddressCommand command = new CreateAddressCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody AddressRequestModel model) {
        UpdateAddressCommand command = new UpdateAddressCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{addressId}")
    public String deleteBook(@PathVariable String addressId) {
        DeleteAddressCommand command = new DeleteAddressCommand(addressId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
