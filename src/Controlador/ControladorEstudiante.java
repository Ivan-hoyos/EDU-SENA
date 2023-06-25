package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.MetodosEstudiante;
import Modelo.SesionEstudiante;
import Vista.ActualizarEs;
import Vista.Estudiante_log;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorEstudiante implements ActionListener {

    Estudiante_log principal = new Estudiante_log(); //Menu principal 
    ActualizarEs perfil = new ActualizarEs(); // Configuración de Perfil
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
        this.perfil.btn_editar.addActionListener(this);
        this.perfil.Btn_cancelar.addActionListener(this);
        this.perfil.btn_F.addActionListener(this);
        this.perfil.btn_M.addActionListener(this);
    }

    public void infoEs() {//Información de la sesion
        perfil.Txt_Document.setText(Long.toString(sessionManager.getUsername()));
        perfil.Txt_name.setText(sessionManager.getNombres());
        perfil.Txt_LastName.setText(sessionManager.getApellidos());
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

        perfil.btn_F.setEnabled(false);
        perfil.btn_M.setEnabled(false);
        perfil.Txt_Document.setEnabled(false);
        perfil.Txt_name.setEnabled(false);
        perfil.Txt_LastName.setEnabled(false);
        perfil.Txt_Day_Born.setEnabled(false);
        perfil.Txt_Direction.setEnabled(false);
        perfil.Txt_telephone.setEnabled(false);
        perfil.Txt_email.setEnabled(false);
        perfil.Txt_password.setEnabled(false);

    }

    public void infonueva() {//Información del estudiante
        int r = metodos.infoactualizada(mode);
        if (r == 1) {

            perfil.Txt_Document.setText(Long.toString(sessionManager.getUsername()));
            perfil.Txt_name.setText(sessionManager.getNombres());
            perfil.Txt_LastName.setText(sessionManager.getApellidos());
            perfil.Txt_Day_Born.setText(mode.getFecha_Nacimiento());
            perfil.Txt_Direction.setText(mode.getDireccion());
            perfil.Txt_telephone.setText(Long.toString(mode.getTelefono()));
            perfil.Txt_email.setText(mode.getEmail());
            perfil.Txt_password.setText(mode.getContraseña());
            String sexo = mode.getSexo();

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
            perfil.Txt_Document.setEnabled(false);
            perfil.Txt_name.setEnabled(false);
            perfil.Txt_LastName.setEnabled(false);
            perfil.Txt_Day_Born.setEnabled(false);
            perfil.Txt_Direction.setEnabled(false);
            perfil.Txt_telephone.setEnabled(false);
            perfil.Txt_email.setEnabled(false);
            perfil.Txt_password.setEnabled(false);
        } else {
            System.out.println("XD");
        }
    }

    public void modificarI() {//Modificar información del estudiante

        mode.setid_Estudiante(Long.parseLong(perfil.Txt_Document.getText()));
        mode.setNombres(perfil.Txt_name.getText());
        mode.setApellidos(perfil.Txt_LastName.getText());
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

        if (e.getSource() == perfil.btn_F) {
            perfil.btn_M.setSelected(false);
        }
        if (e.getSource() == perfil.btn_M) {
            perfil.btn_F.setSelected(false);
        }

        if (e.getSource() == principal.perfil) { //Mostrar perfil del estudiante
            perfil.setSize(1100, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(perfil, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(perfil, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            infoEs();
            infonueva();
            perfil.btn_modificar.setEnabled(false);
            perfil.Btn_cancelar.setEnabled(false);
        }

        if (e.getSource() == perfil.btn_modificar) {
            String npass = perfil.Txt_password.getText();
            System.out.println("Nueva: " + npass);
            if (!npass.equals(sessionManager.getPassword())) {
                String pass = JOptionPane.showInputDialog(null, "Ingresar Contraseña Anterior", "Confirmar Contraseña", JOptionPane.OK_OPTION);

                if (pass.equals(sessionManager.getPassword())) {
                    String passn = JOptionPane.showInputDialog(null, "Ingresar Contraseña Nueva", "Confirmar Contraseña", JOptionPane.OK_OPTION);

                    if (passn.equals(npass)) {
                        modificarI();
                        infonueva();
                        perfil.btn_F.setEnabled(false);
                        perfil.btn_M.setEnabled(false);
                        perfil.Txt_Document.setEnabled(false);
                        perfil.Txt_name.setEnabled(false);
                        perfil.Txt_LastName.setEnabled(false);
                        perfil.Txt_Day_Born.setEnabled(false);
                        perfil.Txt_Direction.setEnabled(false);
                        perfil.Txt_telephone.setEnabled(false);
                        perfil.Txt_email.setEnabled(false);
                        perfil.Txt_password.setEnabled(false);
                        perfil.btn_editar.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO SON COMPATIBLES", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                String pass = JOptionPane.showInputDialog(null, "Ingresar Contraseña", "Confirmar Contraseña", JOptionPane.OK_OPTION);

                if (pass.equals(sessionManager.getPassword())) {
                    modificarI();
                    infonueva();
                    perfil.btn_F.setEnabled(false);
                    perfil.btn_M.setEnabled(false);
                    perfil.Txt_Document.setEnabled(false);
                    perfil.Txt_name.setEnabled(false);
                    perfil.Txt_LastName.setEnabled(false);
                    perfil.Txt_Day_Born.setEnabled(false);
                    perfil.Txt_Direction.setEnabled(false);
                    perfil.Txt_telephone.setEnabled(false);
                    perfil.Txt_email.setEnabled(false);
                    perfil.Txt_password.setEnabled(false);
                    perfil.btn_editar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }

        }

        if (e.getSource() == perfil.btn_editar) {
            perfil.btn_editar.setEnabled(false);
            perfil.btn_modificar.setEnabled(true);
            perfil.Btn_cancelar.setEnabled(true);
            perfil.btn_F.setEnabled(true);
            perfil.btn_M.setEnabled(true);
            perfil.Txt_Day_Born.setEnabled(true);
            perfil.Txt_Direction.setEnabled(true);
            perfil.Txt_telephone.setEnabled(true);
            perfil.Txt_email.setEnabled(true);
            perfil.Txt_password.setEnabled(true);
        }

        if (e.getSource() == perfil.Btn_cancelar) {
            infoEs();
            infonueva();
            perfil.btn_editar.setEnabled(true);
            perfil.btn_modificar.setEnabled(false);
            perfil.Btn_cancelar.setEnabled(false);
        }

        if (e.getSource() == principal.Exit) { //Cerrar la aplicación
            ImageIcon icon = new ImageIcon(MetodosEstudiante.class
                    .getResource("/Images/exit.png"));
            JOptionPane.showMessageDialog(principal, "Hasta Pronto :D", "Cerrar Sesión", JOptionPane.OK_OPTION, icon);
            System.exit(0);

        }
    }
}
