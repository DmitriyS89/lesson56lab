package com.example.lab56.repository;

import com.example.lab56.domain.Task;
import com.example.lab56.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {
    Page<Task> getByUser(User user, Pageable pageable);

}
