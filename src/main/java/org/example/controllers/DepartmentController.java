package org.example.controllers;

import org.example.entities.Department;
import org.example.entities.Employee;
import org.example.services.DepartmentService;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> get(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.getById(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Department());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Department> delete(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Department());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.save(department));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Department());
        }
    }

    @PatchMapping("/change")
    public ResponseEntity<Department> change(@RequestBody Department department) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.save(department));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Department());
        }
    }

}
