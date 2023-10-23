package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Departement;
import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.service.DepartmentService;
import com.example.resourciumoptima2.service.TasksService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    private DepartmentService departmentService =new DepartmentService() ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departId = request.getParameter("id");
        if(departId !=null){
            int id = Integer.parseInt(departId);
            departmentService.deletedepart(id);
            response.sendRedirect(request.getContextPath() + "/DepartmentServlet");
        }else{
        List<Departement> departmentList = departmentService.getAllDepartment();
        request.setAttribute("result", departmentList);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("department.jsp");
        requestDispatcher.forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        String description = request.getParameter("description");
        Departement departement = new Departement(name, description);
        departmentService.addDepartment(departement);
        response.sendRedirect(request.getContextPath() + "/DepartmentServlet");
    }
}
