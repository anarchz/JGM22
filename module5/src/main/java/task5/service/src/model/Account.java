package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Account implements Serializable {
    private Integer id;
    private List<Currency> currencyValues;
    private static final long serialVersionUID = 123L;

    public Account() {
    }

    public Account(Integer id, List<Currency> currencyValues) {
        this.id = id;
        this.currencyValues = currencyValues;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Currency> getCurrencyValues() {
        return currencyValues;
    }

    public void setCurrencyValues(List<Currency> currencyValues) {
        this.currencyValues = currencyValues;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }
}
