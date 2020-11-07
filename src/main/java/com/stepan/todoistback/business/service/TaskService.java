package com.stepan.todoistback.business.service;

import com.stepan.todoistback.web.dto.TaskDto;

import java.util.List;

public interface TaskService {

    void deleteTask(Long id);

    void createTask(TaskDto taskDto);

    void updateTask(TaskDto taskDto);

    List<TaskDto> getAllTask(Long projectId);
}
