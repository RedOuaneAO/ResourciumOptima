package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Task;
import com.example.resourciumoptima2.service.EmployeeService;
import com.example.resourciumoptima2.service.TasksService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TasksServlet", value = "/TasksServlet")
public class TasksServlet extends HttpServlet {
    private TasksService tasksService ;
    public  void init(){
        tasksService  =new TasksService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String name = request.getParameter("name");
           String description = request.getParameter("description");
           String date = request.getParameter("limitDate");
           String priority = request.getParameter("priority");
        Task task =new Task(name , description  , priority);
       tasksService.addTask(task);



//        PrintWriter printWriter =response.getWriter();
//        printWriter.println(result);
    }
}
