package com.Maciek.ItemService.newItemTest;
import com.Maciek.ItemService.command.api.commands.CreateItemCommand;
import com.Maciek.ItemService.command.api.data.Item;
import com.Maciek.ItemService.command.api.events.ItemCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.jupiter.api.Test;



public class AddNewItemTest{

    private FixtureConfiguration<Item> fixture;


    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(Item.class);
    }
    @Test
    public void testFirstFixture() {

    }
}

