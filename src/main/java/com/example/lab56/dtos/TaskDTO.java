package com.example.lab56.dtos;

import com.example.lab56.domain.States;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO {
    private String id;
    private String header;
    private LocalDateTime date;
    private States state;
}
