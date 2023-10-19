package org.jamroz.mateusz.currency;

import java.util.Objects;

public class Currency implements ICurrency {

    private String name;
    private String code;
    private Double rate;
    private Double factorRate;

    public Currency(String name, String code, Double rate, Double factorRate) {
        this.name = name;
        this.code = code;
        this.rate = rate;
        this.factorRate = factorRate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Double getRate() {
        return rate;
    }

    @Override
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public Double getFactorRate() {
        return factorRate;
    }

    @Override
    public void setFactorRate(Double factorRate) {
        this.factorRate = factorRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (!Objects.equals(name, currency.name)) return false;
        if (!Objects.equals(code, currency.code)) return false;
        if (!Objects.equals(rate, currency.rate)) return false;
        return Objects.equals(factorRate, currency.factorRate);
    }

    @Override
    public int hashCode() {
        return (int) (name.hashCode() + code.hashCode() + rate + factorRate);
    }
}
