package com.bookstore.provinceservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProvinceCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private Date created_at;

    private Date updated_at;
}
