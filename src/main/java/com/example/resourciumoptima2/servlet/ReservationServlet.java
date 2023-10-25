package com.example.resourciumoptima2.servlet;

import com.example.resourciumoptima2.entity.Employee;
import com.example.resourciumoptima2.entity.Reservation;
import com.example.resourciumoptima2.service.ReservationService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ReservationServlet", value = "/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private ReservationService reservation = new ReservationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        reservationList.stream().peek(reservation1 -> reservation1.setEndDate());
        String resrvationId = request.getParameter("id");
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

//        response.getWriter().println(result + " " + equipmentId);
    }
}
