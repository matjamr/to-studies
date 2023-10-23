package org.jamroz.mateusz.helper;

import org.jamroz.mateusz.currency.Currency;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.init.XmlEntity;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CurrencyParser implements Function<XmlEntity, Set<ICurrency>> {
    @Override
    public Set<ICurrency> apply(XmlEntity xmlEntity) {
        return Optional.ofNullable(xmlEntity)
                .map(XmlEntity::getCurrencyList)
                .stream()
                .flatMap(Collection::stream)
                .map(this::toCurrency)
                .map(ICurrency.class::cast)
                .collect(Collectors.toSet());
    }

    private Currency toCurrency(XmlEntity.Currency currency) {
        return new Currency(currency.getName(),
                currency.getCode(),
                currency.getRate(),
                currency.getFactorRate());
    }
}
