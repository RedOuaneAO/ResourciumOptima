<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="bg-primary">
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-6 ">
                <div class="bg-dark text-white rounded">
                    <div class="card-body p-5 text-center">
                        <div class="mb-4"><h3>Register</h3></div>
                        <form action="RegisterServlet" method="post">
                            <div class="mb-4">
                                <label class="form-label">First Name</label>
                                <input type="text" class="form-control" name="fName">
                            </div>
                            <div class="mb-4">
                                <label class="form-label">Second Name</label>
                                <input type="text" class="form-control" name="sName">
                            </div>
                            <div class="mb-4">
                                <label class="form-label">User Name</label>
                                <input type="text"  class="form-control" name="userName">
                            </div>
                            <div class="mb-4">
                                <label class="form-label">Position</label>
                                <select class="form-select" name="position">
                                    <option selected disabled>Position</option>
                                    <option value="Employee">Employee</option>
                                    <option value="Developer">Developer</option>
                                    <option value="Chef">Chef</option>
                                </select>
                            </div>
                            <div class="mb-4">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" name="email">
                            </div>
                            <div class="mb-4">
                                <label class="form-label">Password</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <button type="submit" class="btn btn-primary">Register</button>
                        </form>
                        <div>
                            <p class="mb-0">you have an account? <a href="login.jsp" class="text-white-50 fw-bold">Login</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>