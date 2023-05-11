package com.bookstore.payment_methodservice.command.controller;

import com.bookstore.payment_methodservice.command.command.CreatePaymentMethodCommand;
import com.bookstore.payment_methodservice.command.command.DeletePaymentMethodCommand;
import com.bookstore.payment_methodservice.command.command.UpdatePaymentMethodCommand;
import com.bookstore.payment_methodservice.command.model.PaymentMethodRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/paymentMethod")
public class PaymentMethodCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody PaymentMethodRequestModel model) {
        CreatePaymentMethodCommand command = new CreatePaymentMethodCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody PaymentMethodRequestModel model) {
        UpdatePaymentMethodCommand command = new UpdatePaymentMethodCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{paymentMethodId}")
    public String deleteBook(@PathVariable String paymentMethodId) {
        DeletePaymentMethodCommand command = new DeletePaymentMethodCommand(paymentMethodId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
