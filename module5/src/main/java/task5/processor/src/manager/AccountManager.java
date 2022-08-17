package manager;

import exception.AccountException;
import model.Account;
import service.AccountService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class AccountManager {
    private Map<Integer,Account> accounts = new ConcurrentHashMap<>();
    private AccountService accountService = new AccountService();
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public AccountManager() {
    }

    public synchronized void addAcc(Account account) {
        try {
            accountService.createAccount(account);
            accounts.put(account.getId(), account);
        } catch (AccountException e) {
            LOGGER.throwing("AccountManager", "addAcc", e.getCause());
        }
    }

    public synchronized void editAcc(Account account) {
        try {
            accountService.updateAccount(account);
            accounts.put(account.getId(), account);
        } catch (AccountException e) {
            LOGGER.throwing("AccountManager", "editAcc", e.getCause());
        }
    }

    public Account getAcc(Integer id) {
        try {
            return accountService.getAccount(id);
        } catch (AccountException e) {
            LOGGER.throwing("AccountManager", "getAcc", e.getCause());
        }
        return null;
    }

    public Map<Integer,Account> getAll() {
        return accounts;
    }

}
