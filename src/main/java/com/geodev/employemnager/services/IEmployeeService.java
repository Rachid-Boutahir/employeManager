package com.geodev.employemnager.services;

import com.geodev.employemnager.dto.EmployeeDTO;
import com.geodev.employemnager.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO getEmployeeById(Long id);

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id);

    public void deleteEmployee(Long id);

}
