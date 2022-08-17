package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRate implements Serializable {
    private Map<String, BigDecimal> rates;

    public ExchangeRate() {}
    public ExchangeRate(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
