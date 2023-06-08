/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_Admin;
import Vista.Admin;
import Vista.Students;
import Vista.create_Student;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Chichona
 */
public class Controlador_Admin implements ActionListener, MouseListener {

    Metodos_Admin mte = new Metodos_Admin();
    Estudiantes_Modelo mode = new Estudiantes_Modelo();
    Admin admin = new Admin();
    Students es = new Students();
    create_Student cre = new create_Student();
    private MouseListener l;

    public Controlador_Admin(Admin admin) {
        this.admin = admin;
        this.es = es;
        this.cre = cre;
        this.mte = mte;
        this.mode = mode;
        this.admin.Lbl_Students.addMouseListener(this);
        this.admin.Lbl_Exit.addMouseListener(this);
        this.es.btn_create.addActionListener(this);
        this.es.btn_moficar.addActionListener(this);
        this.es.Btn_Delete.addActionListener(this);
        this.cre.Back.addActionListener(this);
        this.cre.Btn_Save_New.addActionListener(this);

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
            System.out.println(mode.getContraseña());

        } else {
            JOptionPane.showMessageDialog(cre, "Error, intente de nuevo");
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void show_e() {
   int r = mte.show_e(mode);
   if(r==1){
       System.out.println(1);
   }
    }

    @Override
    //public void mouseClicked(MouseEvent e) {
    public void mouseClicked(MouseEvent e) {
        if (e.equals(admin.Lbl_Exit)) {
            System.exit(0);
        }

        if (e.equals(admin.Lbl_Students)) {
            //student();
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == admin.x){
            show_e();
           
        }
    }

    @Override
    /*public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

   
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
