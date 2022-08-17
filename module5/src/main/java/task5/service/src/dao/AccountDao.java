package dao;


import model.Account;
import model.Currency;
import utility.AccountUtility;

import java.util.List;

public class AccountDao {
    private static volatile int accountCount = 1;

    public AccountDao() {
    }

    public Account getAccount(Integer id) {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", id);
        return AccountUtility.read(fileName);
    }

    public synchronized void createAccount(Account account) {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", account.getId());
        AccountUtility.write(fileName, account);
        accountCount++;
    }

    public synchronized void updateAccount(Account account) {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", account.getId());
        AccountUtility.write(fileName, account);
    }

    public synchronized void deleteAccount(Integer id) {
        String fileName = String.format("module5/src/main/resources/task5/acc%s.txt", id);
        AccountUtility.delete(fileName);
    }

    public int getAccountCount() {
        return accountCount;
    }
}
