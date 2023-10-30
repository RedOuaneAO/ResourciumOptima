package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Departement;
import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Task;
import com.example.resourciumoptima2.service.EmployeeService;
import com.example.resourciumoptima2.service.TasksService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TasksServlet", value = "/TasksServlet")
public class TasksServlet extends HttpServlet {
    private TasksService tasksService ;
    public  void init(){
        tasksService  =new TasksService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("id");
        Object employees = tasksService.getEmployees();
        request.getSession().setAttribute("employees" , employees);
        if(taskId !=null){
            int id = Integer.parseInt(taskId);
            tasksService.deleteTask(id);
            request.getSession().setAttribute("Msg" , "the Task has Been Deleted ");
            response.sendRedirect(request.getContextPath() + "/TasksServlet");
        }else{
            List<Task> taskList = tasksService.getAllTasks();
            request.setAttribute("result", taskList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("tasks.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String name = request.getParameter("name");
           String description = request.getParameter("description");
           String date = request.getParameter("limitDate");
           String priority = request.getParameter("priority");
           String status= request.getParameter("status");
           Long AssignTo= Long.valueOf(request.getParameter("AssignTo"));
            Employee employee = new Employee();
            employee.setId(AssignTo);
            Date limitDate = null;
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
            try{
                limitDate = simpleDateFormat.parse(date);
            }catch (ParseException e){
                e.printStackTrace();
            }
            Task task =new Task(name , description ,limitDate , priority , status , employee);
            tasksService.addTask(task);
            response.sendRedirect(request.getContextPath() + "/TasksServlet");
    }
}
