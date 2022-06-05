package com.dao;

import com.model.Ticket;
import jakarta.persistence.*;
@Entity
@Table(name = "ticket")
public class TicketDAO implements Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "category")
    @Enumerated (value = EnumType.STRING)
    private Category category;
    @Column(name = "place")
    private int place;
    @Column(name = "eventId")
    @ManyToOne
    @JoinColumn(name = "id",nullable = false, insertable = false, updatable = false)
    private long eventId;
    @Column(name = "userId")
    @ManyToOne
    @JoinColumn(name = "id",nullable = false, insertable = false, updatable = false)
    private long userId;

    public TicketDAO(long id, Category category, int place, long eventId, long userId) {
        this.id = id;
        this.category = category;
        this.place = place;
        this.eventId = eventId;
        this.userId = userId;
    }

    public TicketDAO(long userId, long eventId, int place, Category category) {
        this.category = category;
        this.place = place;
        this.eventId = eventId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
