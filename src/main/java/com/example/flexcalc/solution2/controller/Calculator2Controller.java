package com.example.flexcalc.solution2.controller;

import com.example.flexcalc.solution2.model.Operation;
import com.example.flexcalc.solution2.service.Calculator2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v2/calc")
public class Calculator2Controller {

    @Autowired
    Calculator2 calculator2;

    @GetMapping("/add")
    public Double testAddCalculator() {
        return calculator2.calculate(Operation.ADD, 2.0, 3.0);
    }

    @GetMapping("/subtract")
    public Double testSubtractCalculator() {
        return calculator2.calculate(Operation.SUBTRACT, 2.0, 3.0);
    }

    @GetMapping("/multiply")
    public Double testMultiplyCalculator() {
        return calculator2.calculate(Operation.MULTIPLY, 2.0, 3.0);
    }

    @GetMapping("/divide")
    public Double testDivideCalculator() {
        return calculator2.calculate(Operation.DIVIDE, 10.0, 2.0);
    }

    @GetMapping("/chain")
    public Double testChain() {
        List<String> opList = Arrays.asList("+ 5", "* 10", "/ 7");

        return calculator2.calculateSeries(2.0, opList);
    }
}

