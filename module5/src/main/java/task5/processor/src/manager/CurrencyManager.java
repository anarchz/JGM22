package manager;

import model.Currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManager {
    public static synchronized Map<String, BigDecimal> exchange(Currency currencyName, BigDecimal amount) {
        Map<String, BigDecimal> rates = currencyName.getRate().getRates();
        Map<String, BigDecimal> converted = new HashMap<>();

        for(Map.Entry<String, BigDecimal> entry : rates.entrySet()) {
            BigDecimal d = entry.getValue().multiply(amount);
            converted.put(entry.getKey(), d);
        }
        return converted;
    }
}
