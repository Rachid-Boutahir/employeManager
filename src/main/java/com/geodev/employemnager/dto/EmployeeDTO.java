package com.geodev.employemnager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastNAme;
    @NotBlank
    private String numeroTele;
    @NotNull
    private int age;
}
