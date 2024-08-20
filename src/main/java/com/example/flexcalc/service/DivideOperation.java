package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import com.example.flexcalc.utils.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements IOperation{

    Logger logger = LoggerFactory.getLogger(DivideOperation.class);
    @Override
    public Double operate(Double num1, Double num2) {
        logger.info("Operation: {}, Number1: {}, Number2: {}", getOperationName(), num1, num2);
        if (num2 == 0) {
            throw new CalculatorException("Division by Zero Error.");
        }
        return num1 / num2;
    }

    @Override
    public Operation getOperationName() {
        return Operation.DIVIDE;
    }
}
