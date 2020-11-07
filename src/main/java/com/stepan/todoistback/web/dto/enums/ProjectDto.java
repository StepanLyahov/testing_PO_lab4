package com.stepan.todoistback.web.dto.enums;

import com.stepan.todoistback.web.dto.TaskDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProjectDto {
    Long id;
    String title;
    List<TaskDto> taskDtos;
}