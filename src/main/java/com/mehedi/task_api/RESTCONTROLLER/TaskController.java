package com.mehedi.task_api.RESTCONTROLLER;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehedi.task_api.DTO.TaskDTO;
import com.mehedi.task_api.mapper.TaskMapper;
import com.mehedi.task_api.model.Task;
import com.mehedi.task_api.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/project/{projectId}")
    public List<TaskDTO> getTaskByProject(@PathVariable Long projectId) {
        List<Task> taks = taskService.getTasksByProjectId(projectId);
        return taks.stream().map(task -> TaskMapper.toTaskDTO(task)).collect(Collectors.toList());
    }

    @PostMapping("/project/{projectId}")
    public TaskDTO createTask(@PathVariable Long projectId, @RequestBody Task task) {
       

        Task savedTask = taskService.CreateTask(task, projectId);
        return TaskMapper.toTaskDTO(savedTask);

    }

    @PutMapping("/{taskId}/status")
    public TaskDTO updateTaskStatus(@PathVariable Long taskId, @RequestParam String newStatus) {
        
        Task updatedRawTask = taskService.updateTaskStatus(taskId, newStatus);
        return TaskMapper.toTaskDTO(updatedRawTask);
    }
    
    
    
}
