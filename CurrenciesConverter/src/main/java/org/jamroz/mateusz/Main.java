package org.jamroz.mateusz;

import org.jamroz.mateusz.context.CurrencyContext;
import org.jamroz.mateusz.context.repository.CurrencyRepository;
import org.jamroz.mateusz.helper.CurrencyParser;
import org.jamroz.mateusz.init.CurrencyDataReader;
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

public class Main {
    private static final String FILENAME = "staff.xml";

    public static void main(String[] args) {
        createProgramRunner().run();
    }

    private static ProgramRunner createProgramRunner() {
        return new CurrencyProgramRunner(
                CurrencyContext.init(
                        new CurrencyRepository(
                                (new CurrencyDataReader(new CurrencyParser())).readFrom(FILENAME)
                        )),
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
    }
}
