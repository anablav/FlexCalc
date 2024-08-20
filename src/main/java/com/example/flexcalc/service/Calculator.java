package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Calculator {
    Logger logger = LoggerFactory.getLogger(Calculator.class);
    @Autowired
    @Qualifier("calcOperationsMap")
    private Map<Operation, IOperation> calcOperationsMap;

    public double calculate(Operation op, Double num1, Double num2) {
        logger.info("Operation requested is {}", op);
        logger.info("symbol is {}", op.getSymbolByName(op));
        logger.info("Operation is {}", op.getOperationBySymbol('+'));
        IOperation opBean = calcOperationsMap.get(op);
        return opBean.operate(num1, num2);
    }
}
