package com.example.EmployeeApp.controller;

import com.example.EmployeeApp.model.Department;
import com.example.EmployeeApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
@PostMapping("newdepartment")
    public Department newDeparment(@RequestBody Department department){
        return departmentService.newDepartment(department);
    }


    @GetMapping("departments")

    public List<Department> allDepartments(){
        return departmentService.allDepartment();
    }

    @GetMapping("getdepartment/{id}")

    public Department getDepartment(@PathVariable int id){
    return departmentService.getDepartment(id);
    }

    @PostMapping("editDepartment/{id}")
    public Department editDepartment( @PathVariable int id, @RequestBody Department department ){
    return departmentService.editDepartment(id, department);
    }
}




