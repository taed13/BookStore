package com.bookstore.eventsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, String> {
}
