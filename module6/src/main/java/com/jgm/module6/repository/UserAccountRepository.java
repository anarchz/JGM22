package com.jgm.module6.repository;

import com.jgm.module6.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    @Query(value = "SELECT u.money_amount+?1 FROM user_account AS u WHERE u.userId=?2", nativeQuery = true)
    boolean refillAcc(double amount, long userId);

    @Query(value = "SELECT u.money_amount-?1 FROM user_account AS u WHERE u.userId=?2", nativeQuery = true)
    boolean withdraw(double amount, long userId);
}
