package com.repository;

import com.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    Event findById(long id);
    List<Event> findAllByDate(Date date);
    List<Event> findAllByTitle(String title);
}
