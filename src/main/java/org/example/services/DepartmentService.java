package org.example.services;

import org.example.entities.Department;
import org.example.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getById(UUID id) {
        Optional<Department> optionalOrder = departmentRepository.findById(id);
        return optionalOrder.orElseGet(Department::new);
    }


    public List<Department> getAll() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Transactional
    public Department save(Department orders) {
        return departmentRepository.save(orders);
    }

    @Transactional
    public Department delete(UUID id) {
        Department department = getById(id);
        if(department.getId() != null)
            departmentRepository.deleteById(id);
        return department;
    }
}
