package com.bookstore.productservice.command.controller;

import com.bookstore.productservice.command.command.CreateProductCommand;
import com.bookstore.productservice.command.command.DeleteProductCommand;
import com.bookstore.productservice.command.command.UpdateProductCommand;
import com.bookstore.productservice.command.model.ProductRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ProductRequestModel model) {
        CreateProductCommand command = new CreateProductCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProductRequestModel model) {
        UpdateProductCommand command = new UpdateProductCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{articlesId}")
    public String deleteBook(@PathVariable String articlesId) {
        DeleteProductCommand command = new DeleteProductCommand(articlesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
