package org.jamroz.mateusz.currency;

public interface ICurrency {

    String getName();

    void setName(final String name);

    String getCode();

    void setCode(String name);

    Double getRate();

    void setRate(Double rate);

    Double getFactorRate();

    void setFactorRate(Double factorRate);
}
