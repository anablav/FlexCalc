package com.example.flexcalc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Operation {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private static final Map<Character, Operation> BY_SYMBOL = new HashMap<>();

    static {
        for (Operation op : Operation.values()) {
            BY_SYMBOL.put(op.symbol, op);
        }
    }

    private final char symbol;
    Operation(char symbol) {
        this.symbol = symbol;
    }

    public static Optional<Operation> getOperationBySymbol(char symbol) {
        return Optional.ofNullable(BY_SYMBOL.get(symbol));
    }

    public static String getSymbolByName(Operation op) {
        return String.valueOf(op.symbol);
    }
}
