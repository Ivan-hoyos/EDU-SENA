package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_login;
import Modelo.ProfModel;
import Vista.Admin;
import Vista.Login;
import Vista.Students;
import Vista.Teachers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADSI
 */
public class Controlador_Login implements ActionListener {

    Admin admin = new Admin();
    Students es = new Students();
    Teachers p = new Teachers();
    Metodos_login mte = new Metodos_login();
    Estudiantes_Modelo mode = new Estudiantes_Modelo();
    ProfModel modep = new ProfModel();
    Login log = new Login();
    Controlador_Admin c = new Controlador_Admin(admin, es);
    private MouseListener l;

    public Controlador_Login(Login log, Admin admin) {
        this.log = log;
        this.mte = mte;
        this.mode = mode;
        this.modep = modep;
        this.log.Btn_Login.addActionListener(this);
    }

    public void log() {
        String pass = new String(log.Password_user.getPassword());
        mode.setid_Estudiante(Long.parseLong(log.Txt_username.getText()));
        mode.setContraseña(pass);

        int r = mte.log(mode);

        if (r == 1) {
            System.out.println("Inicio De sesion Correcto");
            c.fc.setVisible(true);
            log.dispose();
        } else if (r == 2) {
            System.out.println("Contraseña incorrecta");
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
        } else if (r == 3) {
            System.out.println("El usuario no existe");
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        } else {

            JOptionPane.showMessageDialog(log, "Error, intente de nuevo");
        }

    }

    public void logP() {
        String pass = new String(log.Password_user.getPassword());
        modep.setId_Profesor(Long.parseLong(log.Txt_username.getText()));
        modep.setContraseña(pass);
        int r = mte.logP(modep);

        if (r == 1) {
            System.out.println("Inicio De sesion Correcto");
            c.admin.setVisible(true);
            log.dispose();
        } else if (r == 2) {
            System.out.println("Contraseña incorrecta");
            System.out.println(modep.getContraseña());
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
        } else if (r == 3) {
            System.out.println("El usuario no existe");
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        } else {

            JOptionPane.showMessageDialog(log, "Error, intente de nuevo");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log.Btn_Login) {
            String rol = log.Roles.getSelectedItem().toString();
            if (rol.equals("Estudiante")) {
                log();
                System.out.println("");
            }
            if (rol.equals("Profesor")) {
                logP();
            }
            if (log.Roles.getSelectedItem().toString().equals("Administrador")) {
                System.out.println("zd");
            }

            if (log.Roles.getSelectedItem().toString().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Seleccione un Rol","Error",JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
