package org.jamroz.mateusz;

import org.jamroz.mateusz.context.Context;
import org.jamroz.mateusz.context.CurrencyContext;
import org.jamroz.mateusz.context.repository.DataRepository;
import org.jamroz.mateusz.context.repository.Repository;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.helper.ICurrencyParser;
import org.jamroz.mateusz.init.CurrencyDataReader;
import org.jamroz.mateusz.init.DataReader;
import org.jamroz.mateusz.io.CurrencyProgramRunner;
import org.jamroz.mateusz.io.ProgramRunner;
import org.jamroz.mateusz.io.input.FailureInputHandler;
import org.jamroz.mateusz.io.input.InputOptionsEnum;
import org.jamroz.mateusz.io.input.ProcessingState;
import org.jamroz.mateusz.io.input.SuccessfullInputHandler;
import org.jamroz.mateusz.io.input.actions.ExchangeCurrencyAction;
import org.jamroz.mateusz.io.input.actions.IsShortenedNamePredicate;
import org.jamroz.mateusz.io.output.PossibleOptionsPrinter;

import java.util.Map;
import java.util.Set;

public class Main {
    private static final String FILENAME = "staff.xml";

    public static void main(String[] args) {
        DataReader<Set<ICurrency>, String> currencyDataReader = new CurrencyDataReader(new ICurrencyParser());
        Set<ICurrency> ret = currencyDataReader.readFrom(FILENAME);

        Repository repository = new DataRepository(ret);
        Context context = CurrencyContext.init(repository);

        ProgramRunner programRunner = new CurrencyProgramRunner(context,
                new PossibleOptionsPrinter(),
                new SuccessfullInputHandler(
                        Map.of(
                                InputOptionsEnum.ADD, (opt) -> ProcessingState.CONTINUE,
                                InputOptionsEnum.REMOVE, (opt) -> ProcessingState.CONTINUE,
                                InputOptionsEnum.CONVERT, new ExchangeCurrencyAction(new IsShortenedNamePredicate()),
                                InputOptionsEnum.QUIT, (opt) -> ProcessingState.ABORT
                                )
                ),
                new FailureInputHandler()
        );

        programRunner.run(context);
    }
}
