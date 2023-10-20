package org.jamroz.mateusz.context.repository;

import org.jamroz.mateusz.currency.ICurrency;

import java.util.*;
import java.util.stream.Collectors;

public class DataRepository implements Repository {
    private final Set<ICurrency> currenciesSet;

    public DataRepository(Set<ICurrency> currenciesSet) {
        this.currenciesSet = currenciesSet;
    }

    @Override
    public Set<ICurrency> getCollection() {
        return new HashSet<>(currenciesSet);
    }

    @Override
    public Optional<ICurrency> findByName(String name) {
        return currenciesSet.stream()
                .filter(currency -> currency.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<ICurrency> findByCode(String code) {
        return currenciesSet.stream()
                .filter(currency -> currency.getCode().equals(code))
                .findFirst();
    }

    @Override
    public Optional<ICurrency> addCurrency(ICurrency currency) {
        return Optional.ofNullable(currency)
                .filter(currenciesSet::add);
    }

    @Override
    public Optional<ICurrency> removeCurrency(ICurrency currency) {
        return Optional.ofNullable(currency)
                .filter(currenciesSet::remove);
    }

    @Override
    public String asString() {
        return "[ " + currenciesSet.stream()
                .map(ICurrency::toString)
                .collect(Collectors.joining(" , ")) + " ]";
    }
}
