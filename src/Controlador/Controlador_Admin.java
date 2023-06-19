package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_Admin;
import Vista.Admin;
import Vista.Students;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controlador_Admin implements ActionListener {

    Metodos_Admin mte = new Metodos_Admin(); //Metodos Administrador
    Estudiantes_Modelo mode = new Estudiantes_Modelo(); //Modelo estudiante
    Admin admin = new Admin();
    Students es = new Students();
    private MouseListener l;

    public Controlador_Admin(Admin admin, Students es) {
        this.admin = admin;
        this.es = es;
        this.mte = mte;
        this.mode = mode;
//        this.admin.Lbl_Students.addMouseListener((MouseListener) this.admin);
        //this.admin.Lbl_Exit.addMouseListener((ActionListener) this);
        this.admin.Estudiantes.addActionListener(this);
        this.admin.Profesores.addActionListener(this);
        this.admin.Cursos.addActionListener(this);
        this.admin.Horarios.addActionListener(this);
        this.admin.Exit.addActionListener(this);
        this.es.btn_create.addActionListener(this);
        this.es.btn_moficar.addActionListener(this);
        this.es.Btn_Delete.addActionListener(this);

    }

    public void create_Student() {
        mode.setid_Estudiante(Long.parseLong(es.Txt_DocumentStudent.getText()));
        mode.setNombres(es.Txt_nameStudent.getText());
        mode.setApellidos(es.Txt_LastNameStudent.getText());
        mode.setFecha_Nacimiento(es.Txt_Day_Born.getText());
        String sexo = "";
        if (es.btn_M.isSelected() == true) {
            sexo = "M";
        } else if (es.btn_F.isSelected() == true) {
            sexo = "F";
        }
        mode.setSexo(sexo);
        mode.setGrado(Byte.parseByte(es.Box_grade.getSelectedItem().toString()));
        mode.setSeccion(es.Box_section.getSelectedItem().toString());
        mode.setDireccion(es.Txt_Direction.getText());
        mode.setTelefono(Long.parseLong(es.Txt_telephone.getText()));
        mode.setEmail(es.Txt_email.getText());
        mode.setContraseña(es.Txt_password.getText());
        String id_Curso = mode.getGrado() + mode.getSeccion();
        mode.setId_Curso(id_Curso);
        int r = mte.create_Student(mode);
        if (r == 1) {
            System.out.println(mode.getid_Estudiante());
            System.out.println(mode.getNombres());
            System.out.println(mode.getApellidos());
            System.out.println(mode.getFecha_Nacimiento());
            System.out.println(mode.getSexo());
            System.out.println(mode.getContraseña());

        } else {
            JOptionPane.showMessageDialog(es, "Error, intente de nuevo");
        }
    }

    public void exit() {//Metodo para cerrar el programa
        int r = 1;
        if (r == 1) {

            JOptionPane.showMessageDialog(null, "Hasta luego :D");
            System.exit(0);

        } else {
            System.out.println("Error");
        }
    }

    public void show_e() {//Metodo para mostrar el formulario Student
        int r = mte.show_e();
        if (r == 1) {
           
            admin.Panel_right.removeAll();
            admin.Panel_right.add(es, BorderLayout.CENTER);
            admin.Panel_right.setComponentZOrder(es, 0);
            admin.Panel_right.revalidate();
            admin.Panel_right.repaint();
        } else {
            System.out.println(r);
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.Estudiantes) {

            show_e();

        }

        if (e.getSource() == admin.Profesores) {
            JOptionPane.showMessageDialog(admin, "Profesores");
        }

        if (e.getSource() == admin.Cursos) {
            JOptionPane.showMessageDialog(admin, "Cursos");
        }

        if (e.getSource() == admin.Horarios) {
            JOptionPane.showMessageDialog(admin, "Horarios");
        }
         if (e.getSource() == admin.Exit) {
           exit();
        }
    }

}
