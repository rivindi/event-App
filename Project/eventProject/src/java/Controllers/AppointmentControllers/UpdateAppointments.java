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
public class UpdateAppointments extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            if (req.getParameter("date") != null && req.getParameter("updateid") != null) {
                System.out.println("UPDATE appointment SET (date='" + req.getParameter("date") + "') WHERE id='" + req.getParameter("updateid") + "'");
                DBConnection.IUD("UPDATE appointment SET date='" + req.getParameter("date") + "' WHERE id=" + req.getParameter("updateid"));
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
