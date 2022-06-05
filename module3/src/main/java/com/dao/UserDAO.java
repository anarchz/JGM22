package com.dao;

import com.model.Ticket;
import com.model.User;
import com.model.UserAccount;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class UserDAO implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @OneToMany
    @JoinTable(name = "ticket", joinColumns = @JoinColumn(name = "userId"))
    private List<Ticket> tickets;
    @OneToOne
    @JoinTable(name = "user_account", joinColumns = @JoinColumn(name = "userId"))
    private UserAccount account;

    public UserDAO(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
