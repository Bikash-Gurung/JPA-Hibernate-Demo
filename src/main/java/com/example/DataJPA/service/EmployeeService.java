package com.example.DataJPA.service;

import com.example.DataJPA.entity.Employee;
import com.example.DataJPA.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    public Employee findById(Long employeeId) {
        return repository.findById(employeeId)
                         .orElseThrow(() -> new InternalError("Employee with given id not found."));
    }
}
