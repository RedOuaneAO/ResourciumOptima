package com.example.resourciumoptima2.service;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {
    static TasksService tasksService;
    @BeforeAll
    static void setUp() {
        tasksService = new TasksService();
    }

//    test if the assigned user is exist
    @Test
    void addTask() {
        Task task =new Task();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int before = tasksService.getAllTasks().size();
        task.setName("test");
        task.setDescription("test");
        try {
            task.setLimitDate(dateFormat.parse("2023-01-12"));
        }catch (
             ParseException e){
            e.printStackTrace();
        }
        task.setPriority("low");
        task.setStatus("toDo");
        Employee employee = new Employee();
        employee.setId(22L);
        task.setEmployee(employee);
        tasksService.addTask(task);
        int after = tasksService.getAllTasks().size();
        assertFalse((before+1) == after);
    }
//    testing the date shouldn't be before the current date
    @Test
    void addTask2() {
        Task task =new Task();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int before = tasksService.getAllTasks().size();
        task.setName("test");
        task.setDescription("test");
        try {
            task.setLimitDate(dateFormat.parse("2023-12-12"));
        }catch (ParseException e){
                e.printStackTrace();
        }
        task.setPriority("low");
        task.setStatus("toDo");
        Employee employee = new Employee();
        employee.setId(2L);
        task.setEmployee(employee);
        tasksService.addTask(task);
        int after = tasksService.getAllTasks().size();
        assertTrue((before+1) == after);
    }

    @Test
    void getAllTasks() {
        assertNotNull(tasksService.getAllTasks());
    }

    @Test
    void deleteTask() {
        assertTrue(tasksService.deleteTask(402));
    }
}