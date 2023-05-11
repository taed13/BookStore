package com.bookservice.password_resetsservice.command.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePasswordResetsCommand {

    @TargetAggregateIdentifier
    private String id;
}
