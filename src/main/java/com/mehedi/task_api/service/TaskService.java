package com.mehedi.task_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehedi.task_api.model.Task;
import com.mehedi.task_api.repository.ProjectRepository;
import com.mehedi.task_api.repository.TaskRepository;

@Service
public class TaskService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public TaskService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public List<Task> getTasksByProjectId(long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Task CreateTask(Task task, Long projectId) {
        var currentProject = projectRepository.findById(projectId).orElseThrow();
        task.setProject(currentProject);
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long taskId, String newStatus) {
        var currentTask = taskRepository.findById(taskId).orElseThrow();

        currentTask.setStatus(newStatus);
        return taskRepository.save(currentTask);
    }
}
