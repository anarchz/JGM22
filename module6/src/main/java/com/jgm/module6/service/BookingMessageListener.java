package com.jgm.module6.service;

import com.jgm.module6.entity.BookingMessage;
import com.jgm.module6.entity.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Map;

@Component
@Slf4j
public class BookingMessageListener{

    @Autowired
    TicketService service;

    @JmsListener(destination = "bookingQueue", containerFactory = "bookingFactory")
    public void receiveMessage(BookingMessage message) {
        log.info("Received <" + message + ">");

        service.bookTicket(message.getUser(), message.getEvent(), message.getPlace(), message.getCategory());
    }


    //Configuration JMS without Spring Boot

//    @Autowired
//    TicketService ticketService;
//
//    public JmsTemplate getJmsTemplate() {
//        return getJmsTemplate();
//    }
//
//    @Override
//    public void onMessage(Message message) {
//        if (message instanceof TextMessage) {
//            try {
//                String msg = ((TextMessage) message).getText();
//                System.out.println("Message has been consumed : " + msg);
//            } catch (JMSException ex) {
//                throw new RuntimeException(ex);
//            }
//        } else {
//            throw new IllegalArgumentException("Message Error");
//        }
//    }
//
//    public Ticket receiveMessage() {
//        Map map = getJmsTemplate().receiveAndConvert();
//        return new Ticket();
//    }
}
