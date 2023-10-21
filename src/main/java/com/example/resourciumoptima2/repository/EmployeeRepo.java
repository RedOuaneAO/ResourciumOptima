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



    public Object auth(Employee employee) {
        String userName = employee.getUserName();
//        String password = employee.getPassword();
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Query query =entityManager.createQuery("select e from Employee e where e.userName = :userName" , Employee.class);
            query.setParameter("userName", userName);
//            List<Employee> emp =query.getResultList();
            Object emp =query.getSingleResult();
            entityManager.getTransaction().commit();
           return emp;
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }


}
