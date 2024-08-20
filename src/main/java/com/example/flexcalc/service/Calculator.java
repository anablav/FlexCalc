package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import com.example.flexcalc.utils.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class Calculator {
    Logger logger = LoggerFactory.getLogger(Calculator.class);

    @Autowired
    @Qualifier("calcOperationsMap")
    private Map<Operation, IOperation> calcOperationsMap;

    public Double calculate(Operation op, Double num1, Double num2) {
        try {
            logger.info("Operation requested is {}", op);
            logger.info("symbol is {}", op.getSymbolByName(op));
            logger.info("Operation is {}", op.getOperationBySymbol('+'));
            IOperation opBean = calcOperationsMap.get(op);
            return opBean.operate(num1, num2);
        } catch (CalculatorException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new CalculatorException(ex.getMessage(), ex);
        }
    }

    public Double calculateSeries(Double init, List<String> opSeries) {
        Double result = init;
        for (String op : opSeries) {
            String[] opArr = op.split(" ");
            char symbol = opArr[0].charAt(0);
            Optional<Operation> operationOpt = Operation.getOperationBySymbol(symbol);
            if (operationOpt.isEmpty()) {
                throw new CalculatorException(String.format("Operation %s not supported yet.", symbol));
            }
            Operation operation = operationOpt.get();
            result = calculate(operation, result, Double.valueOf(opArr[1]));
        }
        return result;
    }
}
