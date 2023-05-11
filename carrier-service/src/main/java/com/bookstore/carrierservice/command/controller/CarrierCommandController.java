package com.bookstore.carrierservice.command.controller;

import com.bookstore.carrierservice.command.command.CreateCarrierCommand;
import com.bookstore.carrierservice.command.command.DeleteCarrierCommand;
import com.bookstore.carrierservice.command.command.UpdateCarrierCommand;
import com.bookstore.carrierservice.command.model.CarrierRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/carrier")
public class CarrierCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody CarrierRequestModel model) {
        CreateCarrierCommand command = new CreateCarrierCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody CarrierRequestModel model) {
        UpdateCarrierCommand command = new UpdateCarrierCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{CarrierId}")
    public String deleteBook(@PathVariable String CarrierId) {
        DeleteCarrierCommand command = new DeleteCarrierCommand(CarrierId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
