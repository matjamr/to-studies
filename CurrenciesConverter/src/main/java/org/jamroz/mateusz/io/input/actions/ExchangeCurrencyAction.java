package org.jamroz.mateusz.io.input.actions;

import org.jamroz.mateusz.context.Context;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.io.input.ProcessingState;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExchangeCurrencyAction implements Function<Context, ProcessingState> {

    private static final Scanner scanner = new Scanner(System.in);
    private final Predicate<String> isShortenedNamePredicate;

    public ExchangeCurrencyAction(Predicate<String> isShortenedNamePredicate) {
        this.isShortenedNamePredicate = isShortenedNamePredicate;
    }

    @Override
    public ProcessingState apply(Context context) {
        System.out.println("pln:");
        String pln = scanner.nextLine();

        System.out.println("To:");
        String to = scanner.nextLine();

//        ICurrency currencyFrom = Optional.of(from)
//                .filter(isShortenedNamePredicate)
//                .map(val -> context.getRepository().findByCode(val))
//                .orElse(context.getRepository().findByName(from))
//                .orElseThrow(() -> new NoSuchElementException("There is no such currency"));

        ICurrency currencyTo = Optional.of(to)
                .filter(isShortenedNamePredicate)
                .map(val -> context.getRepository().findByCode(val))
                .orElse(context.getRepository().findByName(to))
                .orElseThrow(() -> new NoSuchElementException("There is no such currency"));

        System.out.println("Your value will be: " + Integer.parseInt(pln) / currencyTo.getFactorRate() * currencyTo.getRate());

        return ProcessingState.CONTINUE;
    }
}
