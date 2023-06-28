/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author CPE
 */
public class MetodosEstudiante extends Conexion {

    Login log = new Login();
    SesionEstudiante sessionManager = SesionEstudiante.getInstance();
    Estudiantes_Modelo model = new Estudiantes_Modelo();

    //Método para actualizar registros
    public int modificar(Estudiantes_Modelo mdl) {
        int r = 1;
        String sql = "UPDATE estudiantes SET Fecha_Nacimiento=?, Direccion=?,Telefono=?,Email=?,Contraseña=?,Sexo=? WHERE id_Estudiante=?";
        SesionEstudiante sessionManager = SesionEstudiante.getInstance();
        //String username = sessionManager.getUsername();
        //String password = sessionManager.getPassword();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mdl.getFecha_Nacimiento());
            ps.setString(2, mdl.getDireccion());
            ps.setString(3, Long.toString(mdl.getTelefono()));
            ps.setString(4, mdl.getEmail());
            ps.setString(5, mdl.getContraseña());
            ps.setString(6, mdl.getSexo());
            ps.setString(7, Long.toString(mdl.getid_Estudiante()));
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No se pudo modificar");
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    public int infoactualizada(Estudiantes_Modelo mdl) {
        int r = 1;
        String sql = "select id_Estudiante, Nombres, Apellidos,Fecha_Nacimiento, Sexo, Direccion, Telefono, Email,  Contraseña, Rol from estudiantes where id_Estudiante='" + sessionManager.getUsername() + "'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
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

                mdl.setFecha_Nacimiento(fecha);
                mdl.setSexo(Sexo);
                mdl.setDireccion(dir);
                mdl.setTelefono(tel);
                mdl.setEmail(email);
                mdl.setContraseña(pass);
                r = 1;
            }

        } catch (SQLException e) {
            System.out.println(e);
            r = 0;
        }
        return r;

    }

    public int responder(ActModel mdl) {
        int r = 1;
        String sql = "INSERT INTO respuestas(IdActividad, IdEstudiante, NombreEstudiante, IdCurso, Respuesta, FechaEnvio, Titulo, Periodo) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mdl.getIdActividad());
            ps.setInt(2, sessionManager.getUsername());
            ps.setString(3, sessionManager.getNombres());
            ps.setString(4, sessionManager.getIdCurso());
            ps.setString(5, mdl.getRespuesta());
            ps.setTimestamp(6, mdl.getFechaCreacion());
            ps.setString(7, mdl.getTitulo());
            ps.setInt(8, mdl.getPeriodo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }

}
