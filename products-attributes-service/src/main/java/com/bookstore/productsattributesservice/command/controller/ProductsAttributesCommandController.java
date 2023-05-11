package com.bookstore.productsattributesservice.command.controller;

import com.bookstore.productsattributesservice.command.command.CreateProductsAttributesCommand;
import com.bookstore.productsattributesservice.command.command.DeleteProductsAttributesCommand;
import com.bookstore.productsattributesservice.command.command.UpdateProductsAttributesCommand;
import com.bookstore.productsattributesservice.command.model.ProductsAttributesRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productsAttributes")
public class ProductsAttributesCommandController {


    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ProductsAttributesRequestModel model) {
        CreateProductsAttributesCommand command = new CreateProductsAttributesCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProductsAttributesRequestModel model) {
        UpdateProductsAttributesCommand command = new UpdateProductsAttributesCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{productsAttributesId}")
    public String deleteBook(@PathVariable String productsAttributesId) {
        DeleteProductsAttributesCommand command = new DeleteProductsAttributesCommand(productsAttributesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
