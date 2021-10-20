package com.refinitiv.risk.calculator.service;

import com.refinitiv.risk.calculator.model.CalRequestDTO;
import com.refinitiv.risk.calculator.service.calculatorService.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    CalRequestDTO calRequestDTO;

    @Autowired
    CalculatorServiceImpl calculatorService;

    @BeforeEach
    void  setup(){
        calRequestDTO = new CalRequestDTO();
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void shouldAddNodecimalPointSuccessTest() {
        calRequestDTO.setFirst_variable("10");
        calRequestDTO.setSecond_variable("20");
        String expect = "30.0";
        String actual = calculatorService.add(calRequestDTO).getResult();
        Assertions.assertEquals(expect, actual);
    }
    @Test
    void shouldAddDecimalPointSuccessTest() {
        calRequestDTO.setFirst_variable("10.05");
        calRequestDTO.setSecond_variable(".50");
        String expect = "10.55";
        String actual = calculatorService.add(calRequestDTO).getResult();

        Assertions.assertEquals(expect, actual);

    }
    @Test
    void shouldMinusPositiveSuccessTest() {
        calRequestDTO.setFirst_variable("10.05");
        calRequestDTO.setSecond_variable(".50");
        String expect = "9.55";
        String actual = calculatorService.minus(calRequestDTO).getResult();

        Assertions.assertEquals(expect, actual);

    }
    @Test
    void shouldMinusNegativeSuccessTest() {
        calRequestDTO.setFirst_variable(".50");
        calRequestDTO.setSecond_variable("10.50");
        String expect = "-10.0";
        String actual = calculatorService.minus(calRequestDTO).getResult();

        Assertions.assertEquals(expect, actual);

    }
    @Test
    void shouldMultiplyWithMultipleDecimalpointSuccessTest() {
        calRequestDTO.setFirst_variable("3.1482");
        calRequestDTO.setSecond_variable("10.0");
        String expect = "31.482";
        String actual = calculatorService.multiply(calRequestDTO).getResult();

        Assertions.assertEquals(expect, actual);

    }
    @Test
    void shouldDevideNomalSuccessTest() {
        calRequestDTO.setFirst_variable("10000");
        calRequestDTO.setSecond_variable("10.0");
        String expect = "1000.0";
        String actual = calculatorService.devide(calRequestDTO).getResult();

        Assertions.assertEquals(expect, actual);

    }
    @Test
    void shouldDevideGotInfinitySuccessTest() {
        calRequestDTO.setFirst_variable("10000");
        calRequestDTO.setSecond_variable(".0");
        String expect = "Infinity";
        String actual = calculatorService.devide(calRequestDTO).getResult();

        Assertions.assertEquals(expect, actual);

    }

}