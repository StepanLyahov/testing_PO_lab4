package com.stepan.todoistback.web.api.v1;

import com.stepan.todoistback.business.service.TaskService;
import com.stepan.todoistback.web.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stepan.todoistback.web.ApiConstantUtil.TASK;

@RestController
@RequiredArgsConstructor
@RequestMapping(TASK)
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/createTask")
    public void createTask(@RequestBody TaskDto taskDto) {
        taskService.createTask(taskDto);
    }

    @PostMapping("/updateTask")
    public void updateTask(@RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto);
    }

    @GetMapping("/getAllTask")
    public List<TaskDto> getAllTask(@RequestParam(required = false) Long projectId) {
        return taskService.getAllTask(projectId);
    }
}
