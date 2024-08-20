package com.example.flexcalc.model;

import java.util.Arrays;
import java.util.Optional;

public enum Operation {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;
    Operation(char symbol) {
        this.symbol = symbol;
    }

    public Optional<Operation> getOperationBySymbol(char symbol) {
        Operation[] operations = Operation.values();
        return Arrays.stream(operations).filter(op -> op.symbol == symbol).findFirst();
     }

    public String getSymbolByName(Operation op) {
        return String.valueOf(op.symbol);
    }
}
