package com.bookstore.products_promotionsservice.command.controller;

import com.bookstore.products_promotionsservice.command.command.CreateProductsPromotionsCommand;
import com.bookstore.products_promotionsservice.command.command.DeleteProductsPromotionsCommand;
import com.bookstore.products_promotionsservice.command.command.UpdateProductsPromotionsCommand;
import com.bookstore.products_promotionsservice.command.model.ProductsPromotionsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productsPromotions")
public class ProductsPromotionsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ProductsPromotionsRequestModel model) {
        CreateProductsPromotionsCommand command = new CreateProductsPromotionsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProductsPromotionsRequestModel model) {
        UpdateProductsPromotionsCommand command = new UpdateProductsPromotionsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{productsPromotionsId}")
    public String deleteBook(@PathVariable String productsPromotionsId) {
        DeleteProductsPromotionsCommand command = new DeleteProductsPromotionsCommand(productsPromotionsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
