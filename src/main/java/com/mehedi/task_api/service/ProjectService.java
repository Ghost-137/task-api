package com.mehedi.task_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehedi.task_api.model.Project;
import com.mehedi.task_api.repository.ProjectRepository;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject (Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public Project getProjectById (Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

}
