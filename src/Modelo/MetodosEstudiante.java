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

    public void horario() {
        try {
            Connection con = getConnection();
            String consulta = "SELECT H.Dia, H.HoraInicio, H.HoraFin, C.id_Cursos, A.Nombre AS idMateria,  P.id_Profesor, " +
            "P.Nombres AS NombreProfesor FROM Horarios H JOIN Cursos C ON H.idCurso = C.id_Cursos JOIN Profesores P "+
                    "ON H.idProfesor = P.id_Profesor JOIN asignaturas A ON H.idMateria = A.id_Asignatura ORDER BY H.Dia, H.HoraInicio;";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                String dia = resultSet.getString("Dia");
                int horaInicio = resultSet.getInt("HoraInicio");
                int horaFin = resultSet.getInt("HoraFin");
                String idCurso = resultSet.getString("id_Cursos");
                String nombreCurso = resultSet.getString("idMateria");
                long idProfesor = resultSet.getLong("id_Profesor");
                String nombreProfesor = resultSet.getString("NombreProfesor");

                // Aquí puedes utilizar los datos obtenidos para mostrar el horario en la vista general
                System.out.println("Día: " + dia);
                System.out.println("Hora de inicio: " + horaInicio);
                System.out.println("Hora de fin: " + horaFin);
                System.out.println("ID del curso: " + idCurso);
                System.out.println("Nombre del curso: " + nombreCurso);
                System.out.println("ID del profesor: " + idProfesor);
                System.out.println("Nombre del profesor: " + nombreProfesor);
                System.out.println("--------------------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
