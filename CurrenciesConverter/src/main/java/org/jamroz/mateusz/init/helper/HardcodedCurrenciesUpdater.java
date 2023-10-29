package org.jamroz.mateusz.init.helper;

import org.jamroz.mateusz.currency.Currency;
import org.jamroz.mateusz.currency.ICurrency;

import java.util.Set;
import java.util.function.Consumer;

public class HardcodedCurrenciesUpdater implements Consumer<Set<ICurrency>> {

    @Override
    public void accept(Set<ICurrency> iCurrencies) {
        iCurrencies.add(new Currency("polski zloty", "PLN", 1.0, 1.0));
    }
}
