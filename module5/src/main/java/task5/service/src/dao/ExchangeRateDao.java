package dao;


import model.ExchangeRate;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateDao {
    private List<ExchangeRate> rates;

    public ExchangeRateDao() {
        this.rates = new ArrayList<>();
    }

    public List<ExchangeRate> getRates() {
        return rates;
    }

    public void setRates(List<ExchangeRate> rates) {
        this.rates = rates;
    }
}
