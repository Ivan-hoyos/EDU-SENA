package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.MetodosEstudiante;
import Modelo.MetodosProf;
import Modelo.ProfModel;
import Modelo.SesionEstudiante;
import Modelo.SesionProf;
import Vista.ActualizarProf;
import Vista.Actualizar_estudiante;
import Vista.Estudiante_log;
import Vista.ProfLog;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorProf implements ActionListener {

    ProfLog principal = new ProfLog(); //Menu principal 
    ActualizarProf perfil = new ActualizarProf(); // Configuración de Perfil
    ProfModel modeP = new ProfModel(); //Modelo profesor
    MetodosProf metodosP = new MetodosProf();
    SesionProf sessionManager = SesionProf.getInstance();

    public ControladorProf(ProfLog principal) {
        this.principal.Actividades.addActionListener(this);
        this.principal.Notas.addActionListener(this);
        this.principal.Horarios.addActionListener(this);
        this.principal.perfil.addActionListener(this);
        this.principal.Exit.addActionListener(this);
        this.perfil.btn_modificar.addActionListener(this);
        this.perfil.btn_editar.addActionListener(this);
        this.perfil.Btn_cancelar.addActionListener(this);
    }

    public void infoP() {//Información de la sesion
        perfil.Txt_DocumentP.setText(Long.toString(sessionManager.getUsername()));
        perfil.Txt_nameP.setText(sessionManager.getNombres());
        perfil.Txt_LastNameP.setText(sessionManager.getApellidos());
        perfil.Txt_Day_Born.setText(sessionManager.getFecha_Nacimiento());
        perfil.Txt_Direction.setText(sessionManager.getDireccion());
        perfil.Txt_telephone.setText(Long.toString(sessionManager.getTelefono()));
        perfil.Txt_email.setText(sessionManager.getEmail());
        perfil.Txt_password.setText(sessionManager.getPassword());
        perfil.Materia.setSelectedItem(sessionManager.getProfesion());
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
        perfil.btn_F.setEnabled(false);
        perfil.btn_M.setEnabled(false);
        perfil.Txt_DocumentP.setEnabled(false);
        perfil.Txt_nameP.setEnabled(false);
        perfil.Txt_LastNameP.setEnabled(false);
        perfil.Txt_Day_Born.setEnabled(false);
        perfil.Txt_Direction.setEnabled(false);
        perfil.Txt_telephone.setEnabled(false);
        perfil.Txt_email.setEnabled(false);
        perfil.Txt_password.setEnabled(false);
        perfil.Materia.setEnabled(false);
        //metodosP.horario();
    }

    public void modificarI() {//Modificar información del estudiante

        modeP.setId_Profesor(Long.parseLong(perfil.Txt_DocumentP.getText()));
        modeP.setNombres(perfil.Txt_nameP.getText());
        modeP.setApellidos(perfil.Txt_LastNameP.getText());
        modeP.setFechaNacimiento(perfil.Txt_Day_Born.getText());
        String sexo = "";
        if (perfil.btn_M.isSelected() == true) {
            sexo = "M";
            perfil.btn_F.setSelected(false);
        } else if (perfil.btn_F.isSelected() == true) {
            sexo = "F";
            perfil.btn_M.setSelected(false);
        }
        modeP.setSexo(sexo);
        String profesion = (String) perfil.Materia.getSelectedItem();
        modeP.setProfesion(profesion);

        modeP.setDireccion(perfil.Txt_Direction.getText());
        modeP.setTelefono(Long.parseLong(perfil.Txt_telephone.getText()));
        modeP.setEmail(perfil.Txt_email.getText());
        modeP.setContraseña(perfil.Txt_password.getText());
        int r = metodosP.modificar(modeP);
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
            infoP();
        }

        if (e.getSource() == perfil.btn_modificar) {
            modificarI();
            perfil.btn_F.setEnabled(false);
            perfil.btn_M.setEnabled(false);
            perfil.Txt_DocumentP.setEnabled(false);
            perfil.Txt_nameP.setEnabled(false);
            perfil.Txt_LastNameP.setEnabled(false);
            perfil.Txt_Day_Born.setEnabled(false);
            perfil.Txt_Direction.setEnabled(false);
            perfil.Txt_telephone.setEnabled(false);
            perfil.Txt_email.setEnabled(false);
            perfil.Txt_password.setEnabled(false);
            perfil.Materia.setEnabled(false);

        }

        if (e.getSource() == perfil.btn_editar) {
            perfil.btn_F.setEnabled(true);
            perfil.btn_M.setEnabled(true);
            //perfil.Txt_DocumentP.setEnabled(true);
            //perfil.Txt_nameP.setEnabled(true);
            //perfil.Txt_LastNameP.setEnabled(true);
            perfil.Txt_Day_Born.setEnabled(true);
            perfil.Txt_Direction.setEnabled(true);
            perfil.Txt_telephone.setEnabled(true);
            perfil.Txt_email.setEnabled(true);
            perfil.Txt_password.setEnabled(true);
            perfil.Materia.setEnabled(true);
        }

        if (e.getSource() == perfil.Btn_cancelar) {
            infoP();
        }

        if (e.getSource() == principal.Exit) { //Cerrar la aplicación
            ImageIcon icon = new ImageIcon(MetodosEstudiante.class
                    .getResource("/Images/exit.png"));
            JOptionPane.showMessageDialog(principal, "Hasta Pronto :D", "Cerrar Sesión", JOptionPane.OK_OPTION, icon);
            System.exit(0);

        }
    }
}
