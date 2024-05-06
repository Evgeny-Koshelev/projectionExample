package org.example.controllers;

import org.example.entities.Employee;
import org.example.projections.EmployeeProjection;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }

    @GetMapping("/position")
    public ResponseEntity<List<EmployeeProjection>> getByPosition(@PathVariable String position) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByPosition(position));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeProjection> get(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((EmployeeProjection) new Exception("Some problems"));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Employee());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Employee());
        }
    }

    @PatchMapping("/change")
    public ResponseEntity<Employee> change(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Employee());
        }
    }
}
