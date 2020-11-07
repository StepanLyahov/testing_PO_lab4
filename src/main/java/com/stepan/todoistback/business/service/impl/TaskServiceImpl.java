package com.stepan.todoistback.business.service.impl;

import com.stepan.todoistback.business.service.TaskService;
import com.stepan.todoistback.web.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public void createTask(TaskDto taskDto) {

    }

    @Override
    public void updateTask(TaskDto taskDto) {

    }

    @Override
    public List<TaskDto> getAllTask(Long projectId) {
        return null;
    }
}
