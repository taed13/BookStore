package com.bookstore.articlesservice.command.controller;

import com.bookstore.articlesservice.command.command.CreateArticlesCommand;
import com.bookstore.articlesservice.command.command.DeleteArticlesCommand;
import com.bookstore.articlesservice.command.command.UpdateArticlesCommand;
import com.bookstore.articlesservice.command.model.ArticlesRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticlesCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody ArticlesRequestModel model) {
        CreateArticlesCommand command = new CreateArticlesCommand();
        BeanUtils.copyProperties(model, command);
        command.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(command);
        return "Add";
    }

    @PutMapping
    public String updateBook(@RequestBody ArticlesRequestModel model) {
        UpdateArticlesCommand command = new UpdateArticlesCommand();
        BeanUtils.copyProperties(model, command);
        commandGateway.sendAndWait(command);
        return "Update";
    }

    @DeleteMapping("/{articlesId}")
    public String deleteBook(@PathVariable String articlesId) {
        DeleteArticlesCommand command = new DeleteArticlesCommand(articlesId);
        commandGateway.sendAndWait(command);
        return "Delete";
    }
}
