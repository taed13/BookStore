package com.bookstore.contactsservice.query.projection;

import com.bookstore.contactsservice.command.data.Contacts;
import com.bookstore.contactsservice.command.data.ContactsRepository;
import com.bookstore.contactsservice.query.model.ContactsResponseModel;
import com.bookstore.contactsservice.query.queries.GetAllContactsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class ContactsProjection {

    @Autowired
    private ContactsRepository repository;

    @QueryHandler
    public List<ContactsResponseModel> getAllBook(GetAllContactsQuery getAll) {
        List<ContactsResponseModel> list = new ArrayList<>();
        List<Contacts> List = repository.findAll();
        List.forEach(book -> {
            ContactsResponseModel model = new ContactsResponseModel();
            BeanUtils.copyProperties(book, model);
            list.add(model);
        });
        return list;
    }
}
