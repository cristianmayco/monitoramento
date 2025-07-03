package com.exemplo.sistema.repository;

import com.exemplo.sistema.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
