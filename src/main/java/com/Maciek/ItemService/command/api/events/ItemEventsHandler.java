package com.Maciek.ItemService.command.api.events;

import com.Maciek.ItemService.command.api.data.Item;
import com.Maciek.ItemService.command.api.data.ItemRepo;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
@ProcessingGroup("item")
public class ItemEventsHandler {


    private ItemRepo itemRepo;

    public ItemEventsHandler(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @EventHandler
    public void on(ItemCreatedEvent event) throws Exception {
        Item item = new Item();
        BeanUtils.copyProperties(event, item);
        itemRepo.save(item);
        throw new Exception("Exception Occurred");
    }
    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
