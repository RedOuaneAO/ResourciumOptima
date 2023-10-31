package com.example.resourciumoptima2.servlet;
import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.service.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private EmployeeService employeeService= new EmployeeService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String newPass= request.getParameter("newPass");
        String confirm_pass =request.getParameter("confirm_pass");
        if(newPass !=null && newPass.equals(confirm_pass)){
                String hashedPw = BCrypt.hashpw(confirm_pass , BCrypt.gensalt());
                Long id = Long.valueOf(userId);
                Employee employee = employeeService.getEmpById(id);
                employee.setPassword(hashedPw);
                employee.setId(id);
                employeeService.updateProfile(employee);
                response.sendRedirect("EquipmentServlet");
                return;
        }else if(userId !=null){
                Long id = Long.valueOf(userId);
                Employee employee = employeeService.getEmpById(id);
                employee.setEmail(email);
                employee.setPosition(position);
                employee.setFirstName(fName);
                employee.setLastName(sName);
                employee.setUserName(userName);
                employeeService.updateProfile(employee);
                response.sendRedirect("EquipmentServlet");
                return;
        }else{
            String password = request.getParameter("password");
            String hashedPw = BCrypt.hashpw(password , BCrypt.gensalt());
            Employee employee= new Employee(fName,sName,userName,email,hashedPw,position);
            boolean result =employeeService.addEmlpoyee(employee);
            if(result){
                request.getSession().setAttribute("errorMsg" , "The userName or Email is Already exist Or not valide");
                response.sendRedirect("register.jsp");
                return;
            }
            response.sendRedirect("login.jsp");
        }
    }

    public void destroy() {
    }
}
