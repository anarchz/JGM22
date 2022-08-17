package service;


import dao.AccountDao;
import exception.AccountException;
import model.Account;

public class AccountService {
    private AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public synchronized void createAccount(Account account) throws AccountException {
        account.setId(accountDao.getAccountCount());
        accountDao.createAccount(account);
    }

    public synchronized void deleteAccount(Integer id) throws AccountException {
        accountDao.deleteAccount(id);
    }

    public synchronized Account getAccount(Integer id) throws AccountException {
        return accountDao.getAccount(id);
    }

    public synchronized void updateAccount(Account account) throws AccountException {
        accountDao.updateAccount(account);
    }
}
