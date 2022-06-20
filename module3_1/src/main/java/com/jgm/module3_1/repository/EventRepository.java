package com.jgm.module3_1.repository;

import com.jgm.module3_1.entity.Event;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByTitle(String title, Pageable pageable);
    List<Event> findAllByDate(Date day, PageRequest of);
}
