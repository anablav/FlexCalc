package com.example.flexcalc.solution2.service;

import com.example.flexcalc.solution2.model.Operation;
import com.example.flexcalc.solution2.utils.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Calculator2 {
    Logger logger = LoggerFactory.getLogger(Calculator2.class);

    public Double calculate(Operation op, Double num1, Double num2) {
        try {
            logger.info("Operation requested is {}", op);
            IOperation2 opBean = Operation.getLambdaByName(op);
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
