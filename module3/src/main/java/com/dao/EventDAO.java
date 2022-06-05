package com.dao;

import java.util.Date;
import java.util.List;

import com.model.Event;
import com.model.Ticket;
import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class EventDAO implements Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private Date date;
    @OneToMany
    @JoinTable(name = "ticket", joinColumns = @JoinColumn(name = "eventId"))
    private List<Ticket> tickets;
    @Column(name = "price")
    private double ticketPrice;

    public EventDAO(long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
