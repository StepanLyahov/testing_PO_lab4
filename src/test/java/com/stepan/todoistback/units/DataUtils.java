package com.stepan.todoistback.units;

import com.stepan.todoistback.business.entity.ProjectEntity;
import com.stepan.todoistback.business.entity.TaskEntity;
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
                .title("Title")
                .status(StatusTask.IN_PROGRESS)
                .id((long) 1)
                .description("desc")
                .projectId((long) 1)
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

    public List<TaskEntity> getListTaskEntity() {
        List<TaskEntity> list = new ArrayList<>();

        ProjectEntity projectEntity = ProjectEntity.builder()
                .title("Title")
                .id((long) 1)
                .tasks(null)
                .build();

        TaskEntity taskEntity = TaskEntity.builder()
                .title("Title")
                .status(StatusTask.IN_PROGRESS)
                .id((long) 1)
                .description("desc")
                .projectId(projectEntity)
                .build();

        projectEntity.setTasks(Collections.singletonList(taskEntity));

        list.add(taskEntity);

        return list;
    }

    public ProjectEntity getProjectEntityExample() {
        ProjectEntity projectEntity = ProjectEntity.builder()
                .title("Title")
                .id((long) 1)
                .tasks(new ArrayList<>())
                .build();

        return projectEntity;
    }

}
