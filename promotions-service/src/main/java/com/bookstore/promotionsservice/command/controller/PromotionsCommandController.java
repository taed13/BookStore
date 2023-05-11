package com.bookstore.promotionsservice.command.controller;

import com.bookstore.promotionsservice.command.command.CreatePromotionsCommand;
import com.bookstore.promotionsservice.command.command.DeletePromotionsCommand;
import com.bookstore.promotionsservice.command.command.UpdatePromotionsCommand;
import com.bookstore.promotionsservice.command.model.PromotionsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody PromotionsRequestModel model) {
        CreatePromotionsCommand command = new CreatePromotionsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody PromotionsRequestModel model) {
        UpdatePromotionsCommand command = new UpdatePromotionsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{promotionsId}")
    public String deleteBook(@PathVariable String promotionsId) {
        DeletePromotionsCommand command = new DeletePromotionsCommand(promotionsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
