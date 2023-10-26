package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Equipement;
import com.example.resourciumoptima2.entity.Reservation;
import com.example.resourciumoptima2.service.ReservationService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ReservationServlet", value = "/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private ReservationService reservation = new ReservationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        reservationList.stream().peek(reservation1 -> reservation1.setEndDate());
        String resrvationId = request.getParameter("id");
        Object equipementList = reservation.getAllReservation();
        request.getSession().setAttribute("Equipments" , equipementList);
        if(resrvationId !=null){
            int id = Integer.parseInt(resrvationId);
            reservation.deleteReservation(id);
            response.sendRedirect(request.getContextPath() + "/ReservationServlet");
        }else {
            List<Reservation> reservationList =  reservation.getAll();
            request.setAttribute("reservationList", reservationList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("reservation.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String resrvationId = request.getParameter("id");
        if(resrvationId !=null){
            int id = Integer.parseInt(resrvationId);
               Reservation reservationData = reservation.getReservationById(id);
                request.setAttribute("reservationData", reservationData);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateReservation.jsp");
                requestDispatcher.forward(request,response);
        }else{
            String equipmentId = request.getParameter("equipmentId");
            String reservationDate = request.getParameter("resrvDate");
            String returnnDate = request.getParameter("returDate");
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("userName");
            Employee employee =new Employee(userName);
            Employee userData =(Employee) reservation.getAuthData(employee);
            employee.setId(userData.getId());
            Equipement equipement =new Equipement();
            equipement.setId(Long.valueOf(equipmentId));
            Date  reservationDate2= null;
            Date  returnnDate2= null;
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
            try{
                reservationDate2 = simpleDateFormat.parse(reservationDate);
                returnnDate2 = simpleDateFormat.parse(returnnDate);
            }catch (ParseException e){
                e.printStackTrace();
            }
            Reservation reservation1 = new Reservation(reservationDate2,returnnDate2,employee,equipement);
            reservation.makeReservation(reservation1);
            response.sendRedirect(request.getContextPath() + "/ReservationServlet");
        }


//        response.getWriter().println(reservation1);
    }
}
