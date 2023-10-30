package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.repository.EmployeeRepo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.employeeRepo = new EmployeeRepo(entityManagerFactory);
    }
//    add Employee
    public boolean addEmlpoyee(Employee employee) {
        Employee employee1 = (Employee) employeeRepo.auth(employee);
        if(employee1!=null || !validateEmail(employee.getEmail())){
            return true;
        }
        employeeRepo.saveEmployee(employee);
        return false;
    }
//    login
    public Object userLogin(Employee employee){
        if(employee.getUserName().isEmpty()){
            return null;
        }
      return employeeRepo.auth(employee);
    }
//    get All Employees
    public List<Employee> getEmployees(){
        List<Employee> employeeList=employeeRepo.getAllEmployees();
        return employeeList;
    }

    public boolean deleteEmp(String userId) {
        if(userId.isEmpty()){
            return false;
        }
        employeeRepo.deleteEmployee(userId);
        return true;
    }

    public void updateProfile(Employee employee) {
        employeeRepo.update_Profile(employee);
    }
    public boolean validateEmail(String email){
            String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            return email.matches(regex);
    }
}
