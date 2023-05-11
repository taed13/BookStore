package com.bookstore.provinceservice.command.controller;

import com.bookstore.provinceservice.command.command.CreateProvinceCommand;
import com.bookstore.provinceservice.command.command.DeleteProvinceCommand;
import com.bookstore.provinceservice.command.command.UpdateProvinceCommand;
import com.bookstore.provinceservice.command.model.ProvinceRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/province")
public class ProvinceCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ProvinceRequestModel model) {
        CreateProvinceCommand command = new CreateProvinceCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ProvinceRequestModel model) {
        UpdateProvinceCommand command = new UpdateProvinceCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{provinceId}")
    public String deleteBook(@PathVariable String provinceId) {
        DeleteProvinceCommand command = new DeleteProvinceCommand(provinceId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
