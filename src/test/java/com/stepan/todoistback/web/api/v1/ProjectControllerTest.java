package com.stepan.todoistback.web.api.v1;

import com.stepan.todoistback.business.service.ProjectService;
import com.stepan.todoistback.web.dto.TaskDto;
import com.stepan.todoistback.web.dto.enums.ProjectDto;
import com.stepan.todoistback.web.dto.enums.StatusTask;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.Collections;

import static com.stepan.todoistback.web.ApiConstantUtil.PROJECT;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProjectControllerTest extends ApiTest {

    @MockBean
    ProjectService projectService;

    ProjectDto projectDto;

    @Before
    public void init() {
        TaskDto taskDto = TaskDto.builder()
                .description("des")
                .id((long) 1)
                .projectId((long) 1)
                .status(StatusTask.IN_PROGRESS)
                .title("Title")
                .build();


        projectDto = ProjectDto.builder()
                .id((long) 1)
                .title("Title")
                .taskDtos(Collections.singletonList(taskDto))
                .build();
    }

    @Test
    @SneakyThrows
    public void createProject() {
        mvc.perform(post(PROJECT + "/createProject")
                .content(objectMapper.writeValueAsString(projectDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @SneakyThrows
    public void deleteProject() {
        String response = mvc.perform(get(PROJECT + "/deleteProject/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(response, "");
    }

    @Test
    @SneakyThrows
    public void updateProject() {
        mvc.perform(post(PROJECT + "/updateProject")
                .content(objectMapper.writeValueAsString(projectDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @SneakyThrows
    public void getAllProject() {
        when(projectService.getAllProject()).thenReturn(Collections.singletonList(projectDto));

        String expectedJson = objectMapper.writeValueAsString(Collections.singletonList(projectDto));

        mvc.perform(get(PROJECT + "/getAllProject"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(expectedJson));

        verify(projectService, times(1)).getAllProject();
    }
}