package com.bookstore.manage_warehouseservice.command.controller;

import com.bookstore.manage_warehouseservice.command.command.CreateManageWarehouseCommand;
import com.bookstore.manage_warehouseservice.command.command.DeleteManageWarehouseCommand;
import com.bookstore.manage_warehouseservice.command.command.UpdateManageWarehouseCommand;
import com.bookstore.manage_warehouseservice.command.model.ManageWarehouseRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/manageWarehouse")
public class ManageWarehouseCommandController {


    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ManageWarehouseRequestModel model) {
        CreateManageWarehouseCommand command = new CreateManageWarehouseCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ManageWarehouseRequestModel model) {
        UpdateManageWarehouseCommand command = new UpdateManageWarehouseCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{manageWarehouseId}")
    public String deleteBook(@PathVariable String manageWarehouseId) {
        DeleteManageWarehouseCommand command = new DeleteManageWarehouseCommand(manageWarehouseId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
