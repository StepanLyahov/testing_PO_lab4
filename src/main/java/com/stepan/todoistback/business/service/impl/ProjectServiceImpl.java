package com.stepan.todoistback.business.service.impl;

import com.stepan.todoistback.business.dao.ProjectRepository;
import com.stepan.todoistback.business.dao.TaskRepository;
import com.stepan.todoistback.business.entity.TaskEntity;
import com.stepan.todoistback.business.service.ProjectService;
import com.stepan.todoistback.utils.mappers.ProjectMapper;
import com.stepan.todoistback.web.dto.enums.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void createProject(ProjectDto projectDto) {
        if (projectDto == null) {
            log.info("project is void");
            return;
        }
        log.info("create new project : " + projectDto.getTitle());
        projectRepository.save(projectMapper.toEntity(projectDto));
    }

    @Override
    public void deleteProject(Long id) {
        log.info("del project by id : " + id);

        List<TaskEntity> tasks = taskRepository.findAll();
        tasks.forEach(t -> {
            if (t.getProjectId().getId().equals(id))
                taskRepository.deleteById(t.getId());
        });

        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        if (projectDto == null || projectDto.getId() == null) {
            log.info("project is void");
            return;
        }
        log.info("update project: " + projectDto.getId());
        projectRepository.save(projectMapper.toEntity(projectDto));
    }

    @Override
    public List<ProjectDto> getAllProject() {
        log.info("get all project");
        return projectRepository.findAll()
                .stream().map(projectMapper::toDto)
                .collect(Collectors.toList());
    }
}
