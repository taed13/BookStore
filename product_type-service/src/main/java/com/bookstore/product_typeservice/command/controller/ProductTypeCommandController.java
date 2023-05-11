package com.bookstore.product_typeservice.command.controller;

import com.bookstore.product_typeservice.command.command.CreateProductTypeCommand;
import com.bookstore.product_typeservice.command.command.DeleteProductTypeCommand;
import com.bookstore.product_typeservice.command.command.UpdateProductTypeCommand;
import com.bookstore.product_typeservice.command.model.ProductTypeRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productType")
public class ProductTypeCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody ProductTypeRequestModel model) {
        CreateProductTypeCommand command = new CreateProductTypeCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProductTypeRequestModel model) {
        UpdateProductTypeCommand command = new UpdateProductTypeCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{ProductTypeId}")
    public String deleteBook(@PathVariable String ProductTypeId) {
        DeleteProductTypeCommand command = new DeleteProductTypeCommand(ProductTypeId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
