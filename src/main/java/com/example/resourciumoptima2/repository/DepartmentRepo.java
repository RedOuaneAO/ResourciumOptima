package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Departement;
import com.example.resourciumoptima2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class DepartmentRepo {
    private final EntityManagerFactory entityManagerFactory;

    public DepartmentRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void addDepart(Departement department) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(department);
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

    public List<Departement> getDepartments() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select d from Departement d", Departement.class);
            List<Departement> department = query.getResultList();
            entityManager.getTransaction().commit();
            return department;
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

    public void delete(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            Departement department =entityManager.find(Departement.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(department);
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
