package com.example.lab56.services;

import com.example.lab56.domain.Task;
import com.example.lab56.domain.User;
import com.example.lab56.dtos.TaskDTO;
import com.example.lab56.repository.TaskRepository;
import com.example.lab56.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
