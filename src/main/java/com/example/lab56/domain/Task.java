package com.example.lab56.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor//(access = AccessLevel.PRIVATE, force = true)
@Document(collection="tasks")
public class Task {
    @Id
    private String id;

    private String header;

    private String description;

    private LocalDateTime date;

    @DBRef
    private User user;

    private States state;
}
