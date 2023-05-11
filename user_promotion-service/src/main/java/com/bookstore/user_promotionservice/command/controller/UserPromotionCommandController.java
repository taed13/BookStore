package com.bookstore.user_promotionservice.command.controller;

import com.bookstore.user_promotionservice.command.command.CreateUserPromotionCommand;
import com.bookstore.user_promotionservice.command.command.DeleteUserPromotionCommand;
import com.bookstore.user_promotionservice.command.command.UpdateUserPromotionCommand;
import com.bookstore.user_promotionservice.command.model.UserPromotionRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/userPromotion")
public class UserPromotionCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody UserPromotionRequestModel model) {
        CreateUserPromotionCommand command = new CreateUserPromotionCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody UserPromotionRequestModel model) {
        UpdateUserPromotionCommand command = new UpdateUserPromotionCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{userPromotionId}")
    public String deleteBook(@PathVariable String userPromotionId) {
        DeleteUserPromotionCommand command = new DeleteUserPromotionCommand(userPromotionId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
