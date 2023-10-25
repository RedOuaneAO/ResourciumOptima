package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.repository.EmployeeRepo;
import com.example.resourciumoptima2.repository.EquipmentRepo;
import com.example.resourciumoptima2.repository.ReservationRepo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EquipmentService {

    private final EntityManagerFactory entityManagerFactory;
    private final EquipmentRepo equipmentRepo;

    public EquipmentService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.equipmentRepo = new EquipmentRepo(entityManagerFactory);
    }
    public void addEquipment(Equipement equipement) {
        equipmentRepo.addEquipment(equipement);
    }
    public List<Equipement> getEquipment() {
        return equipmentRepo.getAllEquipment();
    }

    public void deleteEquipment(int id) {
        equipmentRepo.deleteEquipment(id);
    }


}
