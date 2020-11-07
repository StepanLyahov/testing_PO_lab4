package com.stepan.todoistback.web.api.v1;

import com.stepan.todoistback.business.service.TaskService;
import com.stepan.todoistback.units.DataUtils;
import com.stepan.todoistback.web.dto.TaskDto;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

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

    DataUtils dataUtils = new DataUtils();

    @MockBean
    TaskService taskService;

    TaskDto taskDto = dataUtils.getTaskDtoExample();
    List<TaskDto> taskDtos = dataUtils.getListTaskDto();

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