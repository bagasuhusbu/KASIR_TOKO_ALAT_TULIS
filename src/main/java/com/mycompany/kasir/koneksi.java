/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class koneksi {
    private static koneksi instance;
    private Connection connection;

    private koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kasir";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Koneksi gagal!");
            System.out.println(ex.getMessage());
        }
    }

    public static koneksi getInstance() {
        if (instance == null) {
            instance = new koneksi();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}