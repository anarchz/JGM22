package com.jgm.module3_1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USER_TABLE")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "ticketUser")
    private List<Ticket> tickets;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private UserAccount account;

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
