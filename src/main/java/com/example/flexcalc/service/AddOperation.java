package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class AddOperation implements IOperation{

    @Override
    public Double operate(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    public Operation getOperationName() {
        return Operation.ADD;
    }
}
