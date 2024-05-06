package org.example.repositories;

import org.example.entities.Employee;
import org.example.projections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    EmployeeProjection findByIdAndFirstName(UUID uuid, String firstName);

    List<EmployeeProjection> findByPosition(String position);
}
