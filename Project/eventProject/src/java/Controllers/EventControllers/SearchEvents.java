/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.EventControllers;

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

public class SearchEvents extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ResultSet rs = DBConnection.SEARCH("SELECT * FROM event");
            JSONArray jsonArray = new JSONArray();
            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("id", rs.getString(1));
                jsonObj.put("name", rs.getString(2));
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
