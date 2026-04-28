package com.example.EmployeeApp.controller;

import com.example.EmployeeApp.dto.EmployeeDto;
import com.example.EmployeeApp.model.Employee;
import com.example.EmployeeApp.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")

@Tag(name="Employee Management APIs")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(
            summary = "Create New Employee",
            description = "Creating new employee with all their information"
    )

    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 Created"
    )
    // CORS (Cross Origin Request Sharing)
    @CrossOrigin(origins = "http://localhist:3000")

    @PostMapping("newEmployee")
    public ResponseEntity<Employee> newEmployee(@RequestBody Employee employeeDTO) {
        return employeeService.newEmployee(employeeDTO);
    }

    @Operation(
            summary = "Getting an Employee",
            description = "This is to get  particular employee via id "
    )

    @ApiResponse(
            responseCode = "302",
            description = "Http Status 302 Found"
    )

    @GetMapping("employee/{id}")
     @PreAuthorize("hasAuthority('user')")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("allemployees")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<List<Employee>> getEmployees() {
        return employeeService.getEmployees();
    }


    @PostMapping("updateemployee/{id}")
    @PreAuthorize("hasAuthority('user')")

    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @GetMapping("EmployeeByDepart/{departId}")
    public List<Employee> getEmployeeByDepart(@PathVariable int departId) {
        return employeeService.getEmployeeByDepart(departId);
    }

//    @GetMapping("EmployeeByDepartName")
//    public List<Employee> getEmployeeByDepartName(@RequestParam String name) {
//        return employeeService.getEmployeeByDepartName(name);
//    }

}