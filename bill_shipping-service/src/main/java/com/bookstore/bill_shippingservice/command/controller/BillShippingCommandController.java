package com.bookstore.bill_shippingservice.command.controller;

import com.bookstore.bill_shippingservice.command.command.CreateBillShippingCommand;
import com.bookstore.bill_shippingservice.command.command.DeleteBillShippingCommand;
import com.bookstore.bill_shippingservice.command.command.UpdateBillShippingCommand;
import com.bookstore.bill_shippingservice.command.model.BillShippingModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/billShipping")
public class BillShippingCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody BillShippingModel model) {
        CreateBillShippingCommand command = new CreateBillShippingCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody BillShippingModel model) {
        UpdateBillShippingCommand command = new UpdateBillShippingCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{billShippingId}")
    public String deleteBook(@PathVariable String billShippingId) {
        DeleteBillShippingCommand command = new DeleteBillShippingCommand(billShippingId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
