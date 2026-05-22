package com.mehedi.task_api.mapper;

import com.mehedi.task_api.DTO.TaskDTO;
import com.mehedi.task_api.model.Task;

public class TaskMapper {
    public static TaskDTO toTaskDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setProjectId(task.getProject().getId());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setTitle(task.getTitle());

        return taskDTO;

    }
}
