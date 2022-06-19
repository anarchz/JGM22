package com.jgm.module3_1.repository;

import com.jgm.module3_1.entity.Event;
import com.jgm.module3_1.entity.Ticket;
import com.jgm.module3_1.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
    List<Ticket> findAllByTicketUser(User user, PageRequest of);

    List<Ticket> findAllByEvent(Event event, PageRequest of);
}
