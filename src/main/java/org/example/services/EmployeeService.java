package org.example.services;

import org.example.entities.Employee;
import org.example.projections.EmployeeProjection;
import org.example.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeProjection getById(UUID id) {
        String name= employeeRepository.findById(id).get().getFirstName();
        return employeeRepository.findByIdAndFirstName(id, name);
    }


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<EmployeeProjection> getByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    @Transactional
    public Employee save(Employee orders) {
        return employeeRepository.save(orders);
    }

    @Transactional
    public Employee delete(UUID id) {
        Employee employee = employeeRepository.getById(id);
        if(employee.getId() != null)
            employeeRepository.deleteById(id);
        return employee;
    }
}
