package com.example.api.model;

import javax.persistence.*;

@Entity
@Table(name = "ExchangeCurrency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "cc", nullable = false)
    private String cc;

    @Column(name = "txt", nullable = false)
    private String txt;

    @Column(name = "rate", nullable = false)
    private String rate;

    @Column(name = "r030", nullable = false)
    private String r030;

    @Column(name = "exchangeDate", nullable = false)
    private String exchangeDate;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getExchangedate() {
        return exchangeDate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangeDate = exchangedate;
    }

    @Override
    public String toString() {
        return "ClassPojo [cc = " + cc + ", txt = " + txt + ", rate = " + rate + ", r030 = " + r030 + ", exchangeDate = " + exchangeDate + "]";
    }
}
