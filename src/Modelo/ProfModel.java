package Modelo;

public class ProfModel {

    private long id_Profesor;
    private String Nombres;
    private String Apellidos;
    private String fechaNacimiento;
    private String Direccion;
    private long Telefono;
    private String Email;
    private String Contraseña;
    private String Rol;
    private String Profesion;
    private String Sexo;
    String idCurso;
    int IdMateria;

    public ProfModel() {

    }

    public ProfModel(long id_Profesor, String Nombres, String Apellidos, String fechaNacimiento, String Direccion, long Telefono, String Email, String Contraseña, String Rol, String Profesion, String Sexo,
            String idCurso, int IdMateria) {
        this.id_Profesor = id_Profesor;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
        this.Profesion = Profesion;
        this.Sexo = Sexo;
        this.idCurso = idCurso;
        this.IdMateria = IdMateria;

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

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getidCurso() {
        return idCurso;
    }
    
    public void setidCurso(String idCurso){
        this.idCurso = idCurso;
    }


    public int getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(int IdMateria) {
        this.IdMateria = IdMateria;
    }
    

}
