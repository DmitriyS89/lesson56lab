package com.example.lab56.services;

import com.example.lab56.domain.States;
import com.example.lab56.domain.Task;
import com.example.lab56.domain.User;

import com.example.lab56.dtos.TaskDTO;
import com.example.lab56.repository.TaskRepository;
import com.example.lab56.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Page<Task> getTaskListByUser(User user, Pageable pageable) {
        return taskRepository.getByUser(user, pageable);
    }



    public void createTaskByUser(User user, Task task) {

        var newTask = Task.builder()
                .header(task.getHeader())
                .description(task.getDescription())
                .date(task.getDate())
                .state(States.NEW)
                .user(user)
                .build();

        taskRepository.save(newTask);
    }

    public Task getTaskById(String id) {
        return taskRepository.findTaskById(id);
    }
}
