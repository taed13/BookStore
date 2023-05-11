package com.bookstore.warehouseservice.command.controller;

import com.bookstore.warehouseservice.command.command.CreateWarehouseCommand;
import com.bookstore.warehouseservice.command.command.DeleteWarehouseCommand;
import com.bookstore.warehouseservice.command.command.UpdateWarehouseCommand;
import com.bookstore.warehouseservice.command.model.WarehouseRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseCommandController {
    
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody WarehouseRequestModel model) {
        CreateWarehouseCommand command = new CreateWarehouseCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody WarehouseRequestModel model) {
        UpdateWarehouseCommand command = new UpdateWarehouseCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{warehouseId}")
    public String deleteBook(@PathVariable String warehouseId) {
        DeleteWarehouseCommand command = new DeleteWarehouseCommand(warehouseId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
