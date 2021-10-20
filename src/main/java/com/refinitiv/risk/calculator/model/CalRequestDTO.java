package com.refinitiv.risk.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalRequestDTO {

    @Pattern(regexp = "^([0-9]+([.][0-9]*)?|[.][0-9]+)$",message = "first variable must be number")
    private String first_variable;

    @Pattern(regexp = "^([0-9]+([.][0-9]*)?|[.][0-9]+)$",message = "second variable must be number")
    private String second_variable;
}
