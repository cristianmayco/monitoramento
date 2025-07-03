package com.exemplo.sistema.repository;

import com.exemplo.sistema.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
