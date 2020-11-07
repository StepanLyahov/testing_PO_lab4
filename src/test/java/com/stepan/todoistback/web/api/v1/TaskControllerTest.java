package com.stepan.todoistback.web.api.v1;

import com.stepan.todoistback.business.service.TaskService;
import com.stepan.todoistback.web.dto.TaskDto;
import com.stepan.todoistback.web.dto.enums.StatusTask;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static com.stepan.todoistback.web.ApiConstantUtil.TASK;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TaskControllerTest extends ApiTest {

    @MockBean
    TaskService taskService;

    TaskDto taskDto;
    List<TaskDto> taskDtos;

    @Before
    public void initDate() {
        taskDto = TaskDto.builder()
                .description("des")
                .id((long) 1)
                .projectId((long) 1)
                .status(StatusTask.IN_PROGRESS)
                .title("Title")
                .build();


        taskDtos = new ArrayList<>();
        taskDtos.add(taskDto);
        taskDtos.add(taskDto);
    }


    @Test
    @SneakyThrows
    public void deleteTask() {
        String response = mvc.perform(get(TASK + "/deleteTask/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(response, "");
    }

    @Test
    @SneakyThrows
    public void createTask() {
        mvc.perform(post(TASK + "/createTask")
                .content(objectMapper.writeValueAsString(taskDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @SneakyThrows
    public void updateTask() {
        mvc.perform(post(TASK + "/updateTask")
                .content(objectMapper.writeValueAsString(taskDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @SneakyThrows
    public void getAllTask() {
        when(taskService.getAllTask(any())).thenReturn(taskDtos);

        String expectedJson = objectMapper.writeValueAsString(taskDtos);

        mvc.perform(get(TASK + "/getAllTask").param("projectId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(expectedJson));

        verify(taskService, times(1)).getAllTask(any());
    }
}