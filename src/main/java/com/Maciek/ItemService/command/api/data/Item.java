package com.Maciek.ItemService.command.api.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {

    @Id
    private String itemId;
    private String name;

}
