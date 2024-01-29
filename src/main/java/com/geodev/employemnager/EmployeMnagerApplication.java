package com.geodev.employemnager;

import com.geodev.employemnager.dto.EmployeeDTO;
import com.geodev.employemnager.services.EmployeeServiceImpl;
import com.geodev.employemnager.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeMnagerApplication implements CommandLineRunner {
    @Autowired
    private IEmployeeService employeeService ;
    public static void main(String[] args) {
        SpringApplication.run(EmployeMnagerApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO() ;
        employeeDTO.setAge(25);
        employeeDTO.setFirstName("name");
        employeeDTO.setLastNAme("last");
        employeeDTO.setNumeroTele("0766337343");
        EmployeeDTO employeeDTO1 = employeeService.addEmployee(employeeDTO);
        System.out.println("created employee"+employeeDTO1);

        employeeDTO.setAge(21);
        employeeDTO.setFirstName("updatefirst");
        employeeDTO.setLastNAme("updatelast");
        employeeDTO.setNumeroTele("45678900976");
        EmployeeDTO employeeDTO2 = employeeService.updateEmployee(employeeDTO,1L);
        System.out.println("updated employee"+employeeDTO2);
    }
}
