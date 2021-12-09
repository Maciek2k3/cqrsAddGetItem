package com.Maciek.ItemService.command.api.controller;

import com.Maciek.ItemService.command.api.commands.CreateItemCommand;
import com.Maciek.ItemService.command.api.model.ItemRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemCommandController {

    private CommandGateway commandGateway;

    public ItemCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @PostMapping
    public String addItem(@RequestBody ItemRestModel itemRestModel) {
        CreateItemCommand createItemCommand = CreateItemCommand.builder()
                .itemId(UUID.randomUUID().toString())
                .name(itemRestModel.getName())
                .build();
        String result = commandGateway.sendAndWait(createItemCommand);
        return result;


    }
}
