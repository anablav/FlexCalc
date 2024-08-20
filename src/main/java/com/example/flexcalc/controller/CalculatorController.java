package com.example.flexcalc.controller;

import com.example.flexcalc.model.Operation;
import com.example.flexcalc.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/calc")
public class CalculatorController {

    @Autowired
    Calculator calculator;

    @GetMapping("/add")
    public Double testAddCalculator() {
        return calculator.calculate(Operation.ADD, 2.0, 3.0);
    }

    @GetMapping("/subtract")
    public Double testSubtractCalculator() {
        return calculator.calculate(Operation.SUBTRACT, 2.0, 3.0);
    }

    @GetMapping("/multiply")
    public Double testMultiplyCalculator() {
        return calculator.calculate(Operation.MULTIPLY, 2.0, 3.0);
    }

    @GetMapping("/divide")
    public Double testDivideCalculator() {
        return calculator.calculate(Operation.DIVIDE, 10.0, 2.0);
    }

    @GetMapping("/chain")
    public Double testChain() {
        List<String> opList = Arrays.asList("+ 5", "* 10", "/ 7");

        return calculator.calculateSeries(2.0, opList);
    }
}

