package com.exemplo.sistema.repository;

import com.exemplo.sistema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
