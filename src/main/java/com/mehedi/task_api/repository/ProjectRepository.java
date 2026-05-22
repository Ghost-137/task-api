package com.mehedi.task_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.mehedi.task_api.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByName(String name);
}
