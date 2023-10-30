package com.example.resourciumoptima2.repository;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.entity.Reservation;
import com.example.resourciumoptima2.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationRepo {

    private  EntityManagerFactory entityManagerFactory;

    public ReservationRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public List<Reservation> getReservation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Date date =new Date();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select e from Reservation e", Reservation.class);
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

    public Reservation getReservById(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        Reservation reservation =entityManager.find(Reservation.class,id);
        return reservation;
    }

    public void updateReservation(Reservation reservation1) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(reservation1);
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
