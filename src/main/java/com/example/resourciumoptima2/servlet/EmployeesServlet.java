package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.service.EmployeeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmployeesServlet", value = "/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
    private EmployeeService employeeService= new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authUserName = request.getParameter("userName");
        if(authUserName != null){
            Employee employee = new Employee(authUserName);
            Employee userData =(Employee) employeeService.userLogin(employee);
            request.getSession().setAttribute("employeeData" , userData);
//            request.setAttribute("employeeData" , userData);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("profile.jsp");
            requestDispatcher.forward(request,response);
        }else {
            List<Employee> employeeList = employeeService.getEmployees();
            request.setAttribute("result", employeeList);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("employeesView.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        employeeService.deleteEmp(userId);
        response.sendRedirect("EmployeesServlet");
    }

}
