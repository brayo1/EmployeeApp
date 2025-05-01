/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.resources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Brian
 */

public class DBconnection {

    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?useSSL=false&serverTimezone=UTC",
                "username", "password");
            System.out.println ("Database connection established");
        } catch (SQLException | ClassNotFoundException  e) {
            System.out.println("Database connection Failled "+e.getMessage());
        }
        return connection;
    }
}