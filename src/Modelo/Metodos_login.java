package Modelo;

import Controlador.Controlador_Login;
import Modelo.Conexion;
import Vista.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Vista.Login;
import java.sql.SQLException;
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
        String sql = "select id_Estudiantes, Nombres, Apellidos,  Contraseña, Rol from estudiantes where id_Estudiantes='"+log.getid_Estudiante()+"'";
        if (r == 1) {
            try {

                ps = con.prepareStatement(sql);
                ResultSet rs_Student = ps.executeQuery();

                if (rs_Student.next()) {
                    //Si existe el usuario
                    String us = rs_Student.getString("id_Estudiantes");
                    String pass = rs_Student.getString("Contraseña");
                    String rol = rs_Student.getString("Rol");
                    String nombre = rs_Student.getString("Nombres");
                    String apellido = rs_Student.getString("Apellidos");

                    if (log.getContraseña().equals(pass)) {
                        //Jframe alumno, docente o admin

                        if (rol.equals("student")) {
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema \nEstudiante: " + nombre + " " + apellido + "", "Login", JOptionPane.CLOSED_OPTION);

                            admin.setVisible(true);
                            login.dispose();

                        }

                    } else {
                        //Contraseña incorrecta
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");

                    }

                } else {
                    //El usuario no existe

                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                    System.out.println(mode.getContraseña());

                }
                return 1;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        } else {
            return 0;
        }
        return r;
    }
}
