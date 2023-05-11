package com.bookstore.contactsservice.query.controller;

import com.bookstore.contactsservice.query.model.ContactsResponseModel;
import com.bookstore.contactsservice.query.queries.GetAllContactsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ContactsResponseModel> getAll() {
        GetAllContactsQuery getAllBookQuery = new GetAllContactsQuery();
        List<ContactsResponseModel> list = queryGateway.query(getAllBookQuery,
                ResponseTypes.multipleInstancesOf(ContactsResponseModel.class)).join();
        return list;
    }
}
