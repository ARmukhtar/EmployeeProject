package com.example.EmployeeApp.repository;

import com.example.EmployeeApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    boolean existsById(int id);

}
