package com.example.flexcalc;

import com.example.flexcalc.solution2.model.Operation;
import com.example.flexcalc.solution2.service.Calculator2;
import com.example.flexcalc.solution2.utils.CalculatorException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Calculator2Test {
    @InjectMocks
    private Calculator2 calculatorService;
    @BeforeEach
    public void setUp() {
        // initialize common objects or set up necessary preconditions
    }

    @Test
    public void testCalculateAddSuccess() {
        Double result = calculatorService.calculate(Operation.ADD, 2.0, 3.0);
        Assertions.assertEquals(5.0, result.doubleValue());
    }

    @Test
    public void testCalculateMultiplySuccess() {
        Double result = calculatorService.calculate(Operation.MULTIPLY, 2.0, 3.0);
        Assertions.assertEquals(6.0, result.doubleValue());
    }

    @Test
    public void testCalculateDivideSuccess() {
        Double result = calculatorService.calculate(Operation.DIVIDE, 10.0, 5.0);
        Assertions.assertEquals(2.0, result.doubleValue());
    }

    @Test
    public void testCalculateSubtractSuccess() {
        Double result = calculatorService.calculate(Operation.SUBTRACT, 10.0, 7.0);
        Assertions.assertEquals(3.0, result.doubleValue());
    }

    @Test
    public void testCalculateDivideByZeroError() {
        Throwable exception = Assertions.assertThrows(CalculatorException.class, () -> calculatorService.calculate(Operation.DIVIDE, 10.0, 0.0));
        Assertions.assertEquals("Division by Zero Error.", exception.getMessage());
    }

    @Test
    public void testCalculateSeriesSuccess() {
        Double init = 2.0;
        List<String> opList = Arrays.asList("+ 5", "* 10", "/ 7");
        Double result = calculatorService.calculateSeries(init, opList);
        Assertions.assertEquals(10.0, result.doubleValue());
    }

    @Test
    public void testCalculateSeriesFail_InvalidOperator() {
        Double init = 2.0;
        List<String> opList = Arrays.asList("+ 5", "% 10", "/ 7");
        Throwable exception = Assertions.assertThrows(CalculatorException.class, () -> calculatorService.calculateSeries(init, opList));
        Assertions.assertEquals("Operation % not supported yet.", exception.getMessage());
    }

    @Test
    public void testCalculateSeriesFail_InvalidOperator1() {
        Double init = 2.0;
        List<String> opList = Arrays.asList("+ 5", "** 10", "/ 7");
        Throwable exception = Assertions.assertThrows(CalculatorException.class, () -> calculatorService.calculateSeries(init, opList));
        Assertions.assertEquals("Invalid Operator **", exception.getMessage());
    }

    @Test
    public void testCalculateSeriesFail_InvalidOperationSequence() {
        Double init = 2.0;
        List<String> opList = Arrays.asList("+ 5", "* 10 11", "/ 7");
        Throwable exception = Assertions.assertThrows(CalculatorException.class, () -> calculatorService.calculateSeries(init, opList));
        Assertions.assertEquals("Invalid Operation Sequence * 10 11. Expected Sequence example is + 2", exception.getMessage());
    }
    @AfterEach
    public void tearDown() {
        // Reset mocks or any shared state if necessary
    }

}
