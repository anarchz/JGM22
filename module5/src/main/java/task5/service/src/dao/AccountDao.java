package dao;


import exception.AccountException;
import model.Account;
import utility.AccountUtility;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountDao {
    private static AtomicInteger accountCount = new AtomicInteger(1);

    public AccountDao() {
    }

    public synchronized Account getAccount(Integer id) throws AccountException {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", id);
        return AccountUtility.read(fileName);
    }

    public synchronized void createAccount(Account account) throws AccountException {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", account.getId());
        AccountUtility.write(fileName, account);
        accountCount.getAndAdd(1);
    }

    public synchronized void updateAccount(Account account) throws AccountException {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", account.getId());
        AccountUtility.write(fileName, account);
    }

    public synchronized void deleteAccount(Integer id) throws AccountException {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", id);
        AccountUtility.delete(fileName);
    }

    public int getAccountCount() {
        return accountCount.get();
    }
}
