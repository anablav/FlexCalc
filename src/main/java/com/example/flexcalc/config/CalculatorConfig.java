package com.example.flexcalc.config;

import com.example.flexcalc.model.Operation;
import com.example.flexcalc.service.IOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CalculatorConfig {
    Logger logger = LoggerFactory.getLogger(CalculatorConfig.class);

    @Bean
    @Qualifier("calcOperationsMap")
    public Map<Operation, IOperation> getCalculatorOperationBeansAsMap(List<IOperation> operationBeans) {
        Map<Operation, IOperation> OperationMap = new HashMap<>();
        operationBeans.forEach(operationBean -> OperationMap.put(operationBean.getOperationName(), operationBean));
        logger.info("Map of Calculator Operation Beans {}", OperationMap);
        return OperationMap;
    }
}
