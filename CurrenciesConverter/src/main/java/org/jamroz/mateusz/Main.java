package org.jamroz.mateusz;

import org.jamroz.mateusz.context.Context;
import org.jamroz.mateusz.context.CurrencyContext;
import org.jamroz.mateusz.context.repository.CurrencyRepository;
import org.jamroz.mateusz.context.repository.Repository;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.helper.CurrencyParser;
import org.jamroz.mateusz.init.CurrencyDataReader;
import org.jamroz.mateusz.init.DataReader;
import org.jamroz.mateusz.init.XmlEntity;
import org.jamroz.mateusz.io.CurrencyProgramRunner;
import org.jamroz.mateusz.io.ProgramRunner;
import org.jamroz.mateusz.io.input.*;
import org.jamroz.mateusz.io.input.actions.ExchangeCurrencyAction;
import org.jamroz.mateusz.io.input.actions.IsShortenedNamePredicate;
import org.jamroz.mateusz.io.output.PossibleOptionsPrinter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final String FILENAME = "staff.xml";
    private static Function<XmlEntity, Set<ICurrency>> currencyParser;
    private static DataReader<Set<ICurrency>, String> dataReader;
    private static Repository currencyRepository;
    private static Context context;
    private static Consumer<List<InputOptionsEnum>> possibleOptionsPrinter;
    private static InputHandler successfullInputHandler;
    private static InputHandler failureInputHandler;
    private static ProgramRunner programRunner;
    private static Function<Context, ProcessingState> exchangeCurrencyAction;
    private static Predicate<String> isShortenedNamePredicate;



    public static void main(String[] args) {
        programRunner = createProgramRunner();
        programRunner.run();
    }

    private static ProgramRunner createProgramRunner() {
        currencyParser = new CurrencyParser();
        dataReader = new CurrencyDataReader(currencyParser);
        currencyRepository = new CurrencyRepository(dataReader.readFrom(FILENAME));
        context = CurrencyContext.init(currencyRepository);
        possibleOptionsPrinter = new PossibleOptionsPrinter();
        possibleOptionsPrinter = new PossibleOptionsPrinter();
        isShortenedNamePredicate = new IsShortenedNamePredicate();
        exchangeCurrencyAction = new ExchangeCurrencyAction(isShortenedNamePredicate);
        successfullInputHandler = new SuccessfullInputHandler(Map.of(
                InputOptionsEnum.ADD, (opt) -> ProcessingState.CONTINUE,
                InputOptionsEnum.REMOVE, (opt) -> ProcessingState.CONTINUE,
                InputOptionsEnum.CONVERT, exchangeCurrencyAction,
                InputOptionsEnum.QUIT, (opt) -> ProcessingState.ABORT
        ));
        failureInputHandler = new FailureInputHandler();

        return new CurrencyProgramRunner(
                context,
                possibleOptionsPrinter,
                successfullInputHandler,
                failureInputHandler
        );
    }
}
