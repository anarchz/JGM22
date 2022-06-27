package com.jgm.module6.facade;

import com.jgm.module6.entity.BookingMessage;
import com.jgm.module6.entity.Ticket;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

//Custom configuration without Spring Boot. Not used in a project

@Slf4j
public class JmsMessageSender {

    private JmsTemplate template;
    private Queue queue;

    public void sendMessage(BookingMessage booking) {
        log.info("Send ticket {} to the queue", booking);
        Map<String, Object> map = new HashMap<>();
        map.put("user", booking.getUser());
        map.put("event", booking.getEvent());
        map.put("place", booking.getPlace());
        map.put("category", booking.getCategory());
        template.convertAndSend("bookingQueue", map);
    }

    public void setConnectionFactory(ConnectionFactory cf) {
        this.template = new JmsTemplate(cf);
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }
}
