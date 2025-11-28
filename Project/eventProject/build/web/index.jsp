<%-- 
    Document   : index
    Created on : 12 May, 2020, 12:19:18 AM
    Author     : Pasindu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="CSS/navi.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <%
            if (request.getSession().getAttribute("uid")!=null) {
        %>
        <input type="checkbox" id="check">
        <label for="check">
            <i class="fas fa-bars" id="btn"></i>
            <i class="fas fa-times-circle" id="cancel"></i>
        </label>
        <div class="sidebar">
            <header>Category</header>
            <ul>
                <li><a href="Home.jsp"><i class="fas fa-home"></i>Home</a></li>
                <li><a href="#"><i class="fas fa-users"></i>Profile</a></li>
                <li><a href="event.jsp"><i class="fas fa-calendar-week"></i>Events</a></li>
                <li><a href="#"><i class="fas fa-address-card"></i>About</a></li>
                <li><a href="#"><i class="fas fa-phone"></i>Contact</a></li>
            </ul>
        </div>
        <section></section>
        <%
        } else {
        %>
        <section>
            <div class="col-md-12">
                <div class="row justify-content-center">
                    <div class="col-md-3">
                        <form action="Login" method="POST">
                            <div class="card mt-5">
                                <div class="card-body">
                                    <h4>Login</h4>
                                    <hr>
                                    <label>Username</label>
                                    <br>
                                    <input type="text" name="un" class="form-control">
                                    <br>
                                    <label>Password</label>
                                    <input type="password" name="pw" class="form-control">
                                    <br>
                                    <input type="submit" value="Login" class="btn btn-primary">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <%
            }
        %>


        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
