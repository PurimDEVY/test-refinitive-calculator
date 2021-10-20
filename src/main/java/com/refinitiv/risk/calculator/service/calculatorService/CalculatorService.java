package com.refinitiv.risk.calculator.service.calculatorService;

import com.refinitiv.risk.calculator.model.CalRequestDTO;
import com.refinitiv.risk.calculator.model.CalServiceResponse;

public interface CalculatorService {

    CalServiceResponse add(CalRequestDTO calRequestDTO);
    CalServiceResponse minus(CalRequestDTO calRequestDTO);
    CalServiceResponse multiply(CalRequestDTO calRequestDTO);
    CalServiceResponse devide(CalRequestDTO calRequestDTO);
}
