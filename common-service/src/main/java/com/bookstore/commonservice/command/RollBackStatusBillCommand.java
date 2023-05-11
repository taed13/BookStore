package com.bookstore.commonservice.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RollBackStatusBillCommand {

    @TargetAggregateIdentifier
    private String id;

    private Long userId;

}
