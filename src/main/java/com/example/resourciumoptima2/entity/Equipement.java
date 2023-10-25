package com.example.resourciumoptima2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "equipement")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name ;
    private String type;
    private String state;
    private Date buyingDate;
    private Date maintDate;


    public Equipement(String name, String type, String state, Date buyingDate, Date maintDate) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.buyingDate = buyingDate;
        this.maintDate = maintDate;
    }

    public Equipement() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public Date getMaintDate() {
        return maintDate;
    }

    public void setMaintDate(Date maintDate) {
        this.maintDate = maintDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", buyingDate=" + buyingDate +
                ", maintDate=" + maintDate +
                '}';
    }
}
