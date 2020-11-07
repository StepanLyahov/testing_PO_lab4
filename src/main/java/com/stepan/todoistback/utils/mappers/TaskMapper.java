package com.stepan.todoistback.utils.mappers;

import com.stepan.todoistback.business.entity.ProjectEntity;
import com.stepan.todoistback.business.entity.TaskEntity;
import com.stepan.todoistback.web.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskMapper {

    @Mapping(target = "projectId", expression = "java(setProject(entity.getProjectId()))")
    TaskDto toDto(TaskEntity entity);

    default Long setProject(ProjectEntity projectEntity) {
        return projectEntity.getId();
    }

    @Mapping(target = "projectId", ignore = true)
    TaskEntity toEntity(TaskDto dto);
}
