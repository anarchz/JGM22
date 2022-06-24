package com.jgm.module6.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @DateTimeFormat
    @Column(name ="event_date")
    private Date date;
    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;
    private double ticketPrice;

    public Event(long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Event(long id, String title, Date date, double ticketPrice) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }
}
