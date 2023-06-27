/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorProf;
import Vista.ActividadesProf;
import Vista.CrearActividad;
import Vista.Login;
import Vista.ProfLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CPE
 */
public class MetodosProf extends Conexion {

    Login log = new Login();
    ProfLog principal = new ProfLog();
    ActModel amdl = new ActModel();
    CrearActividad cre = new CrearActividad();
    ActividadesProf act = new ActividadesProf();
    SesionProf sessionManager = SesionProf.getInstance();

    //Método para actualizar registros
    public int modificar(ProfModel mdl) {
        int r = 1;
        String sql = "UPDATE profesores SET FechaNacimiento=?, Direccion=?,Telefono=?,Email=?,Contraseña=?,Sexo=? WHERE id_Profesor=?";
        SesionEstudiante sessionManager = SesionEstudiante.getInstance();
        //String username = sessionManager.getUsername();
        //String password = sessionManager.getPassword();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mdl.getFechaNacimiento());
            ps.setString(2, mdl.getDireccion());
            ps.setString(3, Long.toString(mdl.getTelefono()));
            ps.setString(4, mdl.getEmail());
            ps.setString(5, mdl.getContraseña());
            ps.setString(6, mdl.getSexo());
            ps.setString(7, Long.toString(mdl.getId_Profesor()));
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No se pudo modificar");
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    public int Crear(ActModel amdl) { //Metodo para agregar actividades al combo box
        int r = 1;
        String sql = "INSERT INTO actividades  (Titulo, Descripcion, FechaCreacion,ProfesorId, IdCurso,  Materia, IdAsignatura) VALUES (?,?,?,?,?,?,?) ";
        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String curso = act.Box_Cursos.getSelectedItem().toString();
            System.out.println(curso);
            ps.setString(1, amdl.getTitulo());
            ps.setString(2, amdl.getDescripcion());
            ps.setTimestamp(3, amdl.getFechaCreacion());
            ps.setInt(4, (int) sessionManager.getUsername());
            ps.setString(5, amdl.getIdCurso());
            ps.setString(6, amdl.getMateria());
            ps.setInt(7, amdl.getIdMateria());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    public int Modificar(ActModel amdl) { //Metodo para agregar actividades al combo box
        int r = 1;
        String sql = "UPDATE  actividades SET  Titulo=?, Descripcion=?, FechaCreacion=?, Materia=?, IdAsignatura=? WHERE IdActividad=?;";
        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String curso = act.Box_Cursos.getSelectedItem().toString();
            System.out.println(curso);
            ps.setString(1, amdl.getTitulo());
            ps.setString(2, amdl.getDescripcion());
            ps.setTimestamp(3, amdl.getFechaCreacion());
            ps.setString(4, amdl.getMateria());
            ps.setInt(5, amdl.getIdMateria());
            ps.setInt(6, amdl.getIdActividad());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    public int eliminar(ActModel amdl) {
        int r = 1;
        String sql = "DELETE FROM actividades WHERE IdActividad=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, amdl.getIdActividad());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }

}
