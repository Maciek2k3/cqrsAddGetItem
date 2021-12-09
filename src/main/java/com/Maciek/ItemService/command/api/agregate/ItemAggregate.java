package com.Maciek.ItemService.command.api.agregate;

import com.Maciek.ItemService.command.api.commands.CreateItemCommand;
import com.Maciek.ItemService.command.api.events.ItemCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;


@Aggregate
public class ItemAggregate {
    @AggregateIdentifier
    private String itemId;
    private String name;

    @CommandHandler
    public ItemAggregate(CreateItemCommand createItemCommand) {
        ItemCreatedEvent itemCreatedEvent = new ItemCreatedEvent();
        BeanUtils.copyProperties(createItemCommand,itemCreatedEvent);
        AggregateLifecycle.apply(itemCreatedEvent);


    }

    public ItemAggregate() {
    }

    @EventSourcingHandler
    public void on(ItemCreatedEvent itemCreatedEvent) {
        this.itemId = itemCreatedEvent.getItemId();
        this.name = itemCreatedEvent.getName();


    }
}
