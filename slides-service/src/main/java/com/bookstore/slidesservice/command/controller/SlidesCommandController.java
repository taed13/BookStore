package com.bookstore.slidesservice.command.controller;

import com.bookstore.slidesservice.command.command.CreateSlidesCommand;
import com.bookstore.slidesservice.command.command.DeleteSlidesCommand;
import com.bookstore.slidesservice.command.command.UpdateSlidesCommand;
import com.bookstore.slidesservice.command.model.SlidesRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/slides")
public class SlidesCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody SlidesRequestModel model) {
        CreateSlidesCommand command = new CreateSlidesCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody SlidesRequestModel model) {
        UpdateSlidesCommand command = new UpdateSlidesCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{slidesId}")
    public String deleteBook(@PathVariable String slidesId) {
        DeleteSlidesCommand command = new DeleteSlidesCommand(slidesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
