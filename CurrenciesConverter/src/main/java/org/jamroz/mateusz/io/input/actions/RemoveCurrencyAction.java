package org.jamroz.mateusz.io.input.actions;

import com.sun.jdi.request.DuplicateRequestException;
import org.jamroz.mateusz.context.Context;
import org.jamroz.mateusz.currency.Currency;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.io.input.ProcessingState;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

public class RemoveCurrencyAction implements Function<Context, ProcessingState> {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public ProcessingState apply(Context context) {
        System.out.println("Code: ");
        final String code = scanner.nextLine();

        context.getRepository().findByCode(code)
                .ifPresentOrElse((currency) -> context.getRepository().removeCurrency(currency), () -> {
                    throw new NoSuchElementException("No such currency " + code);
                });

        return ProcessingState.CONTINUE;
    }

}
