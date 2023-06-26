package Modelo;

public class SesionEstudiante {

    private static SesionEstudiante instance;
    private int username;
    private String password;
    private String nombres;
    private String apellidos;
    private String Fecha_Nacimiento;
    private String Sexo;
    private String Direccion;
    long Telefono;
    private String Email;
    private String IdCurso;

    private SesionEstudiante() {
        // Constructor privado para evitar instanciación externa
    }

    public static synchronized SesionEstudiante getInstance() {
        if (instance == null) {
            instance = new SesionEstudiante();
        }
        return instance;
    }

    public void setCredentials(int username, String password, String nombres, String apellidos, String Fecha_Nacimiento, String Sexo, String Direccion,
            long Telefono, String Email, String IdCurso) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Sexo = Sexo;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.IdCurso = IdCurso;
    }

    public int getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public long getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public String getIdCurso() {
        return IdCurso;
    }

}
