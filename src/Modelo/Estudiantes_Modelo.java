package Modelo;

public class Estudiantes_Modelo {

    private int id_Estudiante;
    private String Nombres;
    private String Apellidos;
    private String Fecha_Nacimiento;
    private String Sexo;
    private byte Grado;
    private String Seccion;
    private String Direccion;
    private long Telefono;
    private String Email;
    private String Contraseña;
    private String id_Curso;
    private String Rol;

    
    public Estudiantes_Modelo(){
        
    }

    public Estudiantes_Modelo(int id_Estudiante, String Nombres, String Apellidos, String Fecha_Nacimiento, String Sexo, byte Grado, String Seccion, String Direccion, long Telefono, String Email, String Contraseña, String id_Curso, String Rol) {
        this.id_Estudiante = id_Estudiante;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Sexo = Sexo;
        this.Grado = Grado;
        this.Seccion = Seccion;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.id_Curso = id_Curso;
        this.Rol = Rol;
    }



    public int getid_Estudiante() {
        return id_Estudiante;
    }

    public void setid_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
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

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public byte getGrado() {
        return Grado;
    }

    public void setGrado(byte Grado) {
        this.Grado = Grado;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
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

    public String getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(String id_Curso) {
        this.id_Curso = id_Curso;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    

}
