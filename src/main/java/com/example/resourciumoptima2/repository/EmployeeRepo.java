package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;

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

    public List<Employee> getAllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select e from Employee e ", Employee.class);
            List<Employee> employees = query.getResultList();
            entityManager.getTransaction().commit();
            return employees;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    public Object auth(Employee employee) {
        String userName = employee.getUserName();
//        String password = employee.getPassword();
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Query query =entityManager.createQuery("select e from Employee e where e.userName = :userName" , Employee.class);
            query.setParameter("userName", userName);
            Object emp =query.getSingleResult();
            entityManager.getTransaction().commit();
//            return Optional.ofNullable(emp);
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

    public void deleteEmployee(String userId) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        long id = Long.parseLong(userId);
        try{
            Employee emp =entityManager.find(Employee.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(emp);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
