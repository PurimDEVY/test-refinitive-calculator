package com.refinitiv.risk.calculator.service.calculatorService;

import com.refinitiv.risk.calculator.model.CalRequestDTO;
import com.refinitiv.risk.calculator.model.CalServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    public static final Logger LOG = LoggerFactory.getLogger(CalculatorServiceImpl.class);



    @Override
    public CalServiceResponse add(CalRequestDTO calRequestDTO) throws ArithmeticException {
        Double first_variable = Double.parseDouble(calRequestDTO.getFirst_variable());
        Double second_variable = Double.parseDouble(calRequestDTO.getSecond_variable());
        LOG.info("Calculate " + first_variable + " Add " + second_variable);
        CalServiceResponse response = new CalServiceResponse(Double.toString (first_variable + second_variable));

        return response;
    }

    @Override
    public CalServiceResponse minus(CalRequestDTO calRequestDTO) throws ArithmeticException {

        Double first_variable = Double.parseDouble(calRequestDTO.getFirst_variable());
        Double second_variable = Double.parseDouble(calRequestDTO.getSecond_variable());
        LOG.info("Calculate " + first_variable + " minus " + second_variable);
        CalServiceResponse response = new CalServiceResponse(Double.toString (first_variable - second_variable));

        return response;
    }

    @Override
    public CalServiceResponse multiply(CalRequestDTO calRequestDTO) throws ArithmeticException{

        Double first_variable = Double.parseDouble(calRequestDTO.getFirst_variable());
        Double second_variable = Double.parseDouble(calRequestDTO.getSecond_variable());
        LOG.info("Calculate " + first_variable + " multiply " + second_variable);
        CalServiceResponse response = new CalServiceResponse();
        response = new CalServiceResponse(Double.toString(first_variable * second_variable));

        return response;
    }

    @Override
    public CalServiceResponse devide(CalRequestDTO calRequestDTO) throws ArithmeticException {

        Double first_variable = Double.parseDouble(calRequestDTO.getFirst_variable());
        Double second_variable = Double.parseDouble(calRequestDTO.getSecond_variable());
        LOG.info("Calculate " + first_variable + " devide by " + second_variable);
        CalServiceResponse response = new CalServiceResponse();
        response = new CalServiceResponse(Double.toString(first_variable / second_variable));

        return response;
    }
}
