package com.example.flexcalc.service;

import com.example.flexcalc.model.Operation;
import com.example.flexcalc.utils.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class Calculator {
    Logger logger = LoggerFactory.getLogger(Calculator.class);
    @Autowired
    @Qualifier("calcOperationsMap")
    private Map<Operation, IOperation> calcOperationsMap;

    //This was added just to make the unit test work
    public Calculator() {
        calcOperationsMap = new HashMap<>();
        calcOperationsMap.put(Operation.ADD, new AddOperation());
        calcOperationsMap.put(Operation.SUBTRACT, new SubtractOperation());
        calcOperationsMap.put(Operation.MULTIPLY, new MultiplyOperation());
        calcOperationsMap.put(Operation.DIVIDE, new DivideOperation());
    }

    public Double calculate(Operation op, Double num1, Double num2) {
        try {
            logger.info("Operation requested is {}", op);
            IOperation opBean = calcOperationsMap.get(op);
            return opBean.operate(num1, num2);
        } catch (CalculatorException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new CalculatorException(ex.getMessage(), ex);
        }
    }
    public Double calculateSeries(Double init, List<String> opSeries) {
        logger.info("Starting Number is {}. Operation Sequence requested is {}", init, opSeries);
        Double result = init;
        for (String op : opSeries) {
            String[] opArr = op.split(" ");
            if (opArr.length > 2) {
                throw new CalculatorException(String.format("Invalid Operation Sequence %s. Expected Sequence example is %s", op, "+ 2"));
            }
            if (opArr[0].length() != 1) {
                throw new CalculatorException(String.format("Invalid Operator %s", opArr[0]));
            }
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
