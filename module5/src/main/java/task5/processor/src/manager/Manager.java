package manager;

import dao.ExchangeRateDao;
import model.Account;
import model.Currency;
import model.ExchangeRate;
import service.AccountService;
import service.CurrencyService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager {

    private static AccountManager accountManager = new AccountManager();

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(2);



        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                init(1);
                Account account = accountManager.getAcc(1);
                Map<String, BigDecimal> converted = null;
                int toConvert = 100;
                for(Currency currency: account.getCurrencyValues()) {
                    converted = CurrencyManager.exchange(currency, new BigDecimal(toConvert));
                    System.out.println(account+ "; convert " + toConvert + " to currency: " + converted);
                }

            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                edit(1);
                Account account = accountManager.getAcc(1);
                Map<String, BigDecimal> converted = null;
                int toConvert = 200;
                for(Currency currency: account.getCurrencyValues()) {
                    converted = CurrencyManager.exchange(currency, new BigDecimal(toConvert));
                    System.out.println(account+ "; convert " + toConvert + " to currency: " + converted);
                }

            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                init(3);

                Account account = accountManager.getAcc(3);
                Map<String, BigDecimal> converted = null;
                int toConvert = 700;
                for(Currency currency: account.getCurrencyValues()) {
                    converted = CurrencyManager.exchange(currency, new BigDecimal(toConvert));
                    System.out.println(account+ "; convert " + toConvert + " to currency: " + converted);
                }

            }
        };

        executorService.execute(runnable1);
        executorService.execute(runnable2);
        executorService.execute(runnable3);

    }

    private static void init(Integer id) {
        Map<String, BigDecimal> ratesToUSD = new HashMap<>();
        ratesToUSD.put("UAH", BigDecimal.valueOf(36.8));
        ratesToUSD.put("EUR", BigDecimal.valueOf(0.98));

        Map<String, BigDecimal> ratesToEUR = new HashMap<>();
        ratesToEUR.put("UAH", BigDecimal.valueOf(37.38));
        ratesToEUR.put("USD", BigDecimal.valueOf(1.02));

        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("USD", new ExchangeRate(ratesToUSD)));
        currencyList.add(new Currency("EUR", new ExchangeRate(ratesToEUR)));

        Account account = new Account(id, currencyList);

        accountManager.addAcc(account);
    }

    private static void edit(Integer id) {
        Map<String, BigDecimal> ratesToUSD = new HashMap<>();
        ratesToUSD.put("UAH", BigDecimal.valueOf(36.8));
        ratesToUSD.put("EUR", BigDecimal.valueOf(0.98));
        ratesToUSD.put("HRK", BigDecimal.valueOf(7.38));

        Map<String, BigDecimal> ratesToEUR = new HashMap<>();
        ratesToEUR.put("UAH", BigDecimal.valueOf(37.38));
        ratesToEUR.put("USD", BigDecimal.valueOf(1.02));

        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("USD", new ExchangeRate(ratesToUSD)));
        currencyList.add(new Currency("EUR", new ExchangeRate(ratesToEUR)));

        Account account = new Account(id, currencyList);

        accountManager.addAcc(account);
    }
}
