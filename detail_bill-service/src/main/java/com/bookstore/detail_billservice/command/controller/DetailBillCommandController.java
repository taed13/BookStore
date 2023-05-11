package com.bookstore.detail_billservice.command.controller;

import com.bookstore.detail_billservice.command.command.CreateDetailBillCommand;
import com.bookstore.detail_billservice.command.command.DeleteDetailBillCommand;
import com.bookstore.detail_billservice.command.command.UpdateDetailBillCommand;
import com.bookstore.detail_billservice.command.model.DetailBillRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/detailBill")
public class DetailBillCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody DetailBillRequestModel model) {
        CreateDetailBillCommand command = new CreateDetailBillCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody DetailBillRequestModel model) {
        UpdateDetailBillCommand command = new UpdateDetailBillCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{detailBillId}")
    public String deleteBook(@PathVariable String detailBillId) {
        DeleteDetailBillCommand command = new DeleteDetailBillCommand(detailBillId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
