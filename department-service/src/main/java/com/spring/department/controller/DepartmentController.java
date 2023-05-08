package com.spring.department.controller;

import com.netflix.discovery.converters.Auto;
import com.spring.department.client.EmployeeClient;
import com.spring.department.model.Department;
import com.spring.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private DepartmentRepository departmentRepository;
    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {} ", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find....");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department by ID: {} ", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employee")
    public List<Department> getDepartmentWithEmployee(){
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
        return departments;


    }

}
