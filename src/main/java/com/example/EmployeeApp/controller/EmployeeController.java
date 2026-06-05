package com.example.EmployeeApp.controller;

import com.example.EmployeeApp.dto.EmployeeDto;
import com.example.EmployeeApp.model.Employee;
import com.example.EmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "https://armukhtar.github.io", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("newEmployee")
    public ResponseEntity<Employee> newEmployee(@RequestBody Employee employeeDTO) {
        return employeeService.newEmployee(employeeDTO);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("allemployees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("updateemployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @GetMapping("EmployeeByDepart/{departId}")
    public List<Employee> getEmployeeByDepart(@PathVariable int departId) {
        return employeeService.getEmployeeByDepart(departId);
    }
}
