package com.bookstore.user_favouriteservice.command.controller;

import com.bookstore.user_favouriteservice.command.command.CreateUserFavouriteCommand;
import com.bookstore.user_favouriteservice.command.command.DeleteUserFavouriteCommand;
import com.bookstore.user_favouriteservice.command.command.UpdateUserFavouriteCommand;
import com.bookstore.user_favouriteservice.command.model.UserFavouriteRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/userFavourite")
public class UserFavouriteCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody UserFavouriteRequestModel model) {
        CreateUserFavouriteCommand command = new CreateUserFavouriteCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody UserFavouriteRequestModel model) {
        UpdateUserFavouriteCommand command = new UpdateUserFavouriteCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{userFavouriteId}")
    public String deleteBook(@PathVariable String userFavouriteId) {
        DeleteUserFavouriteCommand command = new DeleteUserFavouriteCommand(userFavouriteId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
