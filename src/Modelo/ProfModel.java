package Modelo;

public class ProfModel {

    private long id_Profesor;
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    private long Telefono;
    private String Email;
    private String Contraseña;
    private String Rol;
    private int idMateria;
    private String Profesion;

    
    public ProfModel(){
        
    }

    public ProfModel(long id_Profesor, String Nombres, String Apellidos, String Direccion, long Telefono, String Email, String Contraseña, String Rol, int idMateria, String Profesion) {
        this.id_Profesor = id_Profesor;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
        this.idMateria = idMateria;
        this.Profesion = Profesion;
    }

    public long getId_Profesor() {
        return id_Profesor;
    }

    public void setId_Profesor(long id_Profesor) {
        this.id_Profesor = id_Profesor;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    public int getidMateria(){
        return idMateria;
    }
    
    public void setidMateria(int idMateria){
        this.idMateria = idMateria;
    }
    
    public String getProfesion(){
        return Profesion;
    }
    
    public void setProfesion(String Profesion){
        this.Profesion = Profesion;
    }

}
