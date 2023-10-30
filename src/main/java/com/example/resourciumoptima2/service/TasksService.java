package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Task;
import com.example.resourciumoptima2.repository.EmployeeRepo;
import com.example.resourciumoptima2.repository.TasksRepo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TasksService {
    private final EntityManagerFactory entityManagerFactory;
    private final TasksRepo tasksRepo;
    private final EmployeeRepo employeeRepo;

    public TasksService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.tasksRepo = new TasksRepo(entityManagerFactory);
        this.employeeRepo = new EmployeeRepo(entityManagerFactory);

    }

    public boolean addTask(Task task){
        boolean userExist =tasksRepo.findUserById(task.getEmployee().getId());
        LocalDate date = LocalDate.now();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 =null;
        try{
            date1 =dateFormat.parse(String.valueOf(date));
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(userExist && task.getLimitDate().after(date1)){
            tasksRepo.add(task);
            return true;
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return tasksRepo.getTasks();
    }

    public boolean deleteTask(int id) {
        if(tasksRepo.delete(id)){
            return true;
        }
        return false;
    }

    public Object getEmployees() {
        return employeeRepo.getAllEmployees();
    }
}
