package com.bookstore.shipping_promotionservice.command.controller;

import com.bookstore.shipping_promotionservice.command.command.CreateShippingPromotionCommand;
import com.bookstore.shipping_promotionservice.command.command.DeleteShippingPromotionCommand;
import com.bookstore.shipping_promotionservice.command.command.UpdateShippingPromotionCommand;
import com.bookstore.shipping_promotionservice.command.model.ShippingPromotionRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shippingPromotion")
public class ShippingPromotionCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ShippingPromotionRequestModel model) {
        CreateShippingPromotionCommand command = new CreateShippingPromotionCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ShippingPromotionRequestModel model) {
        UpdateShippingPromotionCommand command = new UpdateShippingPromotionCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{shippingPromotionId}")
    public String deleteBook(@PathVariable String shippingPromotionId) {
        DeleteShippingPromotionCommand command = new DeleteShippingPromotionCommand(shippingPromotionId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
