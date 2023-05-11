package com.bookstore.paymentsservice.command.controller;

import com.bookstore.paymentsservice.command.command.CreatePaymentsCommand;
import com.bookstore.paymentsservice.command.command.DeletePaymentsCommand;
import com.bookstore.paymentsservice.command.command.UpdatePaymentsCommand;
import com.bookstore.paymentsservice.command.model.PaymentsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody PaymentsRequestModel model) {
        CreatePaymentsCommand command = new CreatePaymentsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody PaymentsRequestModel model) {
        UpdatePaymentsCommand command = new UpdatePaymentsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{paymentsId}")
    public String deleteBook(@PathVariable String paymentsId) {
        DeletePaymentsCommand command = new DeletePaymentsCommand(paymentsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
