<%@ page import="com.example.resourciumoptima2.entity.Reservation" %>
<%@ page import="com.example.resourciumoptima2.entity.Equipement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% if (session.getAttribute("userName") ==null){
  response.sendRedirect("login.jsp");
}%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update_Reservation</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"/>
</head>
<body>
<div class="container-fluid">
  <div class="row flex-nowrap ">
    <div class="col-auto col-xl-2 px-sm-2 px-0 shadow bg-primary" style="height: 100vh;">
      <div class="d-flex flex-column mt-2 px-3 pt-2">
        <a href="#" class="pb-3 mb-md-0 text-decoration-none text-dark fs-5 d-none d-sm-inline">Resourcium<span class="text-white">Optima</span></a>
        <div class="d-flex flex-column mx-auto my-3 d-none d-sm-inline">
          <div class="rounded-circle  overflow-hidden" style="width: 80px; height:80px;">
            <img class="w-100" id="image"  src="images/home.png">
          </div>
          <div class="d-flex flex-column text-black">
            <span class="fw-bold text-white">test</span>
            <span class="text-white" style="font-size: 12px">test</span>
          </div>
        </div>
        <ul class="nav flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start">
          <li class="nav-item">
            <a href="dash.jsp" class="nav-link px-0 text-white">
              <i class="bi bi-house"></i>
              <span class="ms-1 d-none d-sm-inline">Dashboard</span>
            </a>
          </li>
          <li>
            <a href="EmployeesServlet" class="nav-link px-0 text-white">
              <i class="bi bi-people-fill"></i>
              <span class="ms-1 d-none d-sm-inline">Employees</span>
            </a>
          </li>
          <li>
            <a href="DepartmentServlet" class="nav-link px-0 text-white">
              <i class="bi bi-house-door"></i>
              <span class="ms-1 d-none d-sm-inline">Department</span>
            </a>
          </li>
          <li>
            <a href="ReservationServlet" class="nav-link px-0 text-white">
              <i class="bi bi-speedometer2"></i>
              <span class="ms-1 d-none d-sm-inline">Reservation</span>
            </a>
          </li>
          <li>
            <a href="TasksServlet" class="nav-link px-0 text-white">
              <i class="bi bi-list-task"></i>
              <span class="ms-1 d-none d-sm-inline">Tasks</span>
            </a>
          </li>
          <li>
            <a href="#" class="nav-link px-0 text-white">
              <i class="bi bi-nut"></i>
              <span class="ms-1 d-none d-sm-inline">Equipment</span></a>
          </li>
          <li>
            <a href="EmployeesServlet?userName=${ sessionScope.userName }" class="nav-link px-0 text-white">
              <i class="bi bi-person-circle"></i>
              <span class="ms-1 d-none d-sm-inline">Profile</span></a>
          </li>
          <li>
            <a href="LogoutServlet" class="nav-link px-0 text-white">
              <i class="bi bi-box-arrow-left"></i>
              <span class="ms-1 d-none d-sm-inline">Logout</span> </a>
          </li>
        </ul>
      </div>
    </div>

    <%-----------------------------------content ----------------------------------------%>
    <div class="col mt-3 py-3" style="height: 100vh">
      <div class="container shadow rounded bg-white border">
        <div class="modal-content">
          <div class="modal-body">
            <% Reservation reservation = (Reservation) request.getAttribute("reservationData");
              SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
            %>
            <form action="TasksServlet" method="post">
                <div class="mb-4">
                  <label class="form-label">Reservation Date</label>
                  <input type="date" class="form-control" value="<%=simpleDateFormat.format(reservation.getStartDate()) %>" name="reservDate" required>
                </div>
                <div class="mb-4">
                  <label class="form-label">Return Date</label>
                  <input type="date" class="form-control" value="<%=simpleDateFormat.format(reservation.getEndDate())%>" name="returnDate" required>
                </div>
              <div class="mb-4">
                <label class="form-label">Equipment</label>
                <select class="form-select" name="equipment">
                  <option disabled>Select</option>
                  <% List<Equipement> equipementsList = (List<Equipement>) request.getSession().getAttribute("Equipments");
                    for (Equipement equip:equipementsList) {%>
                  <option value="<%=equip.getId()%>"><%= equip.getName()%></option>
                  <%}%>
                </select>
              </div>
              <%--            <button type="submit" class="btn btn-primary">Add</button>--%>
            </div>
            <div class="modal-footer">
                <a href="ReservationServlet" class="btn btn-success">Back</a>
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
