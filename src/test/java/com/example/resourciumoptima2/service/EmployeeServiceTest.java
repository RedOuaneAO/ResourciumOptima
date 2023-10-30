package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    static EmployeeService employeeService;

    @BeforeAll
    static void setUp() {
        employeeService = new EmployeeService();
    }


//    if the userName is already exist
    @Test
    void addEmlpoyee() {
        Employee employee =new Employee();
        int before = employeeService.getEmployees().size();
        employee.setFirstName("red");
        employee.setLastName("one");
        employee.setUserName("redonetest");
        employee.setPosition("Developer");
        employee.setEmail("redoneake@gmail.com");
        employee.setPassword("test");
        employeeService.addEmlpoyee(employee);
        int after = employeeService.getEmployees().size();
        assertTrue((before+1) == after);
        employeeService.deleteEmp(String.valueOf(employee.getId()));
    }

    @Test
    void userLogin() {
        Employee employee =new Employee("admin");
        assertTrue(employeeService.userLogin(employee) !=null);
    }
    @Test
    void userLogin2() {
        Employee employee =new Employee("isnotexist");
        assertNull(employeeService.userLogin(employee));
    }
    @Test
    void userLogin3() {
        Employee employee =new Employee("");
        assertEquals(null,employeeService.userLogin(employee) );
    }

    @Test
    void getEmployees() {
        assertNotNull(employeeService.getEmployees());
    }

    @Test
    void deleteEmp() {
        assertTrue(employeeService.deleteEmp("102"));
    }
    @Test
    void validateEmail(){
        String email = "test@gmail.com";
        assertTrue(employeeService.validateEmail(email));
    }
}