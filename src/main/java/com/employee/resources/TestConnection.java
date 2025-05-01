/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.resources;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Brian
 */
public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedb?useSSL=false&serverTimezone=UTC",
                "root", "password");
            System.out.println("Connection successful");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
