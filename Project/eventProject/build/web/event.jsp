<%-- 
    Document   : event
    Created on : 12 May, 2020, 3:17:17 AM
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
            if (request.getSession().getAttribute("uid") == null) {
                response.sendRedirect("index.jsp");
            }
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
        <section>
            <div class="row pt-5">
                <div class="col-md-3"></div>
                <div class="col-md-7">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-4">
                                    <form action="StoreAppointments" id="formtag1">
                                        <label>Date</label>
                                        <input class="form-control" required="" placeholder="Date" type="date" name="date" id="datefield">
                                        <br>
                                        <label>Event</label>
                                        <select class="form-control" id="eventslist" onchange="getPackages()">
                                        </select>
                                        <br>
                                        <label>Package</label>
                                        <select class="form-control" required="" name="package" id="packageslist">
                                        </select>
                                        <br>
                                        <input type="hidden" value="" id="updateId" name="updateid">
                                        <br>
                                        <button type="submit" class="btn btn-danger w-100" id="submitbtn">Save</button>
                                    </form>
                                </div>
                                <div class="col-md-8">
                                    <div class="table-responsive w-100">
                                        <table class="table">
                                            <tr>
                                                <th>Event</th>
                                                <th>Package</th>
                                                <th>Price</th>
                                            </tr>
                                            <tbody id="dataList1">
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <br>
                                    <hr>
                                    <div class="table-responsive w-100 mt-5">
                                        <h5>Appointments</h5>
                                        <table class="table">
                                            <tr>
                                                <th>Date</th>
                                                <th>Event</th>
                                                <th>Package</th>
                                                <th>Price</th>
                                                <th>Delete</th>
                                                <th>Update</th>
                                            </tr>
                                            <tbody id="dataList">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <script>
                                            getAllEvents();
                                            getAllData();
                                            getPackageViewData();
                                            
                                            function getAllEvents() {
                                                var xhttp = new XMLHttpRequest();
                                                xhttp.onreadystatechange = function () {
                                                    if (this.readyState == 4 && this.status == 200) {
                                                        var arrEvents = JSON.parse(xhttp.responseText);
                                                        for (var i = 0; i < arrEvents.length; i++) {
                                                            var obj = arrEvents[i];
                                                            var newOption = document.createElement("option");
                                                            newOption.innerHTML = obj.name;
                                                            newOption.setAttribute("value", obj.id);
                                                            document.getElementById("eventslist").appendChild(newOption);
                                                        }
                                                        getPackages();
                                                    }
                                                };
                                                xhttp.open("GET", "SearchEvents", true);
                                                xhttp.send();
                                            }

                                            function getPackages() {
                                                document.getElementById("packageslist").innerHTML = "";
                                                document.getElementById("dataList1").innerHTML = "";
                                                var xhttp = new XMLHttpRequest();
                                                xhttp.onreadystatechange = function () {
                                                    if (this.readyState == 4 && this.status == 200) {
                                                        var arrEvents = JSON.parse(xhttp.responseText);
                                                        for (var i = 0; i < arrEvents.length; i++) {
                                                            var obj = arrEvents[i];
                                                            var newOption = document.createElement("option");
                                                            newOption.innerHTML = obj.name;
                                                            newOption.setAttribute("value", obj.id);
                                                            document.getElementById("packageslist").appendChild(newOption);

                                                            var newTr = document.createElement("tr");
                                                            var newtd1 = document.createElement("td");
                                                            var newtd2 = document.createElement("td");
                                                            var newtd3 = document.createElement("td");
                                                            newtd1.innerHTML = obj.id;
                                                            newtd2.innerHTML = obj.name;
                                                            newtd3.innerHTML = obj.note;
                                                            newTr.appendChild(newtd1);
                                                            newTr.appendChild(newtd2);
                                                            newTr.appendChild(newtd3);

                                                            document.getElementById("dataList1").appendChild(newTr);
                                                        }
                                                    }
                                                };
                                                xhttp.open("GET", "FindPackages?eid=" + document.getElementById("eventslist").value, true);
                                                xhttp.send();
                                            }

                                            function getAllData() {
                                                document.getElementById("dataList").innerHTML = "";
                                                var xhttp = new XMLHttpRequest();
                                                xhttp.onreadystatechange = function () {
                                                    if (this.readyState == 4 && this.status == 200) {
                                                        var arrEvents = JSON.parse(xhttp.responseText);
                                                        for (var i = 0; i < arrEvents.length; i++) {
                                                            var obj = arrEvents[i];
                                                            var newTr = document.createElement("tr");
                                                            var newtd1 = document.createElement("td");
                                                            var newtd2 = document.createElement("td");
                                                            var newtd3 = document.createElement("td");
                                                            var newtd4 = document.createElement("td");
                                                            var newtd5 = document.createElement("td");
                                                            var newtd6 = document.createElement("td");
                                                            newtd1.innerHTML = obj.date;
                                                            newtd2.innerHTML = obj.name;
                                                            newtd3.innerHTML = obj.package;
                                                            newtd4.innerHTML = obj.note;
                                                            newtd5.innerHTML = "<input type='button' class='btn btn-danger' onclick='deleteAppointmentts(" + obj.id + ")' value='Delete'>";
                                                            newtd6.innerHTML = "<input type='button' class='btn btn-warning' onclick='editAppointmentts(" + obj.id + ")' value='Update'>";
                                                            newTr.appendChild(newtd1);
                                                            newTr.appendChild(newtd2);
                                                            newTr.appendChild(newtd3);
                                                            newTr.appendChild(newtd4);
                                                            newTr.appendChild(newtd5);
                                                            newTr.appendChild(newtd6);

                                                            document.getElementById("dataList").appendChild(newTr);
                                                        }
                                                    }
                                                };
                                                xhttp.open("GET", "FetchAppointments?eid", true);
                                                xhttp.send();
                                            }

                                            function deleteAppointmentts(id) {
                                                var xhttp = new XMLHttpRequest();
                                                xhttp.onreadystatechange = function () {
                                                    if (this.readyState == 4 && this.status == 200) {
                                                        getAllData();
                                                    }
                                                };
                                                xhttp.open("GET", "DeleteAppointments?id=" + id, true);
                                                xhttp.send();
                                            }

                                            function editAppointmentts(id) {
                                                document.getElementById("submitbtn").innerHTML = "Update";
                                                document.getElementById("formtag1").setAttribute("action", "UpdateAppointments");
                                                document.getElementById("updateId").value=id;
                                                alert("Please select date now and click update");

                                            }
        </script>
    </body>
</html>
