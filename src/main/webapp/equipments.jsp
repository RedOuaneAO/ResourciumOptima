<%--<% if (session.getAttribute("userName") ==null){--%>
<%--  response.sendRedirect("login.jsp");--%>
<%--}%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Equipment</title>
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
            <img class="w-100" id="image"  src="images/home.png" alt="Profile image">
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
            <a href="#" class="nav-link px-0 text-white">
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
                Add Equipment
              </button>
            </div>
            <div class="row">
              <div class=" d-flex justify-content-center ">
                <div class="card shadow mb-4 col-8">
                  <%--                  Card Header - Dropdown ----%>
                  <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Equipments</h6>
                  </div>
                  <%--                  -- Card Body ----%>
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-striped border">
                        <thead class="bg-secondary bg-opacity-25">
                        <tr>
                          <th scope="col">Name</th>
                          <th scope="col">Type</th>
                          <th scope="col">State</th>
                          <th scope="col">reserved by</th>
                          <th scope="col">buyingDate</th>
                          <th scope="col">maintDate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                          <td><p></p></td>
                          <td><p></p></td>
                          <td><p></p></td>
                          <td><p></p></td>
                          <td><p></p></td>
                          <td></td>
                        </tr>
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
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add Equipment</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <form>
         <form action="LoginServlet" method="post">
           <div class="mb-4">
             <label class="form-label">Name</label>
             <input type="text" class="form-control" name="name" required>
           </div>
           <div class="mb-4">
             <label class="form-label">Type</label>
             <input type="text" class="form-control" name="type" required>
           </div>
           <div class="mb-4">
             <label class="form-label">State</label>
             <input type="text" class="form-control" name="state" required>
           </div>
<%--           <div class="mb-4">--%>
<%--             <label class="form-label">Type</label>--%>
<%--             <input type="text" class="form-control" name="type" required>--%>
<%--           </div>--%>

           <button type="submit" class="btn btn-primary">Add</button>
         </form>
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
