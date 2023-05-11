package com.bookstore.billservice.command.controller;

import com.bookstore.billservice.command.command.CreateBillCommand;
import com.bookstore.billservice.command.command.DeleteBillCommand;
import com.bookstore.billservice.command.command.UpdateBillCommand;
import com.bookstore.billservice.command.model.BillRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bill")
public class BillCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody BillRequestModel model) {
        CreateBillCommand command = new CreateBillCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody BillRequestModel model) {
        UpdateBillCommand command = new UpdateBillCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{billId}")
    public String deleteBook(@PathVariable String billId) {
        DeleteBillCommand command = new DeleteBillCommand(billId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
