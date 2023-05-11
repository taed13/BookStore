package com.bookstore.bill_promotionservice.command.controller;

import com.bookstore.bill_promotionservice.command.command.CreateBillPromotionCommand;
import com.bookstore.bill_promotionservice.command.command.DeleteBillPromotionCommand;
import com.bookstore.bill_promotionservice.command.command.UpdateBillPromotionCommand;
import com.bookstore.bill_promotionservice.command.model.BillPromotionRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/billPromotion")
public class BillPromotionCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody BillPromotionRequestModel model) {
        CreateBillPromotionCommand command = new CreateBillPromotionCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody BillPromotionRequestModel model) {
        UpdateBillPromotionCommand command = new UpdateBillPromotionCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{billPromotionId}")
    public String deleteBook(@PathVariable String billPromotionId) {
        DeleteBillPromotionCommand command = new DeleteBillPromotionCommand(billPromotionId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
