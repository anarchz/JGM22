package com.jgm.module6.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingMessage {
    User user;
    Event event;
    Integer place;
    Ticket.Category category;
}
