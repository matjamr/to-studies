package org.jamroz.mateusz.io.input;

import org.jamroz.mateusz.context.Context;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class SuccessfullInputHandler implements InputHandler {

    private final Map<InputOptionsEnum, Function<Context, ProcessingState>> actionMap;

    public SuccessfullInputHandler(Map<InputOptionsEnum, Function<Context, ProcessingState>> actionMap) {
        this.actionMap = actionMap;
    }

    @Override
    public ProcessingState handle(String input, Context context) {
        final InputOptionsEnum inputOption = InputOptionsEnum.valueOf(input);

        return Optional.ofNullable(actionMap.get(inputOption))
                .map(function -> function.apply(context))
                .orElse(ProcessingState.ABORT);
    }
}
