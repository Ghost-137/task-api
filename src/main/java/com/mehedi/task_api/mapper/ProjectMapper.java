package com.mehedi.task_api.mapper;

import com.mehedi.task_api.DTO.ProjectDTO;
import com.mehedi.task_api.model.Project;

public class ProjectMapper {
    public static ProjectDTO toProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        return projectDTO;
    }

}
