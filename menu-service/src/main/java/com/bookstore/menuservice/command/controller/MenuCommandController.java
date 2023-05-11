package com.bookstore.menuservice.command.controller;

import com.bookstore.menuservice.command.command.CreateMenuCommand;
import com.bookstore.menuservice.command.command.DeleteMenuCommand;
import com.bookstore.menuservice.command.command.UpdateMenuCommand;
import com.bookstore.menuservice.command.model.MenuRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody MenuRequestModel model) {
        CreateMenuCommand command = new CreateMenuCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody MenuRequestModel model) {
        UpdateMenuCommand command = new UpdateMenuCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{menuId}")
    public String deleteBook(@PathVariable String menuId) {
        DeleteMenuCommand command = new DeleteMenuCommand(menuId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
