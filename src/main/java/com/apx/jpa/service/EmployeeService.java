package com.apx.jpa.service;

import com.apx.jpa.entity.Employee;
import com.apx.jpa.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee) {


        return employeeRepository.save(employee);
//        return save;
    }

    public Employee getEmpById(Long id){
        Employee emp = employeeRepository.findById(id).get();
        return emp;
    }

    public Employee updateDetails(Long id,Employee emp) {
        employeeRepository.findById(id).map(employee -> {
            employee.setName(emp.getName());
            employee.setEmail(emp.getEmail());
            employee.setUserName(emp.getUserName());
            employee.setPassword(emp.getPassword());

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new EntityNotFoundException("Employee not found with id" + id));
        return emp;

    }
}
