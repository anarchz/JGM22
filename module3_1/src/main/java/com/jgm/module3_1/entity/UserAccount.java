package com.jgm.module3_1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USER_ACCOUNT")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double moneyAmount;
    @OneToOne (mappedBy = "account")
    private User user;

}
