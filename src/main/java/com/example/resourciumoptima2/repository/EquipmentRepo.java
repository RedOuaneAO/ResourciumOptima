package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class EquipmentRepo {

    private  EntityManagerFactory entityManagerFactory;

    public EquipmentRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    
    public void addEquipment(Equipement equipement){
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(equipement);
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
    public List<Equipement> getAllEquipment() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select e from Equipement e ", Equipement.class);
            List<Equipement> equipement = query.getResultList();
            entityManager.getTransaction().commit();
            return equipement;
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
    public void deleteEquipment(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            Equipement equipement =entityManager.find(Equipement.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(equipement);
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
