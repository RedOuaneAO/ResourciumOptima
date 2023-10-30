package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Departement;
import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class TasksRepo {
    private  EntityManagerFactory entityManagerFactory;
    public TasksRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void add(Task task) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(task);
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

    public List<Task> getTasks() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select t from Task t", Task.class);
            List<Task> tasks = query.getResultList();
            entityManager.getTransaction().commit();
            return tasks;
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

    public boolean delete(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            Task task =entityManager.find(Task.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return false;
    }

    public boolean findUserById(Long id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            Employee emp =entityManager.find(Employee.class,id);
            return true;
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return false;
    }
}
