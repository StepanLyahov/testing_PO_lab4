package com.stepan.todoistback.web.api.v1;

import com.stepan.todoistback.business.service.ProjectService;
import com.stepan.todoistback.web.dto.enums.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stepan.todoistback.web.ApiConstantUtil.PROJECT;

@RestController
@RequiredArgsConstructor
@RequestMapping(PROJECT)
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/createProject")
    public void createProject(@RequestBody ProjectDto projectDto) {
        projectService.createProject(projectDto);
    }

    @GetMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
    }

    @PostMapping("/updateProject")
    public void updateProject(@RequestBody ProjectDto projectDto) {
        projectService.updateProject(projectDto);
    }

    @GetMapping("/getAllProject")
    public List<ProjectDto> getAllProject() {
        return projectService.getAllProject();
    }
}
