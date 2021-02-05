package com.example.lab56.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class UserDTO {

    private String name;

    private String email;

    private String password;
}

