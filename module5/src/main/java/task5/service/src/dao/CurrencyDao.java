package dao;


import model.Currency;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    private List<Currency> currencyList = new ArrayList<>() ;

    public CurrencyDao() {
    }

    public void addCurrency(Currency currency) {
        currencyList.add(currency);
    }

    public Currency getCurrency(String name) {
        for (Currency currency : currencyList) {
            if(currency.getName().equals(name))
                return currency;
        }
        return null;
    }
}
