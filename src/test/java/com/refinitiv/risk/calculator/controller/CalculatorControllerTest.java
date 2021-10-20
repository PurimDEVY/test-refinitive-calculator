package com.refinitiv.risk.calculator.controller;

import com.refinitiv.risk.calculator.model.CalRequestDTO;
import com.refinitiv.risk.calculator.model.CalServiceResponse;
import com.refinitiv.risk.calculator.service.calculatorService.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    private CalRequestDTO calRequestDTO;

    @Mock
    private CalculatorServiceImpl calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    void  setup(){
        calRequestDTO = new CalRequestDTO();
    }

    @Test
    void shouldAddSuccessTest() {

        calRequestDTO.setFirst_variable("20");
        calRequestDTO.setSecond_variable("10");
        CalServiceResponse res = new CalServiceResponse();
        res.setResult("30.0");
        Mockito.when(calculatorService.add(calRequestDTO)).thenReturn(res);
        ResponseEntity<CalServiceResponse> actual =  calculatorController.add(calRequestDTO);
        Assertions.assertEquals(HttpStatus.OK, actual.getStatusCode());

    }
    @Test
    void shouldMinusSuccessTest() {

        calRequestDTO.setFirst_variable("20.0");
        calRequestDTO.setSecond_variable("10");
        CalServiceResponse res = new CalServiceResponse();
        res.setResult("10.0");
        Mockito.when(calculatorService.minus(calRequestDTO)).thenReturn(res);
        ResponseEntity<CalServiceResponse> actual =  calculatorController.minus(calRequestDTO);
        Assertions.assertEquals(HttpStatus.OK, actual.getStatusCode());

    }

    @Test
    void shouldMultiplySuccessTest() {

        calRequestDTO.setFirst_variable("20.0");
        calRequestDTO.setSecond_variable("0.5");
        CalServiceResponse res = new CalServiceResponse();
        res.setResult("10.0");
        Mockito.when(calculatorService.multiply(calRequestDTO)).thenReturn(res);
        ResponseEntity<CalServiceResponse> actual =  calculatorController.multiply(calRequestDTO);
        Assertions.assertEquals(HttpStatus.OK, actual.getStatusCode());

    }

    @Test
    void shouldDevideSuccessTest() {

        calRequestDTO.setFirst_variable("20.0");
        calRequestDTO.setSecond_variable("2.00");
        CalServiceResponse res = new CalServiceResponse();
        res.setResult("10.0");
        Mockito.when(calculatorService.multiply(calRequestDTO)).thenReturn(res);
        ResponseEntity<CalServiceResponse> actual =  calculatorController.multiply(calRequestDTO);
        Assertions.assertEquals(HttpStatus.OK, actual.getStatusCode());

    }
}
