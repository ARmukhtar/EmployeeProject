package com.example.EmployeeApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;
    private int numberOfStaff;
    private String headOfDepartment;

    public Department() {
    }

    public Department(String name, int numberOfStaff, String headOfDepartment) {
        this.name = name;
        this.numberOfStaff = numberOfStaff;
        this.headOfDepartment = headOfDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfStaff=" + numberOfStaff +
                ", headOfDepartment='" + headOfDepartment + '\'' +
                '}';
    }
}
