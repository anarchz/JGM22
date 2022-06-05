package com.dao;

import com.model.UserAccount;
import jakarta.persistence.*;

@Entity
@Table(name = "user_account")
public class UserAccountDAO implements UserAccount {
    @Column(name = "money_amount")
    private double moneyAmount;
    @Column(name = "userId")
    @OneToOne
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "userId"))
    private long userId;

    public UserAccountDAO(double moneyAmount, long userId) {
        this.moneyAmount = moneyAmount;
        this.userId = userId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
