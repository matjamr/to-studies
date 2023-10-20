package org.jamroz.mateusz.init;

public interface DataReader<T, F> {
    T readFrom(F source);
}
