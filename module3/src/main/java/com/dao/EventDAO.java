package com.dao;

import java.util.Date;

import com.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

public class EventDAO implements Event {
    private long id;
    private String title;
    private Date date;

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
}
