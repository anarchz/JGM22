package manager;

import exception.CurrencyException;
import model.Currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManager {
    public static synchronized Map<String, BigDecimal> exchange(Currency currencyName, BigDecimal amount) throws CurrencyException {
        Map<String, BigDecimal> converted = new HashMap<>();

        if(amount.compareTo(BigDecimal.ZERO) > 0) {
            Map<String, BigDecimal> rates = currencyName.getRate().getRates();


            for (Map.Entry<String, BigDecimal> entry : rates.entrySet()) {
                BigDecimal d = entry.getValue().multiply(amount);
                converted.put(entry.getKey(), d);
            }
        } else {
            throw new CurrencyException("The value is negative or 0");
        }
        return converted;
    }
}
