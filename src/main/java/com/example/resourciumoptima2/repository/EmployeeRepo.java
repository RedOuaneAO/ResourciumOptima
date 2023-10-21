package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java.util.List;

public class EmployeeRepo {
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void saveEmployee(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


}
