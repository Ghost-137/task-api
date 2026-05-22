package com.mehedi.task_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mehedi.task_api.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
    List<Task> findByProjectId(Long projectId);
}

