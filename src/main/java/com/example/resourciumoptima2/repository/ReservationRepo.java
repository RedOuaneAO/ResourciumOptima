package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.entity.Reservation;
import com.example.resourciumoptima2.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationRepo {

    private final EntityManagerFactory entityManagerFactory;

    public ReservationRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public List<Reservation> getReservation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        LocalDate localDate = LocalDate.now();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDate);
//        System.out.println(localDateTime);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select e from Reservation e", Reservation.class);
//            query.setParameter("localDateTime" , localDateTime);
            List<Reservation> reservation = query.getResultList();
            entityManager.getTransaction().commit();
            return reservation;
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

    public void deleteReservation(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try{
            Reservation reservation =entityManager.find(Reservation.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(reservation);
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

    public List<Equipement> getEquipments() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select e from Equipement e", Equipement.class);
            List<Equipement> equipements = query.getResultList();
            entityManager.getTransaction().commit();
            return equipements;
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

    public void addReservation(Reservation reservation1) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reservation1);
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
