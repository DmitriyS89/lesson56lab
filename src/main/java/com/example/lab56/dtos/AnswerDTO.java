package com.example.lab56.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    private String userId;
    private String message;
}
