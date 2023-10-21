package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.repository.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.employeeRepo = new EmployeeRepo(entityManagerFactory);
    }
//    add Employee
    public void addEmlpoyee(Employee employee) {
        employeeRepo.saveEmployee(employee);
    }
//    login
    public Object userLogin(Employee employee){
      return employeeRepo.auth(employee);
    }
//    get All Employees
    public List<Employee> getEmployees(){
        List<Employee> employeeList=employeeRepo.getAllEmployees();
        return employeeList;
    }


}
