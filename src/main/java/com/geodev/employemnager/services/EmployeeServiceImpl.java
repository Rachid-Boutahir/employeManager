package com.geodev.employemnager.services;

import com.geodev.employemnager.dto.EmployeeDTO;
import com.geodev.employemnager.entities.Employee;
import com.geodev.employemnager.repositories.IEmployeeRepository;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employees.stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        // TODO
        Employee employee = employeeRepository.findById(id).orElse(null);
        return mapper.map(employee, EmployeeDTO.class);

    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        employeeRepository.save(employee);
        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "employee not found"
            );
        }
        employeeOptional.get().setId(id);
        employeeOptional.get().setAge(employee.getAge());
        employeeOptional.get().setFirstName(employee.getFirstName());
        employeeOptional.get().setLastNAme(employee.getLastNAme());
        employeeOptional.get().setNumeroTele(employeeDTO.getNumeroTele());
        employeeRepository.save(employeeOptional.get());
        return mapper.map(employeeOptional.get(), EmployeeDTO.class);
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
