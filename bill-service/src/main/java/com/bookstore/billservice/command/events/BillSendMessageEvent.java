package com.bookstore.billservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillSendMessageEvent {

    private String id;

    private Long user_id;

    private String message;
}
