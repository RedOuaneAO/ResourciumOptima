package com.example.resourciumoptima2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date limitDate;
    private String priority;
    @ManyToOne
    private Employee employee;
    private String status;

    public Task(String name, String description, Date limitDate,String priority ,String status , Employee employee) {
        this.name = name;
        this.description = description;
        this.limitDate = limitDate;
        this.priority = priority;
        this.status = status;
        this.employee = employee;

    }

    public Task() {
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

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", limitDate=" + limitDate +
                ", priority='" + priority + '\'' +
                ", employee=" + employee +
                ", status='" + status + '\'' +
                '}';
    }
}
