package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_Admin;
import Vista.Admin;
import Vista.Students;
import Vista.create_Student;
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
    create_Student cre = new create_Student();
    private MouseListener l;

    public Controlador_Admin(Admin admin, Students es) {
        this.admin = admin;
        this.es = es;
        this.cre = cre;
        this.mte = mte;
        this.mode = mode;
//        this.admin.Lbl_Students.addMouseListener((MouseListener) this.admin);
        //this.admin.Lbl_Exit.addMouseListener((ActionListener) this);
        this.es.btn_create.addActionListener(this);
        this.es.btn_moficar.addActionListener(this);
        this.es.Btn_Delete.addActionListener(this);
        this.cre.Back.addActionListener(this);
        this.cre.Btn_Save_New.addActionListener(this);
        this.admin.x.addActionListener(this);

    }

    public void create_Student() {
        mode.setid_Estudiante(Long.parseLong(cre.Txt_DocumentStudent.getText()));
        mode.setNombres(cre.Txt_nameStudent.getText());
        mode.setApellidos(cre.Txt_LastNameStudent.getText());
        mode.setFecha_Nacimiento(cre.Txt_Day_Born.getText());
        String sexo = "";
        if (cre.btn_M.isSelected() == true) {
            sexo = "M";
        } else if (cre.btn_F.isSelected() == true) {
            sexo = "F";
        }
        mode.setSexo(sexo);
        mode.setGrado(Byte.parseByte(cre.Box_grade.getSelectedItem().toString()));
        mode.setSeccion(cre.Box_section.getSelectedItem().toString());
        mode.setDireccion(cre.Txt_Direction.getText());
        mode.setTelefono(Long.parseLong(cre.Txt_telephone.getText()));
        mode.setEmail(cre.Txt_email.getText());
        mode.setContraseña(cre.Txt_password.getText());
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
            JOptionPane.showMessageDialog(cre, "Error, intente de nuevo");
        }
    }

    public void exit() {
        int r = mte.exit();
        if (r == 1) {

            System.out.println("nooooooo");
            System.exit(0);

        } else {
            System.out.println("noooooeeoo");
        }
    }

    public void show_e() {
        int r = mte.show_e();
        if (r == 1) {

            System.out.println(1);
            //Students list = new Students();
            es.ventana.removeAll();
            es.setSize(1770, 1180);
            es.setLocation(0, 0);
            admin.Panel_right.removeAll();
            admin.Panel_right.add(es, BorderLayout.CENTER);
            admin.Panel_right.setComponentZOrder(es, 0);
            admin.Panel_right.revalidate();
            admin.Panel_right.repaint();
        } else {
            System.out.println(r);
        }
    }

    public void show_create() {
        int r = mte.show_create();
        if (r == 1) {

            System.out.println(1);

            es.ventana.removeAll();
            es.ventana.add(cre);
            es.ventana.revalidate();
            es.ventana.repaint();
            cre.setVisible(true);
        } else {
            System.out.println(r);
        }
    }

    /*public void mouseClicked(MouseEvent e) {
        if (e.equals(admin.Lbl_Exit)) {
            System.exit(0);
        }

        if (e.equals(admin.Lbl_Students)) {
            //student();
            show_e();
        }
    }*/
    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.x) {

            show_e();

        }

        if (e.getSource() == es.btn_create) {
            show_create();
        }

        if (e.getSource() == cre.Back) {
            show_e();
        }

        if (e.getSource() == cre.Btn_Save_New) {
            create_Student();
        }
    }

}
