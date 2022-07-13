package com.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer id;
    private String title;
    private Integer place;
    private String speaker;
    private String eventType;
    private LocalDateTime dateTime;
}
