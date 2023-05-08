package com.spring.employee.repository;

import com.spring.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepo {

    public  List<Employee> employeeList = new ArrayList<>();

    public  Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public  List<Employee> findAll(){
        return employeeList;
    }

    public Employee findById(Long id ){
       return employeeList.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();

    }

    public List<Employee> findByDepartment(Long departmentId){
        return employeeList.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }

}
