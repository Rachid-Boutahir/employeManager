package com.geodev.employemnager.repositories;

import com.geodev.employemnager.dto.EmployeeDTO;
import com.geodev.employemnager.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
//    @Query("SELECT e FROM Employee e WHERE e.age BETWEEN ? and ? AND e.numeroTele LIKE '?%'")
//    public List<Employee> findbyageandtel(int age1, int age2, String telstartwith);

    }
