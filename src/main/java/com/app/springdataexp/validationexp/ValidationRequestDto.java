package com.app.springdataexp.validationexp;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ValidationRequestDto {
    @NotBlank
    private String name;
    @Size(max = 2, message = "char limit")
    @NotNull
    private String areaName;
    @NotNull
    private int count;
}
