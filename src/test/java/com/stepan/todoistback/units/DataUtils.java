package com.stepan.todoistback.units;

import com.stepan.todoistback.web.dto.TaskDto;
import com.stepan.todoistback.web.dto.enums.ProjectDto;
import com.stepan.todoistback.web.dto.enums.StatusTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataUtils {

    TaskDto taskDto;
    ProjectDto projectDto;
    List<TaskDto> list = new ArrayList<>();


    public DataUtils() {
        generateTaskDto();
        generateProjectDto();
        generateListTaskDto();
    }

    private void generateTaskDto() {
        taskDto = TaskDto.builder()
                .description("des")
                .id((long) 1)
                .projectId((long) 1)
                .status(StatusTask.IN_PROGRESS)
                .title("Title")
                .build();
    }

    private void generateProjectDto() {
        projectDto = ProjectDto.builder()
                .id((long) 1)
                .title("Title")
                .taskDtos(Collections.singletonList(getTaskDtoExample()))
                .build();
    }

    private void generateListTaskDto() {
        list.add(taskDto);
        list.add(taskDto);
        list.add(taskDto);
    }

    public TaskDto getTaskDtoExample() {
        return taskDto;
    }


    public ProjectDto getProjectDtoExample() {
        return projectDto;
    }

    public List<TaskDto> getListTaskDto() {
        return list;
    }
}
