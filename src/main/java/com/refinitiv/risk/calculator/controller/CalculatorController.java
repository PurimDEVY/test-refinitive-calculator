package com.refinitiv.risk.calculator.controller;

import com.refinitiv.risk.calculator.model.CalServiceResponse;
import com.refinitiv.risk.calculator.model.CalRequestDTO;
import com.refinitiv.risk.calculator.service.calculatorService.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
@Validated
public class CalculatorController {
    private CalculatorService calculatorService;
    public static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<CalServiceResponse> add(@Valid @RequestBody CalRequestDTO request)  {

        LOG.info("Operate Add");
        CalServiceResponse response = calculatorService.add(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/minus")
    public ResponseEntity<CalServiceResponse> minus(@Valid @RequestBody CalRequestDTO request) {

        LOG.info("Operate Minus");
        CalServiceResponse response = calculatorService.minus(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/devide")
    public ResponseEntity<CalServiceResponse> devide(@Valid @RequestBody CalRequestDTO request) {
        LOG.info("Operate Devide");
        CalServiceResponse response = calculatorService.devide(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/multiply")
    public ResponseEntity<CalServiceResponse> multiply(@Valid @RequestBody CalRequestDTO request)   {

        LOG.info("Operate Multiply");
        CalServiceResponse response = calculatorService.multiply(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

