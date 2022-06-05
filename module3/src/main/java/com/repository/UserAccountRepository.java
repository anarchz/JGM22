package com.repository;

import com.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    @Query(value = "SELECT u.money_amount+?1 FROM user_account AS u WHERE u.userId=?2", nativeQuery = true)
    boolean refillAcc(double amount, long userId);

    @Query(value = "SELECT u.money_amount-?1 FROM user_account AS u WHERE u.userId=?2", nativeQuery = true)
    boolean withdraw(double amount, long userId);
}
