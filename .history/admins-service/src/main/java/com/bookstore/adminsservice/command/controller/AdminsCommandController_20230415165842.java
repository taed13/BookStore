package com.bookstore.adminsservice.command.controller;


import com.bookstore.adminsservice.command.command.CreateAdminsCommand;
import com.bookstore.adminsservice.command.command.DeleteAdminsCommand;
import com.bookstore.adminsservice.command.command.UpdateAdminsCommand;
import com.bookstore.adminsservice.command.model.AdminsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminsCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody AdminsRequestModel adminRequestModel) {
        CreateAdminsCommand command = new CreateAdminsCommand();
        BeanUtils.copyProperties(adminRequestModel, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody AdminsRequestModel adminRequestModel) {
        UpdateAdminsCommand command = new UpdateAdminsCommand();
        BeanUtils.copyProperties(adminRequestModel, command);
        commandGateway.sendAndWait(command);
        return "Update Book";
    }

    @DeleteMapping("/{adminId}")
    public String deleteBook(@PathVariable String adminId) {
        DeleteAdminsCommand command = new DeleteAdminsCommand(adminId);
        commandGateway.sendAndWait(command);
        return "Delete Book";
    }
}
