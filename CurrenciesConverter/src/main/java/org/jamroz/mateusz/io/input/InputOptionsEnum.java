package org.jamroz.mateusz.io.input;

public enum InputOptionsEnum {
    ADD("ADD"),
    REMOVE("REMOVE"),
    CONVERT("CONVERT"),
    QUIT("QUIT");

    private final String value;

    InputOptionsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
