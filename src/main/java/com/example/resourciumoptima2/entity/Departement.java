package com.example.resourciumoptima2.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "departement")
public class Departement {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name ="id")
    private int id;
    private String name;
    private String description;

    @ManyToOne
    private Employee employee;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
