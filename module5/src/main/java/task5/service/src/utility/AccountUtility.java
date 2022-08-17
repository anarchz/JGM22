package utility;

import java.io.*;
import model.Account;
import java.util.logging.Logger;

public class AccountUtility {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void write(String fileName, Account account) {
        try(FileOutputStream fos = new FileOutputStream(new File(fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(account);
            LOGGER.info("Account "+ fileName +" was written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String fileName) {
        try {
            File file = new File(fileName);
            file.delete();
            LOGGER.info("Account "+ fileName +" was deleted");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Account "+ fileName +" was not deleted");
        }
    }

    public static Account read(String fileName) {
        try(FileInputStream fos = new FileInputStream(new File(fileName));
            ObjectInputStream oos = new ObjectInputStream(fos)) {
            LOGGER.info("Account "+ fileName +" was returned");
            return (Account) oos.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
