package com.example.flexcalc.solution2.utils;

public class CalculatorException extends RuntimeException {
    public CalculatorException(String errorMessage) {
        super(errorMessage);
    }

    public CalculatorException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
