package org.jamroz.mateusz.io.input.predicate;

import java.util.Optional;
import java.util.function.Predicate;

public class IsShortenedNamePredicate implements Predicate<String> {
    @Override
    public boolean test(String name) {
        return Optional.ofNullable(name)
                .filter(val -> val.length() <= 3)
                .isPresent();
    }
}
