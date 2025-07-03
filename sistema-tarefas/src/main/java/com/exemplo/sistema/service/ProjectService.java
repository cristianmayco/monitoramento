package com.exemplo.sistema.service;

import com.exemplo.sistema.model.Project;
import com.exemplo.sistema.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Optional<Project> findById(Long id) {
        return repository.findById(id);
    }

    public Project save(Project project) {
        return repository.save(project);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
