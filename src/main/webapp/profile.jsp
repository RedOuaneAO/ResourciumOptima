<%@ page import="com.example.resourciumoptima2.entity.Employee" %>
<%@ page import="java.util.List" %>
<% if (session.getAttribute("userName") ==null){
    response.sendRedirect("login.jsp");
}%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
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
                    <li>
                        <a href="EquipmentServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-nut"></i>
                            <span class="ms-1 d-none d-sm-inline">Equipment</span></a>
                    </li>
                    <li>
                        <a href="ReservationServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-speedometer2"></i>
                            <span class="ms-1 d-none d-sm-inline">Reservation</span>
                        </a>
                    </li>
                    <li>
                        <a href="EmployeesServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-people-fill"></i>
                            <span class="ms-1 d-none d-sm-inline">Employees</span>
                        </a>
                    </li>
                    <li>
                        <a href="TasksServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-list-task"></i>
                            <span class="ms-1 d-none d-sm-inline">Tasks</span>
                        </a>
                    </li>
                    <li>
                        <a href="DepartmentServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-house-door"></i>
                            <span class="ms-1 d-none d-sm-inline">Department</span>
                        </a>
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
                        <h5 class="fw-bold mt-3 ms-3">Profile</h5>
                        <form action="RegisterServlet" method="POST">
                            <div class="d-md-flex justify-content-evenly my-5">
                                <div class="col-md-5 shadow border rounded">
                                    <div class="p-3 pt-5">
                                        <div class="d-flex justify-content-between align-items-center mb-3">
                                            <h4 class="text-right">Profile Settings</h4>
                                        </div>
                                    <% if (session.getAttribute("employeeData") != null) {
                                        Employee EmployeeData = (Employee) session.getAttribute("employeeData");
                                    %>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>User name</label>
                                                <input type="text" name="userName" class="form-control"  value="<%=EmployeeData.getUserName()%>">
                                                <input type="text" name="userId" class="form-control" value="<%=EmployeeData.getId()%>" hidden>
                                            </div>
                                            <div class="col-md-6">
                                                <label>Position</label>
                                                <input type="text" name="position" class="form-control"  value="<%=EmployeeData.getPosition()%>">
                                            </div>
                                        </div><br>
                                        <div class="row">
                                            <div class="col-md-6"><label>First Name</label><input type="text" name="fName" class="form-control" value="<%=EmployeeData.getFirstName()%>"></div>
                                            <div class="col-md-6"><label>Last Name</label><input type="text"  name="sName"  class="form-control" value="<%=EmployeeData.getLastName()%>"/></div>
                                        </div><br>
                                        <div class="col-md-12"><label>Email</label><input type="email" name="email" class="form-control" value="<%=EmployeeData.getEmail()%>"></div>
                                    </div>
                                    <%}%>
                                    <div class="my-2 text-center">
                                        <button class="btn btn-outline-primary" type="submit">Save Changes</button>
                                    </div>
                        </form>
                    </div>
                    <div class="col-md-5 mt-3 mt-md-0 shadow border rounded">
                        <div class="p-3 pt-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Password Update</h4>
                            </div>
                            <% if (session.getAttribute("employeeData") != null) {
                                Employee EmployeeData = (Employee) session.getAttribute("employeeData");
                            %>
                            <form action="RegisterServlet" method="POST">
<%--                                <div class="col-md-12">--%>
<%--                                    <label>Old Password</label>--%>
<%--                                    <input type="password" class="form-control" name="old_password">--%>
<%--                                </div> <br>--%>
                                <input type="text" name="userId" class="form-control" value="<%=EmployeeData.getId()%>" hidden>
                                <div class="col-md-12">
                                    <label>New Password</label>
                                    <input type="password" class="form-control" name="newPass">
                                </div> <br>
                                <div class="col-md-12">
                                    <label>Confirm Password</label>
                                    <input type="password" class="form-control" name="confirm_pass">
                                </div>
                                <div class="my-2 mb-0 text-center">
                                    <button class="btn btn-outline-primary" type="submit">Save Changes</button>
                                </div>
                            </form>
                            <%}%>
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
