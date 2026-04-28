package com.example.EmployeeApp.repository;

import com.example.EmployeeApp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    List<Department> findByName(String name);
}
