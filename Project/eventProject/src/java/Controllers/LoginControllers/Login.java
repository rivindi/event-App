/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.LoginControllers;

import Configs.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pasindu
 */
public class Login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            if (req.getParameter("un") != null && req.getParameter("pw") != null) {
                ResultSet rs = DBConnection.SEARCH("SELECT * FROM customer WHERE email='" + req.getParameter("un") + "' AND password='" + req.getParameter("pw") + "'");
                if (rs.first()) {
                    req.getSession().setAttribute("uid", rs.getString(1));
                    resp.sendRedirect(req.getHeader("referer"));
                } else {
                    resp.setContentType("application/json");
                    out.print("Wrong Credentials");
                    out.flush();
                }
                
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
