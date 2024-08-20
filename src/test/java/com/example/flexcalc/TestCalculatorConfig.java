package com.example.flexcalc;

import com.example.flexcalc.model.Operation;
import com.example.flexcalc.service.AddOperation;
import com.example.flexcalc.service.IOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

@TestConfiguration
public class TestCalculatorConfig {
    Logger logger = LoggerFactory.getLogger(TestCalculatorConfig.class);

    @Bean
    @Qualifier("calcOperationsMap")
    @Primary
    public Map<Operation, IOperation> getCalculatorOperationBeans() {
        Map<Operation, IOperation> OperationMap = new HashMap<>();
        OperationMap.put(Operation.ADD, new AddOperation());
        logger.info("Map of Calculator Operation Beans {}", OperationMap);
        return OperationMap;
    }
}
