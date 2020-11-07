package com.stepan.todoistback.business.service.impl;

import com.stepan.todoistback.BaseTest;
import com.stepan.todoistback.business.dao.ProjectRepository;
import com.stepan.todoistback.business.dao.TaskRepository;
import com.stepan.todoistback.business.service.ProjectService;
import com.stepan.todoistback.utils.mappers.ProjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ProjectServiceImplTest extends BaseTest {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectMapper projectMapper;

    @MockBean
    ProjectRepository projectRepository;

    @MockBean
    TaskRepository taskRepository;

    @Test
    public void createProject() {
    }

    @Test
    public void deleteProject() {
    }

    @Test
    public void updateProject() {
    }

    @Test
    public void getAllProject() {
    }
}