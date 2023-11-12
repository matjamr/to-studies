package org.jamroz.mateusz.io;

import org.jamroz.mateusz.context.Context;
import org.jamroz.mateusz.io.input.InputHandler;
import org.jamroz.mateusz.io.input.InputOptionsEnum;
import org.jamroz.mateusz.io.input.ProcessingState;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class CurrencyProgramRunner implements ProgramRunner {

    private final Context context;
    private final Consumer<List<InputOptionsEnum>> possibleOptionsPrinter;
    private final InputHandler successInputHandler;
    private final InputHandler failureInputHandler;
    private final List<String> possibleOptions;
    private static final Scanner scanner = new Scanner(System.in);

    public CurrencyProgramRunner(Context context, Consumer<List<InputOptionsEnum>> possibleOptionsPrinter, InputHandler successInputHandler, InputHandler failureInputHandler) {
        this.context = context;
        this.possibleOptionsPrinter = possibleOptionsPrinter;
        this.successInputHandler = successInputHandler;
        this.failureInputHandler = failureInputHandler;

        possibleOptions = Arrays.stream(InputOptionsEnum.values()).map(InputOptionsEnum::getValue).toList();
    }

    @Override
    public void run() {
        ProcessingState processingState;
        do {
            possibleOptionsPrinter.accept(Arrays.asList(InputOptionsEnum.values()));
            processingState = getInput();
        } while (processingState != ProcessingState.ABORT);
    }

    private ProcessingState getInput() {
        final String selectedOption = scanner.nextLine().toUpperCase();

        if(possibleOptions.contains(selectedOption)) {
            return successInputHandler.handle(selectedOption, context);
        }

        return failureInputHandler.handle(selectedOption, context);
    }

}
