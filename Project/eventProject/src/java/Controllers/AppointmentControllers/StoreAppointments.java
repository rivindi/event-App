/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AppointmentControllers;

import Configs.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pasindu
 */
public class StoreAppointments extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            if (req.getParameter("date") != null && req.getParameter("package") != null) {
                DBConnection.IUD("INSERT INTO appointment (date,packages_id) VALUES ('" + req.getParameter("date") + "','" + req.getParameter("package") + "')");
                resp.sendRedirect(req.getHeader("referer"));
            } else {
                resp.setContentType("application/json");
                out.print("Params cannot be empty");
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
