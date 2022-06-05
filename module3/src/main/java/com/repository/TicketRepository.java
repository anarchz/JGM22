package com.repository;

import com.model.Event;
import com.model.Ticket;
import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findAllByUser(User user);
    List<Ticket> findAllByEvent(Event event);
}
