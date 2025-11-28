/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AppointmentControllers;

import Configs.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Pasindu
 */
public class FetchAppointments extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ResultSet rs = DBConnection.SEARCH("SELECT * FROM appointment LEFT JOIN packages ON appointment.packages_id = packages.id LEFT JOIN event ON packages.event_id = event.id");
            JSONArray jsonArray = new JSONArray();
            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("id", rs.getString(1));
                jsonObj.put("date", rs.getString(2));
                jsonObj.put("package", rs.getString(5));
                jsonObj.put("note", rs.getString(7));   
                jsonObj.put("name", rs.getString(9));
                jsonArray.add(jsonObj);
            }
            resp.setContentType("application/json");
            out.print(jsonArray.toJSONString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
