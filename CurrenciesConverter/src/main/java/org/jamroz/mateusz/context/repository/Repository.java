package org.jamroz.mateusz.context.repository;

import org.jamroz.mateusz.currency.ICurrency;

import java.util.Optional;
import java.util.Set;

public interface Repository {
    Set<ICurrency> getCollection();
    Optional<ICurrency> findByName(String name);
    Optional<ICurrency> findByCode(String code);
    Optional<ICurrency> addCurrency(ICurrency currency);
    Optional<ICurrency> removeCurrency(ICurrency currency);


    default String asString() {
        return "Empty Collection";
    }
}
