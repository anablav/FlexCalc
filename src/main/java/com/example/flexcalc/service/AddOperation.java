package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddOperation implements IOperation {
    Logger logger = LoggerFactory.getLogger(AddOperation.class);
    @Override
    public Double operate(Double num1, Double num2) {
        logger.info("Operation: {}, Number1: {}, Number2: {}", getOperationName(), num1, num2);
        return num1 + num2;
    }

    @Override
    public Operation getOperationName() {
        return Operation.ADD;
    }
}
