package org.jamroz.mateusz.io.input;

import org.jamroz.mateusz.context.Context;

public interface InputHandler {
    ProcessingState handle(String input, Context context);
}
