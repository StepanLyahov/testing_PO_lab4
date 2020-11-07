package com.stepan.todoistback.utils.mappers;

import com.stepan.todoistback.business.entity.ProjectEntity;
import com.stepan.todoistback.business.entity.TaskEntity;
import com.stepan.todoistback.web.dto.TaskDto;
import com.stepan.todoistback.web.dto.enums.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ProjectMapper {

    @Mapping(target = "taskDtos", expression = "java(setTasks(entity.getTasks(), entity))")
    ProjectDto toDto(ProjectEntity entity);

    default List<TaskDto> setTasks(List<TaskEntity> res, ProjectEntity projectEntity) {

        List<TaskDto> resList = new ArrayList<>();
        for (TaskEntity entity : res) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(entity.getId());
            taskDto.setTitle(entity.getTitle());
            taskDto.setStatus(entity.getStatus());
            taskDto.setDescription(entity.getDescription());
            taskDto.setProjectId(projectEntity.getId());

            resList.add(taskDto);
        }

        return resList;
    }

    ProjectEntity toEntity(ProjectDto dto);
}
