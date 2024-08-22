package com.example.flexcalc.solution2.model;

import com.example.flexcalc.solution2.service.IOperation2;
import com.example.flexcalc.solution2.utils.CalculatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Operation {
    ADD('+', (x,y)->x+y),
    SUBTRACT('-', (x,y)->x-y),
    MULTIPLY('*', (x,y)->x*y),
    DIVIDE('/', (x,y) -> {
        if (y == 0)
            throw new CalculatorException("Division by Zero Error.");
        return x/y;
    });

    private static final Map<Character, Operation> BY_SYMBOL = new HashMap<>();

    static {
        for (Operation op : Operation.values()) {
            BY_SYMBOL.put(op.symbol, op);
        }
    }
    private final char symbol;
    private final IOperation2 opImpl;

    Operation(char symbol, IOperation2 opImpl) {
        this.symbol = symbol;
        this.opImpl = opImpl;
    }

    public static Optional<Operation> getOperationBySymbol(char symbol) {
        return Optional.ofNullable(BY_SYMBOL.get(symbol));
    }

    public static String getSymbolByName(Operation op) {
        return String.valueOf(op.symbol);
    }

    public static IOperation2 getLambdaByName(Operation op) {
        return op.opImpl;
    }
}
