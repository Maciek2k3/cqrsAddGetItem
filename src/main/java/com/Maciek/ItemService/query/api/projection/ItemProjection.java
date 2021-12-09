package com.Maciek.ItemService.query.api.projection;

import com.Maciek.ItemService.command.api.data.Item;
import com.Maciek.ItemService.command.api.data.ItemRepo;
import com.Maciek.ItemService.command.api.model.ItemRestModel;
import com.Maciek.ItemService.query.api.queries.GetItemsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemProjection {
    private ItemRepo itemRepo;

    public ItemProjection(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }
    @QueryHandler
    public List<ItemRestModel> handle (GetItemsQuery getItemsQuery){
        List<Item> itemsList=itemRepo.findAll();
        List<ItemRestModel> itemRestModels=itemsList.stream()
                .map(item -> ItemRestModel
                .builder()
                .name(item.getName())
                        .build())
                .collect(Collectors.toList());
        return itemRestModels;
    }
}
