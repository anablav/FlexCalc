package com.example.flexcalc.solution2.service;

import org.springframework.stereotype.Component;

@Component
@FunctionalInterface
public interface IOperation2 {
    Double operate(Double num1, Double num2);
}
