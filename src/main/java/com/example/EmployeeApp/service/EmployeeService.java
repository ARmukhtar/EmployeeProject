package com.example.EmployeeApp.service;

import com.example.EmployeeApp.dto.EmailDetails;
import com.example.EmployeeApp.dto.EmployeeDto;
import com.example.EmployeeApp.dto.EmployeeInfo;
import com.example.EmployeeApp.model.Department;
import com.example.EmployeeApp.model.Employee;
import com.example.EmployeeApp.repository.DepartmentRepo;
import com.example.EmployeeApp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<Employee> newEmployee(Employee employeeDTO) {

        double salary = 0;
        double tax = 0;
        double balance =0;

        Employee employee = new Employee();

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAge(employeeDTO.getAge());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartId(employeeDTO.getDepartId());

        int yoe = employeeDTO.getYoe();

        if(yoe <3){
            salary =5000;
            tax =0.1;

        } else if (yoe<5) {
            salary = 8000;
            tax =0.15;

        }
        else if (yoe<8) {
            salary = 15000;
            tax =0.20;

        }
        else if (yoe<10) {
            salary = 20000;
            tax =0.15;

        }

        else {
            salary = 30000;
            tax =0.15;

        }

        balance = salary -(tax*salary);

        employee.setYoe(yoe);
        employee.setSalary(salary);
        employee.setTax(tax);
        employee.setBalance(balance);

        employee = employeeRepo.save(employee);

        Department department = departmentRepo.findById(employeeDTO.getDepartId()).get();

        department.setNumberOfStaff(department.getNumberOfStaff()+1);

        departmentRepo.save(department);

        EmailDetails emailDetails = new EmailDetails();

        emailDetails.setRecipient(employee.getEmail());
        emailDetails.setSubject("Employee Creation");
        emailDetails.setMessageBody("Welcome to Softcode company \n" +
                "Employee Name: "+employee.getFirstName()+"\n" +
                "Your Staff ID: soft 2026"+employee.getId()+"\n" +
                "Your Salary: "+ employee.getSalary()+"\n"
        );
        emailService.sendMail(emailDetails);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);


    }

    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeRepo.findAll();

        return new ResponseEntity<>(employees,HttpStatus.FOUND);

    }

    public ResponseEntity<?> getEmployee(int id) {
        if(employeeRepo.existsById(id)){
            EmployeeInfo employeeInfo = new EmployeeInfo(); //tightly coupled

            Employee employee = employeeRepo.findById(id).get();
            Department department = departmentRepo.findById(employee.getDepartId()).get();

            employeeInfo.setEmployee(employee);
            employeeInfo.setDepartment(department);
            return new ResponseEntity<>(employeeInfo, HttpStatus.FOUND);
        }
        else {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            return new ResponseEntity<>(employeeInfo, HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Employee> updateEmployee(int id, EmployeeDto employeeDTO) {

        Employee employee = employeeRepo.findById(id).get();

        double salary = 0;
        double tax = 0;
        double balance =0;



        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAge(employeeDTO.getAge());
        employee.setEmail(employeeDTO.getEmail());
        employee.setYoe((employeeDTO.getYoe()));

        if(employee.getDepartId() == employeeDTO.getDepartId()){
            employee.setDepartId(employeeDTO.getDepartId());
        }
        else{
            Department department_of_employee = departmentRepo.findById(employee.getDepartId()).get();
            department_of_employee.setNumberOfStaff(department_of_employee.getNumberOfStaff()-1);
            departmentRepo.save(department_of_employee);

            Department update_department = departmentRepo.findById(employeeDTO.getDepartId()).get();
            update_department.setNumberOfStaff(update_department.getNumberOfStaff()+1);
            departmentRepo.save(update_department);
        }
        int yoe = employeeDTO.getYoe();

        if(yoe <3){
            salary =5000;
            tax =0.1;

        } else if (yoe<5) {
            salary = 8000;
            tax =0.15;

        }
        else if (yoe<8) {
            salary = 15000;
            tax =0.20;

        }
        else if (yoe<10) {
            salary = 20000;
            tax =0.15;

        }

        else {
            salary = 30000;
            tax =0.15;

        }
        balance = salary -(tax*salary);

        employee.setYoe(yoe);
        employee.setSalary(salary);
        employee.setTax(tax);
        employee.setBalance(balance);

        employee.setDepartId(employeeDTO.getDepartId());

        employee = employeeRepo.save(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);

    }

    public List<Employee> getEmployeeByDepart(int departId) {
        Department depart = departmentRepo.findById(departId).get();

        List<Employee> employees = employeeRepo.findAll();

        List<Employee> empDepart = new ArrayList<>();

        for(Employee emp : employees){
            if(emp.getDepartId()==departId){
                empDepart.add(emp);

            }
        }
        return empDepart;
    }

//    public List<Employee> getEmployeeByDepartName(String name) {
//        List<Department> depart = departmentRepo.findByName(name);
//        //Department dp = new Department();
//        List<Employee> employees = employeeRepo.findAll();
//
//        List<Employee> empDepart = new ArrayList<>();
//
//        for(Employee emp : employees){
//            if(emp.getDepartId()== depart){
//                empDepart.add(emp);
//
//            }
//        }
//       return empDepart;
//
//    }

//    public List<Employee> getEmployeeByName(int departId) {
//        Department depart = departmentRepo.findById(departId).get();
//
//        List<Employee> employees = employeeRepo.findAll();
//        Department dp = new Department();
//        List<Employee> empDepart = new ArrayList<>();
//        for(Department)
//
//        }
//        return empDepart;
//    }
}
