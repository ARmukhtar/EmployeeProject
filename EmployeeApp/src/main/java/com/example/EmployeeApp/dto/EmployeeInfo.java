package com.example.EmployeeApp.dto;

import com.example.EmployeeApp.model.Department;
import com.example.EmployeeApp.model.Employee;

public class EmployeeInfo {

    private Employee employee;
    private Department department;

    public EmployeeInfo() {
    }

    public EmployeeInfo(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "employee=" + employee +
                ", department=" + department +
                '}';
    }
}
