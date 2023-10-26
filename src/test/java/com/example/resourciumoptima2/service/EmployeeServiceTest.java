package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    static EmployeeService employeeService;

    @BeforeAll
    static void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void addEmlpoyee() {
        Employee employee =new Employee();
        int before = employeeService.getEmployees().size();
        employee.setFirstName("red");
        employee.setLastName("one");
        employee.setUserName("redone");
        employee.setPosition("Developer");
        employee.setEmail("redone@gmail.com");
        employee.setPassword("test");
        employeeService.addEmlpoyee(employee);
        int after = employeeService.getEmployees().size();
        assertTrue((before+1) == after);
    }

    @Test
    void userLogin() {
        Employee employee =new Employee("admin");
        assertTrue(employeeService.userLogin(employee) !=null);
    }

    @Test
    void getEmployees() {
        assertNotNull(employeeService.getEmployees());
    }

    @Test
    void deleteEmp() {

    }
}