package com.mehedi.task_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehedi.task_api.model.Project;
import com.mehedi.task_api.model.Task;
import com.mehedi.task_api.repository.ProjectRepository;
import com.mehedi.task_api.repository.TaskRepository;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
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

    public void deleteProject (Long id) {
        List <Task> tasks = taskRepository.findByProjectId(id);
        taskRepository.deleteAll(tasks);
        projectRepository.deleteById(id);
    }

}
