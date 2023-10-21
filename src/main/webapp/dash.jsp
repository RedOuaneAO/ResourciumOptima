<%@ page import="com.example.resourciumoptima2.entity.Employee" %>
<%@ page import="java.util.List" %>
<%--<% if (request.getAttribute("message") != null) { %>--%>
<%--&lt;%&ndash;<div class="w-100">&ndash;%&gt;--%>
<%--<h2 class="success-message text-danger d-flex justify-content-center">--%>
<%--    <%= request.getAttribute("message") %>--%>
<%--</h2>--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--<% } %>--%>
<% if (session.getAttribute("userName") ==null){
    response.sendRedirect("login.jsp");
}%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
            <span class="fw-bold text-white">${ sessionScope.userName } </span>
            <span class="text-white" style="font-size: 12px">${ sessionScope.userName } </span>
          </div>
        </div>
        <ul class="nav flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start">
          <li class="nav-item">
            <a href="#" class="nav-link px-0 text-white">
              <i class="bi bi-house"></i>
              <span class="ms-1 d-none d-sm-inline">Dashboard</span>
            </a>
          </li>
          <li>
            <a href="EmployeesServlet" class="nav-link px-0 text-white">
              <i class="bi bi-speedometer2"></i>
              <span class="ms-1 d-none d-sm-inline">Employees</span>
            </a>
          </li>
          <li>
            <a href="#" class="nav-link px-0 text-white">
              <i class="bi bi-plus-circle"></i>
              <span class="ms-1 d-none d-sm-inline">Tasks</span>
            </a>
          </li>
          <li>
            <a href="#" class="nav-link px-0 text-white">
              <i class="bi bi-person-circle"></i>
              <span class="ms-1 d-none d-sm-inline">Equipment</span></a>
          </li>
          <li>
            <a href="profile.jsp" class="nav-link px-0 text-white">
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
<%--    - -------------------------------content ----------------------------------------%>
    <div class="col py-3 overflow-x-hidden overflow-y-scroll" style="height: 100vh">
<%--       Content Wrapper ----%>
      <div class="d-flex flex-column">
<%--     -- Main Content ----%>
        <div>
<%--         -- Topbar ----%>
          <nav class="navbar navbar-expand  mb-4 shadow">
            <div>
              <p class="fs-5 ms-4">Welcome <span> ${ sessionScope.userName } !</span></p>
            </div>
          </nav>
<%--           End of Topbar ----%>
<%--           Begin Page Content ----%>
          <div class="container-fluid">
<%--             Page Heading ----%>
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
              <h3 class="mb-0 text-secondary">Dashboard</h3>
            </div>
<%--            Content Row ----%>
            <div class="row">
<%--               Earnings (Monthly) Card Example ----%>
              <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row align-items-center">
                      <div class="col mr-2">
                        <div class="text-xs fw-bold text-primary mb-1">
                          Employees</div>
                        <h5 class="mb-0 fw-bold text-secondary">testing0</h5>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
<%--              Earnings (Monthly) Card Example ----%>
              <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-success shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row align-items-center">
                      <div class="col mr-2">
                        <div class="fw-bold text-success mb-1">
                          Tasks</div>
                        <h5 class="mb-0 fw-bold text-secondary">testing</h5>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

<%--               Earnings (Monthly) Card Example ---%>
              <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-info shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row align-items-center">
                      <div class="col mr-2">
                        <div class="text-xs fw-bold text-info text-uppercase mb-1">Tasks
                        </div>
                        <div class="row align-items-center">
<%--                          <div class="col-auto">--%>
<%--                            <h5 class="mb-0 mr-3 fw-bold text-secondary">50%</h5>--%>
<%--                          </div>--%>
                          <div class="col">
                            <div class="progress progress-sm">
                              <div class="progress-bar bg-info" style="width: 50%">
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
<%--               Pending Requests Card Example ----%>
              <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-warning shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row align-items-center">
                      <div class="col mr-2">
                        <div class="text-xs fw-bold text-warning text-uppercase mb-1">
                         Equipment</div>
                        <h5 class=" mb-0 fw-bold text-gray-800">18</h5>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-comments fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

<%--             Content Row ----%>

            <div class="row">

<%--             Area Chart ----%>
              <div class="col-xl-8 ">
                <div class="card shadow mb-4">
<%--                 Card Header - Dropdown ----%>
                  <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Employees</h6>
                  </div>
<%--                Card Body ----%>


<%--              Pie Chart ----%>
              <div class="col-xl-4">
                <div class="card shadow mb-4">
<%--                 Card Header - Dropdown ----%>
                  <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Tasks</h6>
                  </div>
<%--                    Card Body       ----%>
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-striped border">
                        <tbody>
                        <tr>
                          <td>
                            <div class="rounded-circle  overflow-hidden" style="width: 35px; height:35px;">
                              <img src="#" class="w-100">
                            </div>
                          </td>
                          <td>test</td>
                          <td>test</td>
                        </tr>
                         <tr>
                          <td>
                            <div class="rounded-circle  overflow-hidden" style="width: 35px; height:35px;">
                              <img src="#" class="w-100">
                            </div>
                          </td>
                          <td>test</td>
                          <td>test</td>
                        </tr>
                         <tr>
                          <td>
                            <div class="rounded-circle  overflow-hidden" style="width: 35px; height:35px;">
                              <img src="#" class="w-100">
                            </div>
                          </td>
                          <td>test</td>
                          <td>test</td>
                        </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
<%--            Content Row ----%>
            <div class="row">
<%--       Content Column ----%>
              <div class="col-lg-6 mb-4">
<%--                 Project Card Example ----%>
                <div class="card shadow mb-4">
                  <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Reserved Equipment</h6>
                  </div>
                  <div class="card-body">
                  </div>
                </div>
              </div>

              <div class="col-lg-6 mb-4">
<%--              Illustrations ----%>
                <div class="card shadow mb-4">
                  <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Equipment</h6>
                  </div>
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-striped border">
                        <thead class="bg-secondary bg-opacity-25">
                        <tr>
                          <th scope="col">Image</th>
                          <th scope="col">Name</th>
                          <th scope="col">Type</th>
                          <th scope="col">Buying Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                        </tr> <tr>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                        </tr> <tr>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                          <td><p>test</p></td>
                        </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
<%--           /.container-fluid ----%>
        </div>
<%--         End of Main Content ----%>
        <footer class="sticky-footer  bg-white">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright &copy; ResourciumOptima 2023</span>
            </div>
          </div>
        </footer>
      </div>
<%--       End of Content Wrapper ---%>
<%--       End of Page Wrapper ----%>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
