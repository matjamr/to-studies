package org.jamroz.mateusz.context;

import org.jamroz.mateusz.currency.ICurrency;

import java.util.Optional;
import java.util.Set;

public interface Repository {
    Set<ICurrency> getCollection();
    ICurrency findByName(String name);
    ICurrency findByCode(String code);
    Optional<ICurrency> addCurrency(ICurrency currency);
    Optional<ICurrency> removeCurrency(ICurrency currency);


    default String asString() {
        return "Empty Collection";
    }
}
