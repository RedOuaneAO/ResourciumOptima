package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.entity.Reservation;
import com.example.resourciumoptima2.repository.EmployeeRepo;
import com.example.resourciumoptima2.repository.ReservationRepo;
import com.example.resourciumoptima2.repository.TasksRepo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ReservationService {
    private final EntityManagerFactory entityManagerFactory;
    private final ReservationRepo reservationRepo;
    private final EmployeeRepo employeeRepo;

    public ReservationService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.reservationRepo = new ReservationRepo(entityManagerFactory);
        this.employeeRepo = new EmployeeRepo(entityManagerFactory);
    }
    public List<Reservation> getAll() {
        return reservationRepo.getReservation();
    }

    public void deleteReservation(int id) {
        reservationRepo.deleteReservation(id);
    }

    public Object getAuthData(Employee employee) {
        return employeeRepo.auth(employee);
    }

    public List<Equipement> getAllReservation() {
        return reservationRepo.getEquipments();
    }

    public void makeReservation(Reservation reservation1) {
        reservationRepo.addReservation(reservation1);
    }

    public Reservation getReservationById(int id) {
        return reservationRepo.getReservById(id);
    }
}
