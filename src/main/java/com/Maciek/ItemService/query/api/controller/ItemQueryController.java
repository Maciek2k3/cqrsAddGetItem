package com.Maciek.ItemService.query.api.controller;

import com.Maciek.ItemService.command.api.model.ItemRestModel;
import com.Maciek.ItemService.query.api.queries.GetItemsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemQueryController {

    public ItemQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    private QueryGateway queryGateway;

    @GetMapping
    public List<ItemRestModel> getAllItems() {
        GetItemsQuery getItemsQuery = new GetItemsQuery();

        List<ItemRestModel> itemRestModels= queryGateway.query(getItemsQuery,
                ResponseTypes.multipleInstancesOf(ItemRestModel.class))
                .join();

        return itemRestModels;
    }
}
