<%@ page import="com.example.resourciumoptima2.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.resourciumoptima2.entity.Employee" %>
<% if (session.getAttribute("userName") ==null){
  response.sendRedirect("login.jsp");
}%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Tasks</title>
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
            <img class="w-100" id="image"  src="images/home.png" alt="Profile image">
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

    <%--    -- -------------------------------content ----------------------------------------%>
    <div class="col py-3 overflow-x-hidden overflow-y-scroll" style="height: 100vh">
      <%--     -- Content Wrapper ----%>
      <div class="d-flex flex-column">
        <%--     -- Main Content ----%>
        <div>
          <%--         -- Topbar ----%>
          <nav class="navbar navbar-expand  mb-4 shadow">
            <div>
              <p class="fs-5 ms-4">Welcome <span> ${ sessionScope.userName } !</span></p>
            </div>
          </nav>
          <%--          End of Topbar ---%>
          <%--          Begin Page Content ----%>
          <div class="container-fluid">
            <%--             Page Heading --%>
            <div class="d-flex justify-content-between">
              <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h3 class="mb-0 text-secondary">Tasks</h3>
              </div>
              <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add Task
              </button>
            </div>
            <div class="row">
              <% if(session.getAttribute("Msg") != null){%>
              <div class="alert alert-success" role="alert">
                <p><strong>!!Successfuly</strong> ${sessionScope.Msg}</p>
              </div>
              <%}%>
              <div class=" d-flex justify-content-center ">
                <div class="card shadow mb-4 col-8">
                  <%--                  Card Header - Dropdown ----%>
                  <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Tasks</h6>
                  </div>
                  <%--                  -- Card Body ----%>
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-striped border">
                        <thead class="bg-secondary bg-opacity-25">
                        <tr>
                          <th scope="col">Name</th>
                          <th scope="col">description</th>
                          <th scope="col">limitDate</th>
                          <th scope="col">priority</th>
                          <th scope="col">Assigned To</th>
                          <th scope="col">status</th>
                          <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% if (request.getAttribute("result") != null) {
                          List<Task> tasksList = (List<Task>) request.getAttribute("result");
                          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                          for (Task task:tasksList) {%>
                        <tr>
                          <td><p><%= task.getName() %></p></td>
                          <td><p><%= task.getDescription() %></p></td>
                          <td><p><%= dateFormat.format(task.getLimitDate())%></p></td>
                          <td><p><%= task.getPriority() %></p></td>
                          <td><p><%= task.getEmployee().getUserName() %></p></td>
                          <td><p><%= task.getStatus() %></p></td>
                          <td>
                            <a href="TasksServlet?id=<%=task.getId()%>" class="btn btn-danger"> Delete</a>
                            <a href="updateTask.jsp?id=<%=task.getId()%>" class="btn btn-success"> Update</a>
                          </td>
                        </tr>
                        <%} } %>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%--modal--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add a task</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="TasksServlet" method="post">
            <div class="mb-4">
              <label class="form-label">Name</label>
              <input type="text" class="form-control" name="name" required>
            </div>
            <div class="mb-4">
              <label class="form-label">Description</label>
              <input type="text" class="form-control" name="description" required>
            </div>
            <div class="mb-4">
              <label class="form-label">Limit Date</label>
              <input type="date" class="form-control" name="limitDate" required>
            </div>
            <div class="mb-4">
              <label class="form-label">Priority</label>
              <select class="form-select" name="priority" required>
                <option value="Low">Low</option>
                <option value="Medium">Medium</option>
                <option value="High">High</option>
              </select>
            </div>
            <div class="mb-4">
              <label class="form-label">Status</label>
              <select class="form-select" name="status" required>
                <option value="To Do">To Do</option>
                <option value="In Progress">In Progress</option>
                <option value="Done">Done</option>
              </select>
            </div>
            <div class="mb-4">
              <label class="form-label">Assigned To </label>
              <select class="form-select" name="AssignTo" required>
                <option disabled selected>Select</option>
                <% List<Employee> employees= (List<Employee>) request.getSession().getAttribute("employees");
                  for (Employee emp :employees) { %>
                <option value="<%=emp.getId()%>"><%=emp.getUserName()%></option>
                <% }%>
              </select>
            </div>
<%--            <button type="submit" class="btn btn-primary">Add</button>--%>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Add</button>
        </div>
      </form>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
