package com.bookservice.password_resetsservice.command.controller;

import com.bookservice.password_resetsservice.command.command.CreatePasswordResetsCommand;
import com.bookservice.password_resetsservice.command.command.DeletePasswordResetsCommand;
import com.bookservice.password_resetsservice.command.command.UpdatePasswordResetsCommand;
import com.bookservice.password_resetsservice.command.model.PasswordResetsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/passwordResets")
public class PasswordResetsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody PasswordResetsRequestModel model) {
        CreatePasswordResetsCommand command = new CreatePasswordResetsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody PasswordResetsRequestModel model) {
        UpdatePasswordResetsCommand command = new UpdatePasswordResetsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{passwordResetsId}")
    public String deleteBook(@PathVariable String passwordResetsId) {
        DeletePasswordResetsCommand command = new DeletePasswordResetsCommand(passwordResetsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
