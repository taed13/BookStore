package com.bookstore.categoriesservice.command.controller;

import com.bookstore.categoriesservice.command.command.CreateCategoriesCommand;
import com.bookstore.categoriesservice.command.command.DeleteCategoriesCommand;
import com.bookstore.categoriesservice.command.command.UpdateCategoriesCommand;
import com.bookstore.categoriesservice.command.model.CategoriesRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody CategoriesRequestModel model) {
        CreateCategoriesCommand command = new CreateCategoriesCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody CategoriesRequestModel model) {
        UpdateCategoriesCommand command = new UpdateCategoriesCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{categoriesId}")
    public String deleteBook(@PathVariable String categoriesId) {
        DeleteCategoriesCommand command = new DeleteCategoriesCommand(categoriesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
