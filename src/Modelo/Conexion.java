package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Conexion{

    
Connection con;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "");
            System.out.println("Conexión exitosa!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public  Connection getConnection(){
        return con;
    }
}