package service;


import dao.AccountDao;
import model.Account;

public class AccountService {
    private AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public void createAccount(Account account) {
        account.setId(accountDao.getAccountCount());
        accountDao.createAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public Account getAccount(Integer id) {
        return accountDao.getAccount(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
