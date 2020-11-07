package com.stepan.todoistback.business.service.impl;

import com.stepan.todoistback.BaseTest;
import com.stepan.todoistback.business.dao.ProjectRepository;
import com.stepan.todoistback.business.dao.TaskRepository;
import com.stepan.todoistback.business.service.TaskService;
import com.stepan.todoistback.utils.mappers.TaskMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

public class TaskServiceImplTest extends BaseTest {

    @Autowired
    TaskService taskService;

    @MockBean
    TaskRepository taskRepository;

    @MockBean
    ProjectRepository projectRepository;

    @Test
    public void deleteTask() {

    }

    @Test
    public void createTask() {

    }

    @Test
    public void updateTask() {

    }

    @Test
    public void getAllTask() {

    }
}