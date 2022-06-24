package com.jgm.module6.service;

import com.jgm.module6.entity.User;
import com.jgm.module6.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class UserAccountService {
    @Autowired
    UserAccountRepository repository;

    @Transactional
    public boolean refillAccount(double amount, User user) {
        log.info("account refilled" + user.getId());
        return repository.refillAcc(amount, user.getId());
    }

    @Transactional
    public boolean returnMoney (double amount, User user) {
        log.info("withdraw" + user.getId());
        return repository.withdraw(amount, user.getId());
    }
}
