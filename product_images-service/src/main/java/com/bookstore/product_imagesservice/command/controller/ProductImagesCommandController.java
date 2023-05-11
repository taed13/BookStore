package com.bookstore.product_imagesservice.command.controller;

import com.bookstore.product_imagesservice.command.command.CreateProductImagesCommand;
import com.bookstore.product_imagesservice.command.command.DeleteProductImagesCommand;
import com.bookstore.product_imagesservice.command.command.UpdateProductImagesCommand;
import com.bookstore.product_imagesservice.command.model.ProductImagesModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productImages")
public class ProductImagesCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ProductImagesModel model) {
        CreateProductImagesCommand command = new CreateProductImagesCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProductImagesModel model) {
        UpdateProductImagesCommand command = new UpdateProductImagesCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{productImagesId}")
    public String deleteBook(@PathVariable String productImagesId) {
        DeleteProductImagesCommand command = new DeleteProductImagesCommand(productImagesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
