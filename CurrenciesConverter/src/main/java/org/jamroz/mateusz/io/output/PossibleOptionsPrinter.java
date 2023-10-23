package org.jamroz.mateusz.io.output;

import org.jamroz.mateusz.io.input.InputOptionsEnum;

import java.util.List;
import java.util.function.Consumer;

public class PossibleOptionsPrinter implements Consumer<List<InputOptionsEnum>> {

    @Override
    public void accept(List<InputOptionsEnum> inputOptionsEnums) {
        System.out.println("Please select one from below");
        inputOptionsEnums.forEach((option) -> {
            System.out.println("\t# " + option.getValue());
        });
    }

}
