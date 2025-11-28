/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.PackageControllers;

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
public class FindPackages extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if (req.getParameter("eid") != null) {
            try {
                ResultSet rs = DBConnection.SEARCH("SELECT * FROM packages WHERE event_id=" + req.getParameter("eid"));
                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("id", rs.getString(1));
                    jsonObj.put("name", rs.getString(2));
                    jsonObj.put("note", rs.getString("note"));
                    jsonArray.add(jsonObj);
                }
                resp.setContentType("application/json");
                out.print(jsonArray.toJSONString());
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resp.setContentType("application/json");
            out.print("Params cannot be empty");
            out.flush();
        }
    }

}
