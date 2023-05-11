package com.bookstore.contactsservice.command.controller;

import com.bookstore.contactsservice.command.command.CreateContactsCommand;
import com.bookstore.contactsservice.command.command.DeleteContactsCommand;
import com.bookstore.contactsservice.command.command.UpdateContactsCommand;
import com.bookstore.contactsservice.command.model.ContactsRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addAdmin(@RequestBody ContactsRequestModel model) {
        CreateContactsCommand command = new CreateContactsCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ContactsRequestModel model) {
        UpdateContactsCommand command = new UpdateContactsCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{contactsId}")
    public String deleteBook(@PathVariable String contactsId) {
        DeleteContactsCommand command = new DeleteContactsCommand(contactsId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
