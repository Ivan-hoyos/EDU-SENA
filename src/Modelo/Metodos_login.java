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
        String sql = "select id_Estudiante, Nombres, Apellidos,Fecha_Nacimiento, Sexo, Direccion, Telefono, Email,  Contraseña, Rol, id_Curso from estudiantes where id_Estudiante='" + log.getid_Estudiante()+ "'";
        if (r == 1) {
            try {

                ps = con.prepareStatement(sql);
                ResultSet rs_Student = ps.executeQuery();

                if (rs_Student.next()) {
                    //Si existe el usuario
                    int user = Integer.parseInt(rs_Student.getString("id_Estudiante"));
                    String pass = rs_Student.getString("Contraseña");
                    String fecha = rs_Student.getString("Fecha_Nacimiento");
                    String Sexo = rs_Student.getString("Sexo");
                    String dir = rs_Student.getString("Direccion");
                    Long tel = Long.parseLong(rs_Student.getString("Telefono"));
                    String email = rs_Student.getString("Email");
                    String rol = rs_Student.getString("Rol");
                    String nombre = rs_Student.getString("Nombres");
                    String apellido = rs_Student.getString("Apellidos");
                    String idCurso = rs_Student.getString("id_Curso");

                    SesionEstudiante sessionManager = SesionEstudiante.getInstance();
                    sessionManager.setCredentials(user, pass, nombre, apellido, fecha, Sexo, dir, tel, email, idCurso);

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
        String sql = "select id_Profesor, Nombres, Apellidos, FechaNacimiento, Sexo, Direccion, Telefono, Email,  Profesion, Contraseña, Rol from profesores where id_Profesor='" + log.getId_Profesor() + "'";
        if (r == 1) {
            try {

                ps = con.prepareStatement(sql);
                ResultSet rs_Profesor = ps.executeQuery();

                if (rs_Profesor.next()) {
                    //Si existe el usuario
                    Long user = Long.valueOf(rs_Profesor.getString("id_Profesor"));
                    String pass = rs_Profesor.getString("Contraseña");
                    String fecha = rs_Profesor.getString("FechaNacimiento");
                    String Sexo = rs_Profesor.getString("Sexo");
                    String dir = rs_Profesor.getString("Direccion");
                    Long tel = Long.valueOf(rs_Profesor.getString("Telefono"));
                    String email = rs_Profesor.getString("Email");
                    String rol = rs_Profesor.getString("Rol");
                    String nombre = rs_Profesor.getString("Nombres");
                    String apellido = rs_Profesor.getString("Apellidos");
                    String profesion = rs_Profesor.getString("Profesion");

                    SesionProf sessionManager = SesionProf.getInstance();
                    sessionManager.setCredentials(user, pass, nombre, apellido, fecha, Sexo, dir, profesion, tel, email);

                    if (log.getContraseña().equals(pass)) {
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

    public int logA(AdminModel log) {
        int r = 1;

        // mode.setContraseña(password);
        String sql = "select id_Admin, Rol, Contraseña from admin where id_Admin='" + log.getIdAdmin() + "'";
        if (r == 1) {
            try {

                ps = con.prepareStatement(sql);
                ResultSet rs_Student = ps.executeQuery();

                if (rs_Student.next()) {
                    //Si existe el usuario
                    Long user = Long.parseLong(rs_Student.getString("id_Admin"));
                    String pass = rs_Student.getString("Contraseña");
                    String rol = rs_Student.getString("Rol");

                    SesionAdmin sessionManager = SesionAdmin.getInstance();
                    sessionManager.setCredentials(user, pass, rol);

                    if (log.getContraseña().equals(pass)) {
                        //Jframe alumno, docente o admin

                        if (rol.equals("admin")) {
                            ImageIcon icon = new ImageIcon(Metodos_Admin.class.getResource("/Images/tarjetaes.png"));
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema \nAdministrador: " + user, "Login", JOptionPane.CLOSED_OPTION, icon);

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
