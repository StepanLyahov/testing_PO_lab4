package com.stepan.todoistback.business.service.impl;

import com.stepan.todoistback.BaseTest;
import com.stepan.todoistback.business.dao.ProjectRepository;
import com.stepan.todoistback.business.dao.TaskRepository;
import com.stepan.todoistback.business.service.ProjectService;
import com.stepan.todoistback.units.DataUtils;
import com.stepan.todoistback.utils.mappers.ProjectMapper;
import com.stepan.todoistback.web.dto.enums.ProjectDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectServiceImplTest extends BaseTest {

    DataUtils dataUtils = new DataUtils();

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectMapper projectMapper;

    @MockBean
    ProjectRepository projectRepository;

    @MockBean
    TaskRepository taskRepository;

    @Test(expected = Exception.class)
    public void createProject() {
        projectService.createProject(dataUtils.getProjectDtoExample());

        projectService.createProject(null);
    }

    @Test
    public void deleteProject() {
        projectService.deleteProject(null);

        projectService.deleteProject((long) 1);
    }

    @Test(expected = Exception.class)
    public void updateProject() {
        projectService.updateProject(dataUtils.getProjectDtoExample());

        projectService.updateProject(null);
    }

    @Test
    public void getAllProject() {
        Mockito.when(projectRepository.findAll()).thenReturn(Collections.singletonList(dataUtils.getProjectEntityExample()));

        List<ProjectDto> res = projectService.getAllProject();

        ProjectDto projectDto = dataUtils.getProjectDtoExample();
        projectDto.setTaskDtos(new ArrayList<>());
        List<ProjectDto> test_res = Collections.singletonList(projectDto);

        Assert.assertEquals(res, test_res);
    }
}