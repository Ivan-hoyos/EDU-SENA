/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Admin;
import Vista.Students;
import Vista.create_Student;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Chichona
 */
public class Metodos_Admin extends Conexion {

    private final Students students = new Students();
    private final create_Student createStudent = new create_Student();
    Estudiantes_Modelo mdl = new Estudiantes_Modelo();
    Admin admin = new Admin();

    public int exit(Metodos_Admin ex) {
        int r = 1;

        if (r == 1) {
            JOptionPane.showMessageDialog(null, "Hasta luego :D");

            return 1;
        } else {
            return 0;
        }

    }

    public int create_Student(Estudiantes_Modelo cre) {
        int r = 1;
        if (r == 1) {
            try {

                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO estudiantes (id_Estudiantes, Nombres, Apellidos, Fecha_Nacimiento, Direccion,Telefono, Email, Grado, Seccion ,id_Curso, Contraseña,Sexo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setLong(1, mdl.getid_Estudiante());
                ps.setString(2, mdl.getNombres());
                ps.setString(3, mdl.getApellidos());
                ps.setString(4, mdl.getFecha_Nacimiento());
                ps.setString(5, mdl.getDireccion());
                ps.setLong(6, mdl.getTelefono());
                ps.setString(7, mdl.getEmail());
                ps.setInt(8, mdl.getGrado());
                ps.setString(9, mdl.getSeccion());
                ps.setString(10, mdl.getId_Curso());
                ps.setString(11, mdl.getContraseña());
                ps.setString(12, mdl.getSexo());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");
                return 1;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {
            return 0;
        }
        return r;

    }

    public int show_e(Estudiantes_Modelo e) {
        int r = 1;

        if (r == 1) {
            Students list = new Students();
            list.setSize(1650, 1180);
            list.setLocation(0, 0);
            admin.Panel_right.removeAll();
            admin.Panel_right.add(list, BorderLayout.CENTER);
            //admin.Panel_right.setComponentZOrder(list, 0);
            admin.Panel_right.revalidate();
            admin.Panel_right.repaint();
            return 1;
        }else{
            return 0;
        }


    }
}
