package com.example.lab56.controllers;

import com.example.lab56.domain.User;
import com.example.lab56.dtos.AnswerDTO;
import com.example.lab56.dtos.UserDTO;
import com.example.lab56.repository.UserRepository;
import com.example.lab56.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<AnswerDTO> addUser(@RequestBody UserDTO userDTO) {
        if(!userRepository.existsByEmail(userDTO.getEmail())){
            User user = userService.addUser(userDTO);

            return ResponseEntity.status(201).body(AnswerDTO.builder()
                    .userId(user.getId())
                    .message("Пользователь успешно создан")
                    .build());
        } else {
            return ResponseEntity.badRequest().body(AnswerDTO.builder()
                    .message("Пользователь с таким email уже существует")
                    .build());
        }
    }

}
