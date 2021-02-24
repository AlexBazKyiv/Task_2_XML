package com.example.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exchange")
public class Exchange {
    private Currency[] currency;

    public Currency[] getCurrency() {
        return currency;
    }

    public void setCurrency(Currency[] currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ClassPojo [currency = " + currency + "]";
    }
}
