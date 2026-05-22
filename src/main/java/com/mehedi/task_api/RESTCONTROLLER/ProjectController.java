package com.mehedi.task_api.RESTCONTROLLER;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehedi.task_api.service.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.stream.Collectors;

import com.mehedi.task_api.DTO.ProjectDTO;
import com.mehedi.task_api.mapper.ProjectMapper;
import com.mehedi.task_api.model.Project;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/projects")
@Tag(name = "Project API", description = "Endpoints for managing projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Get all projects", description = "Retrieve a list of all projects")
    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return projects.stream().map(project -> ProjectMapper.toProjectDTO(project)).collect(Collectors.toList());
    }

    @Operation(summary = "Create a new project", description = "Create a new project with the provided details")
    @PostMapping
    public ProjectDTO createProject(@RequestBody Project project) {
        Project savedProject = projectService.createProject(project);
        return ProjectMapper.toProjectDTO(savedProject);
    }
    
}
