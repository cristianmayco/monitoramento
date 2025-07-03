package com.exemplo.sistema.controller;

import com.exemplo.sistema.model.Project;
import com.exemplo.sistema.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Project> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Project> create(@Validated @RequestBody Project project) {
        Project created = service.save(project);
        return ResponseEntity.created(URI.create("/api/projects/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @Validated @RequestBody Project project) {
        return service.findById(id)
                .map(existing -> {
                    project.setId(existing.getId());
                    return ResponseEntity.ok(service.save(project));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
