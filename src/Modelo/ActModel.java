/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

public class ActModel {

    private int IdActividad;
    private String Titulo;
    private String Descripcion;
    private Timestamp FechaCreacion;
    private int ProfesorId;
    private String IdCurso;
    private String Materia;
    private String Respuesta;

    public ActModel() {
    }

    public ActModel(int IdActividad, String Titulo, String Descripcion, Timestamp FechaCreacion, int ProfesorId, String IdCurso, String Materia,
            String Respuesta) {
        this.IdActividad = IdActividad;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.FechaCreacion = FechaCreacion;
        this.ProfesorId = ProfesorId;
        this.IdCurso = IdCurso;
        this.Materia = Materia;
        this.Respuesta = Respuesta;
    }

    public int getIdActividad() {
        return IdActividad;
    }

    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Timestamp getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Timestamp FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public int getProfesorId() {
        return ProfesorId;
    }

    public void setProfesorId(int ProfesorId) {
        this.ProfesorId = ProfesorId;
    }

    public String getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(String IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

}
