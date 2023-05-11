package com.bookstore.products_keywordsservice.command.controller;

import com.bookstore.products_keywordsservice.command.command.CreateProductsKeywordsCommand;
import com.bookstore.products_keywordsservice.command.command.DeleteProductsKeywordsCommand;
import com.bookstore.products_keywordsservice.command.command.UpdateProductsKeywordsCommand;
import com.bookstore.products_keywordsservice.command.model.ProductsKeywordsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productsKeywords")
public class ProductsKeywordsCommandController {


    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ProductsKeywordsRequestModel model) {
        CreateProductsKeywordsCommand command = new CreateProductsKeywordsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProductsKeywordsRequestModel model) {
        UpdateProductsKeywordsCommand command = new UpdateProductsKeywordsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{productsKeywordsId}")
    public String deleteBook(@PathVariable String productsKeywordsId) {
        DeleteProductsKeywordsCommand command = new DeleteProductsKeywordsCommand(productsKeywordsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
