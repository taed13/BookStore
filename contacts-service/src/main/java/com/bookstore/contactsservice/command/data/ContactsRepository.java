package com.bookstore.contactsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts, String> {
}
