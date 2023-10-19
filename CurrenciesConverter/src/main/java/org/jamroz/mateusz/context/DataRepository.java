package org.jamroz.mateusz.context;

import org.jamroz.mateusz.currency.ICurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public ICurrency findByName(String name) {
        return currenciesSet.stream()
                .filter(currency -> currency.getName().equals(name))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("No currency with given name"));
    }

    @Override
    public ICurrency findByCode(String code) {
        return null;
    }

    @Override
    public Optional<ICurrency> addCurrency(ICurrency currency) {
        return Optional.empty();
    }

    @Override
    public Optional<ICurrency> removeCurrency(ICurrency currency) {
        return Optional.empty();
    }

    @Override
    public String asString() {
        return Repository.super.asString();
    }
}
