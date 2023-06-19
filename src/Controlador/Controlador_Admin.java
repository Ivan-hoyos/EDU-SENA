package Controlador;

import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_Admin;
import Vista.Admin;
import Vista.Students;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador_Admin implements ActionListener {

    Metodos_Admin mte = new Metodos_Admin(); //Metodos Administrador
    Estudiantes_Modelo mode = new Estudiantes_Modelo(); //Modelo estudiante
    Admin admin = new Admin();
    Students es = new Students();
    DefaultTableModel modelo = new DefaultTableModel();
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

    public void actualizar() {
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
        int r = mte.actualizar(mode);
        if (r == 1) {
            JOptionPane.showMessageDialog(es, "Registro actualizado!!");
        } else {
            JOptionPane.showMessageDialog(es, "Error, intente de nuevo");
        }
    }

    public void eliminar() {
        int fila = es.Tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(es, "Seleccione un Registro");
        } else {
            int doc = Integer.parseInt(es.Tabla.getValueAt(fila, 0).toString());
            mte.eliminar(doc);
            JOptionPane.showMessageDialog(es, "Registro eliminado");
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
            es.setSize(1100, 760);
            admin.Panel_right.removeAll();
            admin.Panel_right.add(es, BorderLayout.CENTER);
            admin.Panel_right.setComponentZOrder(es, 0);
            admin.Panel_right.revalidate();
            admin.Panel_right.repaint();
        } else {
            System.out.println(r);
        }
    }

    /*public void show_table(Students es) {
        int r = mte.show_table(es);
        if (r == 1) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Documento");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            model.addColumn("Fecha Nacimiento");
            model.addColumn("Curso");
            model.addColumn("Sexo");
            es.Tabla.setModel(model);
            
            System.out.println("si");
        }
    }*/
    public void listar(JTable Tabla) {
        modelo = (DefaultTableModel) Tabla.getModel();
        /*modelo.addColumn("Documento");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("Grado");
        modelo.addColumn("Seccion");
        modelo.addColumn("id_Curso");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Rol");
        modelo.addColumn("sexo");*/
        List<Estudiantes_Modelo> lista = mte.listar();
        Object[] object = new Object[13];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getid_Estudiante();
            object[1] = lista.get(i).getNombres();
            object[2] = lista.get(i).getApellidos();
            object[3] = lista.get(i).getFecha_Nacimiento();
            object[4] = lista.get(i).getDireccion();
            object[5] = lista.get(i).getTelefono();
            object[6] = lista.get(i).getEmail();
            object[7] = lista.get(i).getGrado();
            object[8] = lista.get(i).getSeccion();
            object[9] = lista.get(i).getId_Curso();
            object[10] = lista.get(i).getContraseña();
            object[11] = lista.get(i).getRol();
            object[12] = lista.get(i).getSexo();
            modelo.addRow(object);
        }
        es.Tabla.setModel(modelo);
    }

    public void limpiartabla() {
        for (int i = 0; i < es.Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.Estudiantes) {
            limpiartabla();
            listar(es.Tabla);

            show_e();

        }

        if (e.getSource() == es.btn_create) {
            create_Student();
            listar(es.Tabla);
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
