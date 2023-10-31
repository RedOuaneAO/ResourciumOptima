package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.entity.Reservation;
import com.example.resourciumoptima2.service.EquipmentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EquipmentServlet", value = "/EquipmentServlet")
public class EquipmentServlet extends HttpServlet {
    private EquipmentService equipmentService = new EquipmentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentId = request.getParameter("id");
        if(equipmentId !=null){
            int id = Integer.parseInt(equipmentId);
            equipmentService.deleteEquipment(id);
            response.sendRedirect(request.getContextPath() + "/EquipmentServlet");
        }else {
            List<Equipement> equipementList = equipmentService.getEquipment();
            request.setAttribute("equipmentList", equipementList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("equipments.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String state = request.getParameter("state");
            String buyingDate = request.getParameter(("buyDate"));
            String maintDate = request.getParameter(("maintDate"));
            Date buyDate = null;
            Date maintenanceDate = null;
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
            try{
                buyDate = simpleDateFormat.parse(buyingDate);
                maintenanceDate = simpleDateFormat.parse(maintDate);
            }catch (ParseException e){
                e.printStackTrace();
            }
            Equipement equipement= new Equipement(name , type , state, buyDate,maintenanceDate);
            equipmentService.addEquipment(equipement);
            response.sendRedirect(request.getContextPath() + "/EquipmentServlet");
    }

}
