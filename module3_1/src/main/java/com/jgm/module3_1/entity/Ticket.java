package com.jgm.module3_1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TICKET")
public class Ticket{

    public enum Category {STANDARD, PREMIUM, BAR}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated (value = EnumType.STRING)
    private Category category;
    private int place;
    @ManyToOne
    @JoinColumn(name = "id",nullable = false, insertable = false, updatable = false)
    private Event event;
    @ManyToOne
    @JoinColumn(name = "id",nullable = false, insertable = false, updatable = false)
    private User ticketUser;

    public Ticket(User ticketUser, Event event, int place, Category category) {
        this.category = category;
        this.place = place;
        this.event = event;
        this.ticketUser = ticketUser;
    }
}
