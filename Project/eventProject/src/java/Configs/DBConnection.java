/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pasindu
 */
public class DBConnection {

    private static Connection connection;

    public static void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        if (connection == null) {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/event_app", "root", "");
        }
    }

    public static boolean IUD(String query) throws SQLException, ClassNotFoundException {
        getConnection();
        return connection.createStatement().execute(query);
    }

    public static ResultSet SEARCH(String query) throws SQLException, ClassNotFoundException {
        getConnection();
        return connection.createStatement().executeQuery(query);
    }
}
