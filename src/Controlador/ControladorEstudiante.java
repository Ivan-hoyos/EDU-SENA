package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.MetodosEstudiante;
import Modelo.SesionEstudiante;
import Vista.Actualizar_estudiante;
import Vista.Estudiante_log;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorEstudiante implements ActionListener {

    Estudiante_log principal = new Estudiante_log(); //Menu principal 
    Actualizar_estudiante perfil = new Actualizar_estudiante(); // Configuración de Perfil
    Estudiantes_Modelo mode = new Estudiantes_Modelo(); //Modelo estudiante
    MetodosEstudiante metodos = new MetodosEstudiante();
    SesionEstudiante sessionManager = SesionEstudiante.getInstance();

    public ControladorEstudiante(Estudiante_log principal) {
        this.principal.Actividades.addActionListener(this);
        this.principal.Notas.addActionListener(this);
        this.principal.Horarios.addActionListener(this);
        this.principal.perfil.addActionListener(this);
        this.principal.Exit.addActionListener(this);
        this.perfil.btn_modificar.addActionListener(this);
    }

    public void infoEs() {//Información de la sesion
        perfil.Txt_DocumentStudent.setText(Long.toString(sessionManager.getUsername()));
        perfil.Txt_nameStudent.setText(sessionManager.getNombres());
        perfil.Txt_LastNameStudent.setText(sessionManager.getApellidos());
        perfil.Txt_Day_Born.setText(sessionManager.getFecha_Nacimiento());
        perfil.Txt_Direction.setText(sessionManager.getDireccion());
        perfil.Txt_telephone.setText(Long.toString(sessionManager.getTelefono()));
        perfil.Txt_email.setText(sessionManager.getEmail());
        perfil.Txt_password.setText(sessionManager.getPassword());
        String sexo = sessionManager.getSexo();

        if (sexo.equals("M")) {
            perfil.btn_M.setSelected(true);
            perfil.btn_F.setSelected(false);
        } else if (sexo.equals("F")) {
            perfil.btn_F.setSelected(true);
            perfil.btn_M.setSelected(false);
        } else {
            perfil.btn_F.setSelected(false);
            perfil.btn_M.setSelected(false);
        }

    }

    public void modificarI() {//Modificar información del estudiante

        mode.setid_Estudiante(Long.parseLong(perfil.Txt_DocumentStudent.getText()));
        mode.setNombres(perfil.Txt_nameStudent.getText());
        mode.setApellidos(perfil.Txt_LastNameStudent.getText());
        mode.setFecha_Nacimiento(perfil.Txt_Day_Born.getText());
        String sexo = "";
        if (perfil.btn_M.isSelected() == true) {
            sexo = "M";
            perfil.btn_F.setSelected(false);
        } else if (perfil.btn_F.isSelected() == true) {
            sexo = "F";
            perfil.btn_M.setSelected(false);
        }
        mode.setSexo(sexo);

        mode.setDireccion(perfil.Txt_Direction.getText());
        mode.setTelefono(Long.parseLong(perfil.Txt_telephone.getText()));
        mode.setEmail(perfil.Txt_email.getText());
        mode.setContraseña(perfil.Txt_password.getText());
        String id_Curso = mode.getGrado() + mode.getSeccion();
        mode.setId_Curso(id_Curso);
        int r = metodos.modificar(mode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(MetodosEstudiante.class.getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(principal, "Registro actualizado!!", "Actualizado", JOptionPane.CLOSED_OPTION, icon);
        } else {
            JOptionPane.showMessageDialog(principal, "Error, intente de nuevo");
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.perfil) { //Mostrar perfil del estudiante
            perfil.setSize(1100, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(perfil, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(perfil, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            infoEs();
        }

        if (e.getSource() == perfil.btn_modificar) {
            modificarI();
        }

        if (e.getSource() == principal.Exit) { //Cerrar la aplicación
            ImageIcon icon = new ImageIcon(MetodosEstudiante.class
                    .getResource("/Images/exit.png"));
            JOptionPane.showMessageDialog(principal, "Hasta Pronto :D", "Cerrar Sesión", JOptionPane.OK_OPTION, icon);
            System.exit(0);

        }
    }
}
