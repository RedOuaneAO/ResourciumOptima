package com.example.resourciumoptima2;

import java.io.*;


import com.example.resourciumoptima2.entity.Employee;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet" ,loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private String message;
      private   EntityManagerFactory entityManagerFactory = null;
      private  EntityManager entityManager = null;
    public void init() {


            entityManagerFactory = Persistence.createEntityManagerFactory("default");
            entityManager = entityManagerFactory.createEntityManager();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String fName = req.getParameter("fName");
                String sName = req.getParameter("sName");
                Employee employee= new Employee();
                employee.setFirstName(fName);
                employee.setLastName(sName);
                entityManager.getTransaction().begin();
                entityManager.persist(employee);
                entityManager.getTransaction().commit();
                entityManager.close();
                entityManagerFactory.close();


    }

    public void destroy() {
    }
}