package com.spring.department.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@ToString
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees= new ArrayList<>();

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
