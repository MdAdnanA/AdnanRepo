package com.apx.jpa.controller;

import com.apx.jpa.entity.Employee;
import com.apx.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = employeeService.saveEmployee(employee);


        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getemployee(@PathVariable Long id) {
        Employee empById = employeeService.getEmpById(id);
        return new ResponseEntity<>(empById, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable Long id,@RequestBody Employee employee){
        Employee update = employeeService.updateDetails(id, employee);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

}