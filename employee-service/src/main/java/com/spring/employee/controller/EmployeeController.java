package com.spring.employee.controller;

import com.spring.employee.model.Employee;
import com.spring.employee.repository.EmployeeRepo;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepo employeeRepo;
    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {} ", employee);
        return employeeRepo.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee find....");
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee by ID: {} ", id);
        return employeeRepo.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable Long departmentId){
        LOGGER.info("Employee found with Department : {} ", departmentId);
        return employeeRepo.findByDepartment(departmentId);
    }

}
