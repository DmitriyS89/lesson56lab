package com.example.lab56.controllers;

import com.example.lab56.domain.Task;
import com.example.lab56.domain.User;
import com.example.lab56.dtos.TaskDTO;
import com.example.lab56.repository.TaskRepository;
import com.example.lab56.services.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public Page<TaskDTO> getTaskList(Authentication authentication, @ApiIgnore Pageable pageable){
        User user = (User) authentication.getPrincipal();

        Page<Task> taskPage = taskService.getTaskListByUser(user, pageable);
        int totalElements = (int) taskPage.getTotalElements();
        Page<TaskDTO> pageTaskDTO = new PageImpl<TaskDTO>(
                taskPage.stream().map(task -> TaskDTO.builder()
                        .id(task.getId())
                        .date(task.getDate())
                        .header(task.getHeader())
                        .state(task.getState())
                        .build())
                .collect(Collectors.toList()), pageable, totalElements);

        return pageTaskDTO;
    }
}
