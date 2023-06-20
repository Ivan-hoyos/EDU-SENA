package Modelo;

import Modelo.Estudiantes_Modelo;
import Vista.Admin;
import Vista.Students;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Metodos_Admin extends Conexion {

    private final Students students = new Students();//Formulario students
    Estudiantes_Modelo mdl = new Estudiantes_Modelo();//Modelo estudiantes
    ProfModel pmdl = new ProfModel();//Modelo Profesor
    Admin admin = new Admin();//Formulario Admin

    //////////////////Estudiantes \\\\\\\\\\\\\\\\\\\\\\\\\\\
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

                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return r;

    }

    //Método para actualizar registros
    public int modificar(Estudiantes_Modelo mdl) {
        int r = 1;
        String sql = "UPDATE estudiantes SET Nombres=?, Apellidos=?, Fecha_Nacimiento=?, Direccion=?,Telefono=?,Email=?,Grado=?,Seccion=?,id_Curso=?,Contraseña=?,Sexo=? WHERE id_Estudiantes=?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mdl.getNombres());
            ps.setString(2, mdl.getApellidos());
            ps.setString(3, mdl.getFecha_Nacimiento());
            ps.setString(4, Long.toString(mdl.getTelefono()));
            ps.setString(5, mdl.getEmail());
            ps.setString(6, Integer.toString(mdl.getGrado()));
            ps.setString(7, mdl.getSeccion());
            ps.setString(8, mdl.getId_Curso());
            ps.setString(9, mdl.getContraseña());
            ps.setString(10, mdl.getSexo());
            ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión");
        }
        return r;
    }

    //Método para eliminar registro por documento
    public void eliminar(int doc) {
        String sql = "DELETE FROM estudiantes WHERE id_Estudiantes = " + doc;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se pudo establecer la conexión");
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

    public List listar() {

        String sql = "select * from estudiantes";
        List<Estudiantes_Modelo> lista = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                mdl.setid_Estudiante(rs.getLong(1));
                mdl.setNombres(rs.getString(2));
                mdl.setApellidos(rs.getString(3));
                mdl.setFecha_Nacimiento(rs.getString(4));
                mdl.setDireccion(rs.getString(5));
                mdl.setTelefono(rs.getLong(6));
                mdl.setEmail(rs.getString(7));
                mdl.setGrado(rs.getByte(8));
                mdl.setSeccion(rs.getString(9));
                mdl.setId_Curso(rs.getString(10));
                mdl.setContraseña(rs.getString(11));
                mdl.setRol(rs.getString(12));
                mdl.setSexo(rs.getString(13));
                lista.add(mdl);
            }
        } catch (Exception e) {
            System.out.println("No se pudo establecer conexión");
        }
        return lista;
    }

    //////////////////Profesores \\\\\\\\\\\\\\\\\\\\\\\\\\\
    public int createProf(ProfModel pmdl) {//Metodo para crear profesores en la bd
        int r = 1;

        try {

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO profesores (id_Profesor, Nombres, Apellidos, Direccion,Telefono, Email, Contraseña) VALUES (?,?,?,?,?,?,?)");

            ps.setLong(1, pmdl.getId_Profesor());
            ps.setString(2, pmdl.getNombres());
            ps.setString(3, pmdl.getApellidos());
            ps.setString(4, pmdl.getDireccion());
            ps.setLong(5, pmdl.getTelefono());
            ps.setString(6, pmdl.getEmail());
            ps.setString(7, pmdl.getContraseña());
            ps.executeUpdate();
            if (r == 1) {

                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return r;

    }
}
