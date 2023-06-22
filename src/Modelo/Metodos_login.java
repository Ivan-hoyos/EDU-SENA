package Modelo;

import Controlador.Controlador_Login;
import Modelo.Conexion;
import Vista.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Vista.Login;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Metodos_login extends Conexion {

    Connection con = getConnection();
    PreparedStatement ps;
    Login login = new Login();
    Estudiantes_Modelo mode = new Estudiantes_Modelo();
    private final Admin admin = new Admin();

    //Método para agregar registros
    public int log(Estudiantes_Modelo log) {
        int r = 1;

        // mode.setContraseña(password);
        String sql = "select id_Estudiante, Nombres, Apellidos,  Contraseña, Rol from estudiantes where id_Estudiante='" + log.getid_Estudiante() + "'";
        if (r == 1) {
            try {

                ps = con.prepareStatement(sql);
                ResultSet rs_Student = ps.executeQuery();

                if (rs_Student.next()) {
                    //Si existe el usuario
                    String us = rs_Student.getString("id_Estudiante");
                    String pass = rs_Student.getString("Contraseña");
                    String rol = rs_Student.getString("Rol");
                    String nombre = rs_Student.getString("Nombres");
                    String apellido = rs_Student.getString("Apellidos");

                    if (log.getContraseña().equals(pass)) {
                        //Jframe alumno, docente o admin

                        if (rol.equals("student")) {
                            ImageIcon icon = new ImageIcon(Metodos_Admin.class.getResource("/Images/tarjetaes.png"));
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema \nEstudiante: " + nombre + " " + apellido + "", "Login", JOptionPane.CLOSED_OPTION, icon);

                        }
                        return 1;
                    } else {
                        //Contraseña incorrecta
                        // JOptionPane.showMessageDialog(null, "Contraseña incorrecta");

                    }
                    return 2;
                } else {
                    //El usuario no existe

                    //JOptionPane.showMessageDialog(null, "El usuario no existe");
                    System.out.println(mode.getContraseña());

                }
                return 3;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        } else {
            return 0;
        }
        return r;
    }

    public int logP(ProfModel log) {
        int r = 1;

        // mode.setContraseña(password);
        String sql = "select id_Profesor, Nombres, Apellidos,  Contraseña, Rol from profesores where id_Profesor='" + log.getId_Profesor() + "'";
        if (r == 1) {
            try {

                ps = con.prepareStatement(sql);
                ResultSet rs_Profesor = ps.executeQuery();

                if (rs_Profesor.next()) {
                    //Si existe el usuario
                    String us = rs_Profesor.getString("id_Profesor");
                    String pas = rs_Profesor.getString("Contraseña");
                    String rol = rs_Profesor.getString("Rol");
                    String nombre = rs_Profesor.getString("Nombres");
                    String apellido = rs_Profesor.getString("Apellidos");

                    if (log.getContraseña().equals(pas)) {
                        //Jframe alumno, docente o admin

                        if (rol.equals("teacher")) {
                            ImageIcon icon = new ImageIcon(Metodos_Admin.class.getResource("/Images/tarjetaes.png"));
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema \nProfesor: " + nombre + " " + apellido + "", "Login", JOptionPane.CLOSED_OPTION, icon);

                        }
                        return 1;
                    } else {
                        //Contraseña incorrecta

                    }
                    return 2;
                } else {
                    //El usuario no existe

                }
                return 3;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        } else {
            return 0;
        }
        return r;
    }
}
