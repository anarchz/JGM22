package model;

import java.io.Serializable;

public class Currency implements Serializable {
    private String name;
    private ExchangeRate rate;

    public Currency() {}
    public Currency(String name, ExchangeRate rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExchangeRate getRate() {
        return rate;
    }

    public void setRate(ExchangeRate rate) {
        this.rate = rate;
    }
}
