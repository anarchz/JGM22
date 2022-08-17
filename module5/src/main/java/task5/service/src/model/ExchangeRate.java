package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRate implements Serializable {
//    private String currencyName;
//    private Double rate;
//
//    public ExchangeRate(String currencyName, Double rate) {
//        this.currencyName = currencyName;
//        this.rate = rate;
//    }
//
//    public String getCurrencyName() {
//        return currencyName;
//    }
//
//    public void setCurrencyName(String currencyName) {
//        this.currencyName = currencyName;
//    }
//
//    public Double getRate() {
//        return rate;
//    }
//
//    public void setRate(Double rate) {
//        this.rate = rate;
//    }



    private Map<String, BigDecimal> rates;

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
