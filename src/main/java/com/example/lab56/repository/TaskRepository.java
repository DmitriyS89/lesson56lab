package com.example.lab56.repository;

import com.example.lab56.domain.Task;
import com.example.lab56.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, String> {
    Page<Task> getByUser(User user, Pageable pageable);
    Task findTaskById(String id);

}
