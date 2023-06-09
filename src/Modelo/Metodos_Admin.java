
package Modelo;

import Vista.Admin;
import Vista.Students;
import Vista.create_Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Metodos_Admin extends Conexion {

    private final Students students = new Students();//Formulario students
    private final create_Student createStudent = new create_Student();//Formulario create_Student
    Estudiantes_Modelo mdl = new Estudiantes_Modelo();//Modelo estudiantes
    Admin admin = new Admin();//Formulario Admin

    public int create_Student(Estudiantes_Modelo mdl) {//Metodo para crear estudiantes en la bd
        int r = 1;

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
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return r;

    }

    public int exit() {//Metodo para cerrar el programa
        int r = 1;

        if (r == 1) {
            JOptionPane.showMessageDialog(null, "Hasta luego :D");

            return 1;
        } else {
            return 0;
        }

    }

    public int show_e() {//Metodo para mostrar el formulario Student
        int r = 1;
        if (r == 1) {

            return 1;
        } else {
            return 0;
        }
    }

    public int show_create() {//Metodo para mostrar el formulario create_Student
        int r = 1;
        if (r == 1) {

            return 1;
        } else {
            return 0;
        }
    }

}
