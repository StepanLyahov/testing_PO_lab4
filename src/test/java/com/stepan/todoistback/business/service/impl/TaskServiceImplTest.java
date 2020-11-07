package com.stepan.todoistback.business.service.impl;

import com.stepan.todoistback.BaseTest;
import com.stepan.todoistback.business.dao.ProjectRepository;
import com.stepan.todoistback.business.dao.TaskRepository;
import com.stepan.todoistback.business.service.TaskService;
import com.stepan.todoistback.units.DataUtils;
import com.stepan.todoistback.utils.mappers.TaskMapper;
import com.stepan.todoistback.web.dto.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

public class TaskServiceImplTest extends BaseTest {

    DataUtils dataUtils = new DataUtils();

    @Autowired
    TaskService taskService;

    @Autowired
    TaskMapper taskMapper;

    @MockBean
    TaskRepository taskRepository;

    @MockBean
    ProjectRepository projectRepository;

    @Test
    public void deleteTask() {
        taskService.deleteTask(null);

        taskService.deleteTask((long) 1);
    }

    @Test(expected = Exception.class)
    public void createTask() {
        taskService.createTask(dataUtils.getTaskDtoExample());

        taskService.createTask(null);
    }

    @Test(expected = Exception.class)
    public void updateTask() {
        taskService.updateTask(dataUtils.getTaskDtoExample());

        taskService.updateTask(null);
    }

    @Test
    public void getAllTask() {
        Mockito.when(taskRepository.findAll()).thenReturn(dataUtils.getListTaskEntity());

        Long projectId = (long) 1;
        List<TaskDto> res = taskService.getAllTask(projectId);

        List<TaskDto> test_res = Collections.singletonList(dataUtils.getTaskDtoExample());

        Assert.assertEquals(res, test_res);
    }
}