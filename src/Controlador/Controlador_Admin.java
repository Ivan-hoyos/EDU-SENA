package Controlador;

import Modelo.Conexion;
import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_Admin;
import Modelo.ProfModel;
import Vista.Admin;
import Vista.Students;
import Vista.Teachers;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Admin implements ActionListener {

    Metodos_Admin mte = new Metodos_Admin(); //Metodos Administrador
    Estudiantes_Modelo mode = new Estudiantes_Modelo(); //Modelo estudiante
    ProfModel pmode = new ProfModel(); //Modelo profesor
    Admin admin = new Admin();
    Students es = new Students();
    Teachers p = new Teachers();
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
        this.admin.Estudiantes.addMouseListener(l);
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
            JOptionPane.showMessageDialog(null, "Registro guardado");

        } else {
            JOptionPane.showMessageDialog(es, "Error, intente de nuevo");
        }
    }

    public void modificar() {
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
        int r = mte.modificar(mode);
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

    public void show_p() {//Metodo para mostrar el formulario Profesor

        p.setSize(1100, 760);
        admin.Panel_right.removeAll();
        admin.Panel_right.add(p, BorderLayout.CENTER);
        admin.Panel_right.setComponentZOrder(p, 0);
        admin.Panel_right.revalidate();
        admin.Panel_right.repaint();

    }

    public void showtable() {

        DefaultTableModel ModeloTabla = (DefaultTableModel) es.Tabla.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection con = mte.getConnection();

            ps = con.prepareStatement("Select id_Estudiante, Nombres, Apellidos,Fecha_Nacimiento, id_Curso FROM estudiantes");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                ModeloTabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void limpiartabla() {
        for (int i = 0; i < es.Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarcajas() {
        es.Txt_DocumentStudent.setText(null);
        es.Txt_nameStudent.setText(null);
        es.Txt_LastNameStudent.setText(null);
        es.Txt_Day_Born.setText(null);

        ButtonGroup sex = new ButtonGroup();
        sex.add(es.btn_F);
        sex.add(es.btn_M);
        sex.clearSelection();

        es.Txt_Direction.setText(null);
        es.Txt_telephone.setText(null);
        es.Txt_email.setText(null);
        es.Box_grade.setSelectedItem(null);
        es.Box_section.setSelectedItem(null);
        es.Txt_password.setText(null);
        es.Txt_DocumentStudent.requestFocus();
    }

    ////////////////////////////////////////////////////////////////////////////Profesores
    public void createProf() {
        pmode.setId_Profesor(Long.parseLong(p.Txt_Documentp.getText()));
        pmode.setNombres(p.Txt_namep.getText());
        pmode.setApellidos(p.Txt_LastNamep.getText());
        pmode.setDireccion(p.Txt_Directionp.getText());
        pmode.setTelefono(Long.parseLong(p.Txt_telephonep.getText()));
        pmode.setEmail(p.Txt_emailp.getText());
        pmode.setContraseña(p.Txt_passwordp.getText());
        int r = mte.createProf(pmode);
        if (r == 1) {
            JOptionPane.showMessageDialog(null, "Registro guardado");

        } else {
            JOptionPane.showMessageDialog(p, "Error, intente de nuevo");
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.Estudiantes) {
            show_e();
            showtable();

        }

        if (e.getSource() == es.btn_create) {
            create_Student();
            limpiarcajas();
            showtable();
        }
        if (e.getSource() == es.btn_select) {
            PreparedStatement ps;
            ResultSet rs;

            try {

                int fila = es.Tabla.getSelectedRow();
                int id = Integer.parseInt(es.Tabla.getValueAt(fila, 0).toString());

                Connection con = mte.getConnection();

                ps = con.prepareStatement("SELECT * FROM estudiantes WHERE id_Estudiante=? ");

                ps.setInt(1, id);

                rs = ps.executeQuery();

                while (rs.next()) {
                    es.Txt_DocumentStudent.setText(String.valueOf(id));
                    es.Txt_nameStudent.setText(rs.getString("Nombres"));
                    es.Txt_LastNameStudent.setText(rs.getString("Apellidos"));
                    es.Txt_Day_Born.setText(rs.getString("Fecha_Nacimiento"));

                    if (rs.getString("Sexo").equals("M")) {
                        es.btn_M.setSelected(true);
                    } else if (rs.getString("Sexo").equals("S")) {
                        es.btn_F.setSelected(true);
                    }
                    es.Box_grade.setSelectedItem(String.valueOf("Grado"));
                    es.Box_section.setSelectedItem("Seccion");
                    es.Txt_Direction.setText(rs.getString("Direccion"));
                    es.Txt_telephone.setText(rs.getString("Telefono"));
                    es.Txt_email.setText(rs.getString("Email"));
                    es.Txt_password.setText(rs.getString("Contraseña"));
                }

            } catch (SQLException y) {
                JOptionPane.showMessageDialog(null, y);
            }
            es.Txt_DocumentStudent.requestFocus();
        }

    

    if (e.getSource () 
        == es.btn_moficar) {
            modificar();
        showtable();
    }

    if (e.getSource () 
        == es.Btn_Delete) {
            eliminar();
        showtable();

    }
    ///////////////////////////////////////////

    if (e.getSource () 
        == admin.Profesores) {
            show_p();
    }

    if (e.getSource () 
        == p.btn_crear) {
            createProf();
    }

    if (e.getSource () 
        == admin.Cursos) {
            JOptionPane.showMessageDialog(admin, "Cursos");
    }

    if (e.getSource () 
        == admin.Horarios) {
            JOptionPane.showMessageDialog(admin, "Horarios");
    }

    if (e.getSource () 
        == admin.Exit) {
            exit();
    }
}

}
