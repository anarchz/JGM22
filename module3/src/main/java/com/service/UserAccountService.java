package com.service;

import com.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    UserAccountRepository repository;

    public boolean refillAccount(double amount, long userId) {
        return repository.refillAcc(amount, userId);
    }

    public boolean returnMoney (double amount, long userId) {
        return repository.withdraw(amount, userId);
    }
}
