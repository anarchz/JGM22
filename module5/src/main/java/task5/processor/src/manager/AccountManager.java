package manager;

import model.Account;
import service.AccountService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountManager {
    private Map<Integer,Account> accounts = new ConcurrentHashMap<>();
    private AccountService accountService = new AccountService();

    public AccountManager() {
    }

    public void addAcc(Account account) {
        accountService.createAccount(account);
        accounts.put(account.getId(), account);
    }

    public Account getAcc(Integer id) {
        return accountService.getAccount(id);
    }

    public Map<Integer,Account> getAll() {
        return accounts;
    }

}
