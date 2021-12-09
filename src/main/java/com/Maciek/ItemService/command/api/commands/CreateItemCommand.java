package com.Maciek.ItemService.command.api.commands;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemCommand {
    
    @TargetAggregateIdentifier
    private String itemId;
    private String name;

}
