package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Departement;
import com.example.resourciumoptima2.repository.DepartmentRepo;
import com.example.resourciumoptima2.repository.TasksRepo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DepartmentService {
    private final EntityManagerFactory entityManagerFactory;
    private final DepartmentRepo departmentRepo;

    public DepartmentService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.departmentRepo = new DepartmentRepo(entityManagerFactory);
    }

    public void addDepartment(Departement department) {
        departmentRepo.addDepart(department);
    }

    public List<Departement> getAllDepartment() {
        List<Departement> deparList =departmentRepo.getDepartments();
        return deparList;
    }

    public void deletedepart(int id) {
        departmentRepo.delete(id);
    }
}
