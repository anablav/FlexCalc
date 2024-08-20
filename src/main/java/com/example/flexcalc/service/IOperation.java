package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import org.springframework.stereotype.Component;

@Component
public interface IOperation {
    Double operate(Double num1, Double num2);

    Operation getOperationName();
}
