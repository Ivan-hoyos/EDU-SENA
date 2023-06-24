package Modelo;

public class SesionAdmin {

    private static SesionAdmin instance;
    private long username;
    private String password;
    private String Rol;

    private SesionAdmin() {
        // Constructor privado para evitar instanciación externa
    }

    public static synchronized SesionAdmin getInstance() {
        if (instance == null) {
            instance = new SesionAdmin();
        }
        return instance;
    }

    public void setCredentials(long username, String password, String Rol) {
        this.username = username;
        this.password = password;
        this.Rol = Rol;

    }

    public long getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return Rol;
    }

}
