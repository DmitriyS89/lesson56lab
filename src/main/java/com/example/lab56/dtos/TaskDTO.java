package com.example.lab56.dtos;

import com.example.lab56.domain.States;
import com.example.lab56.domain.Task;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO {

    public static TaskDTO from(Task task) {
        return builder()
                .id(task.getId())
                .header(task.getHeader())
                .date(task.getDate())
                .state(task.getState())
                .build();
    }
    private String id;
    private String header;
    private LocalDateTime date;
    private States state;
}
