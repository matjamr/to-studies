package org.jamroz.mateusz.io.input;

import org.jamroz.mateusz.context.Context;

public class FailureInputHandler implements InputHandler {

    @Override
    public ProcessingState handle(String input, Context context) {
        System.out.println("Invalid option '" + input + "' selected, ending program execution...");
        return ProcessingState.ABORT;
    }
}
