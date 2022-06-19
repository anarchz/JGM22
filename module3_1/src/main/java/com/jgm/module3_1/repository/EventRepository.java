package com.jgm.module3_1.repository;

import com.jgm.module3_1.entity.Event;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    List<Event> findAllByTitle(String title, Pageable pageable);
    List<Event> findAllByDate(Date day, PageRequest of);
}
