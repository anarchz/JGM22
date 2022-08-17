package utility;

import java.io.*;

import exception.AccountException;
import model.Account;
import java.util.logging.Logger;

public class AccountUtility {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void write(String fileName, Account account) throws AccountException {
        try(FileOutputStream fos = new FileOutputStream(new File(fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(account);
            LOGGER.info("Account "+ fileName +" was written");
        } catch (IOException e) {
            throw new AccountException("Account was not write, cause: ", e.getCause());
        }
    }

    public static void delete(String fileName) throws AccountException {
        try {
            File file = new File(fileName);
            file.delete();
            LOGGER.info("Account "+ fileName +" was deleted");
        } catch (Exception e) {
            throw new AccountException("Account was not deleted, cause: ", e.getCause());
        }
    }

    public static Account read(String fileName) throws AccountException {
        try(FileInputStream fos = new FileInputStream(new File(fileName));
            ObjectInputStream oos = new ObjectInputStream(fos)) {
            LOGGER.info("Account "+ fileName +" was returned");
            return (Account) oos.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new AccountException("Account was not read, cause: ", e.getCause());
        }
    }
}
