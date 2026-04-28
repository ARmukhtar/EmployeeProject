package com.example.EmployeeApp.service;

import com.example.EmployeeApp.model.Department;
import com.example.EmployeeApp.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;


    public Department newDepartment(Department department) {
      return  departmentRepo.save(department);
    }
    public List<Department> allDepartment() {
        return departmentRepo.findAll();
    }
    public Department getDepartment(int id) {
        return departmentRepo.findById(id).get();
    }


    public Department editDepartment(int id, Department department) {
        if(departmentRepo.existsById(id)) {
            Department depart = departmentRepo.findById(id).get();

            depart.setName(department.getName());
            depart.setHeadOfDepartment(department.getHeadOfDepartment());
            depart.setNumberOfStaff(department.getNumberOfStaff());

            return  departmentRepo.save(depart);


        }
        else{
            return null;
        }
    }
}
