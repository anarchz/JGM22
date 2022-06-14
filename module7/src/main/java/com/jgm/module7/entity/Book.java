package com.jgm.module7.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String author;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    public Book(String name, String author, Date publishDate,double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }
}
