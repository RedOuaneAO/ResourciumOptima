package com.example.resourciumoptima2.servlet;
import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.service.EmployeeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private EmployeeService employeeService ;
    public  void init(){
         employeeService  =new EmployeeService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Employee employee =new Employee(userName,password);
        Employee result =(Employee) employeeService.userLogin(employee);
        request.setAttribute("userData" , result);
        HttpSession session = request.getSession();
        if (result==null){
            session.setAttribute("error" , "the userName or password is not correct");
            response.sendRedirect("login.jsp");
            return;
        }
        if(!BCrypt.checkpw(password ,result.getPassword())){
            session.setAttribute("error" , "the userName or password is not correct");
            response.sendRedirect("login.jsp");
        }else {
            session.setAttribute("userName", userName);
            response.sendRedirect("dash.jsp");
        }
        }
    }


