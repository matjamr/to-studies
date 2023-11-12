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
        System.out.println("From:");
        String from = scanner.nextLine().toUpperCase();
        ICurrency currencyFrom = getCurrency(context, from);

        System.out.println("Amount:");
        double fromAmount  = Double.parseDouble(scanner.nextLine());


        System.out.println("To:");
        String to = scanner.nextLine().toUpperCase();
        ICurrency currencyTo = getCurrency(context, to);

        double estimatedValue = currencyFrom.getFactorRate() / currencyTo.getFactorRate() * fromAmount;

        System.out.printf("Estimated value FROM [%s %.2f] TO [%s %.2f]%n", currencyFrom.getCode(), fromAmount, currencyTo.getCode(),estimatedValue);

        return ProcessingState.CONTINUE;
    }

    private ICurrency getCurrency(Context context, String curr) {
        return Optional.of(curr)
                .filter(isShortenedNamePredicate)
                .map(val -> context.getRepository().findByCode(val))
                .orElse(context.getRepository().findByName(curr))
                .orElseThrow(() -> new NoSuchElementException("There is no such currency for " + curr));
    }
}
