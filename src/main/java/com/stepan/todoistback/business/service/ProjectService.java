package com.stepan.todoistback.business.service;

import com.stepan.todoistback.web.dto.enums.ProjectDto;

import java.util.List;

public interface ProjectService {

    void createProject(ProjectDto projectDto);

    void deleteProject(Long id);

    void updateProject(ProjectDto projectDto);

    List<ProjectDto> getAllProject();
}
