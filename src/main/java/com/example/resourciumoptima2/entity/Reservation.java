package com.example.resourciumoptima2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Equipement equipement;

    public Reservation(Date startDate, Date endDate, Employee employee, Equipement equipement) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.equipement = equipement;
    }

    public Reservation(Date startDate, Date endDate, Equipement equipement) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.equipement = equipement;
    }

    public Reservation() {
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employee=" + employee +
                ", equipement=" + equipement +
                '}';
    }
}
