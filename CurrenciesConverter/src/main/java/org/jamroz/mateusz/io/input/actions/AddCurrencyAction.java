package org.jamroz.mateusz.io.input.actions;

import com.sun.jdi.request.DuplicateRequestException;
import org.jamroz.mateusz.context.Context;
import org.jamroz.mateusz.currency.Currency;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.io.input.ProcessingState;

import java.util.Scanner;
import java.util.function.Function;

public class AddCurrencyAction implements Function<Context, ProcessingState> {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public ProcessingState apply(Context context) {

        System.out.println("Name: ");
        final String name = scanner.nextLine();

        System.out.println("Code: ");
        final String code = scanner.nextLine();

        System.out.println("Rate: ");
        final Double rate = Double.parseDouble(scanner.nextLine());

        System.out.println("Factor rate: ");
        final Double factorRate = Double.parseDouble(scanner.nextLine());

        final ICurrency currency = new Currency(name, code, rate, factorRate);

        if(context.getRepository().getCollection().contains(currency)) {
            throw new DuplicateRequestException("Element with code " + code + " already exists!");
        }

        context.getRepository().addCurrency(currency);

        return ProcessingState.CONTINUE;
    }

}
