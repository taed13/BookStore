package com.bookservice.password_resetsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetsRepository extends JpaRepository<PasswordResets, String> {
}
