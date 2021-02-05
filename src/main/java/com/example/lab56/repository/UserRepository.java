package com.example.lab56.repository;

import com.example.lab56.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    public boolean existsByEmail(String email);
    Optional<User> getByEmail(String email);

}
