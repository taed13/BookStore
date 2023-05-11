package com.bookstore.adminsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, String> {
}
