package com.stepan.todoistback.web.dto;

import com.stepan.todoistback.web.dto.enums.StatusTask;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    Long id;
    String title;
    String description;

    @Enumerated(EnumType.STRING)
    StatusTask status;

    Long projectId;
}
