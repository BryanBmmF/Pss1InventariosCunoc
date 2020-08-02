/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bryan
 */
public class Conexion {

    protected static Connection conexion = null;

    private final String driver, url, user, password, dataBase;

    private Conexion() {
        driver = "com.mysql.jdbc.Driver";
        dataBase = "inventario";
        url = "jdbc:mysql://localhost:3306/" + dataBase + "?autoReconnect=true&useSSL=false";
        user = "root";
        password = "Password123#@!";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("SE COMUNICO CON LA BASE DE DATOS");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {
        if (conexion == null) {
            new Conexion();
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
