package Controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.Estudiantes_Modelo;
import Modelo.Metodos_Admin;
import Modelo.ProfModel;
import Vista.Admin;
import Vista.Estudiante_log;
import Vista.Tutor;
import Vista.Students;
import Vista.Teachers;
import Vista.cursos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Admin implements ActionListener {

    Metodos_Admin mte = new Metodos_Admin(); //Metodos Administrador
    Estudiantes_Modelo mode = new Estudiantes_Modelo(); //Modelo estudiante
    ProfModel pmode = new ProfModel(); //Modelo profesor
    Admin admin = new Admin();
    Students es = new Students();
    Teachers p = new Teachers();
    cursos cu = new cursos();
    Estudiante_log fc = new Estudiante_log();
    Tutor efrm = new Tutor();
    DefaultTableModel modelo = new DefaultTableModel();
    private MouseListener l;

    public Controlador_Admin(Admin admin, Students es) {
        this.admin = admin;
        this.es = es;
        this.mte = mte;
        this.mode = mode;
        this.admin.Estudiantes.addActionListener(this);
        this.admin.Estudiantes.addMouseListener(l);
        this.admin.Profesores.addActionListener(this);
        this.admin.Cursos.addActionListener(this);
        this.admin.Horarios.addActionListener(this);
        this.admin.Exit.addActionListener(this);
        this.es.btn_create.addActionListener(this);
        this.es.btn_clean.addActionListener(this);
        this.es.btn_moficar.addActionListener(this);
        this.es.Btn_Delete.addActionListener(this);
        this.p.btn_crear.addActionListener(this);
        this.p.btn_moficar.addActionListener(this);
        this.p.btn_limpiar.addActionListener(this);
        this.p.Btn_Delete.addActionListener(this);
        this.cu.btn_buscar.addActionListener(this);
        this.cu.btn_asignar.addActionListener(this);
        this.efrm.btn_asignar.addActionListener(this);
        this.efrm.btn_cancelar.addActionListener(this);
        // this.cu.jButton3.addActionListener(this);

        es.Tabla.addMouseListener(new MouseAdapter() {// Evento para seleccionar un registro en la tabla de estudiantes
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });

        p.Tablap.addMouseListener(new MouseAdapter() {// Evento para seleccionar un registro en la tabla de profesores
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarP();
            }
        });

        /*cu.Box_Cursos.addMouseListener(new MouseAdapter() {// Evento para seleccionar un registro en la caja de cursos
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarCur();
            }
        });
         */
    }

    public void create_Student() {//Metodo para crear un estudiante nuevo
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
        //mode.setGrado(Byte.parseByte(es.Box_grade.getSelectedItem().toString()));
        //mode.setSeccion(es.Box_section.getSelectedItem().toString());
        mode.setDireccion(es.Txt_Direction.getText());
        mode.setTelefono(Long.parseLong(es.Txt_telephone.getText()));
        mode.setEmail(es.Txt_email.getText());
        mode.setContraseña(es.Txt_password.getText());
        String id_Curso = mode.getGrado() + mode.getSeccion();
        mode.setId_Curso(id_Curso);
        int r = mte.create_Student(mode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(Metodos_Admin.class.getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Registro guardado", "Guardado", JOptionPane.CLOSED_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(es, "Error, intente de nuevo");

        }
    }

    public void modificar() { //modificar un estudiante
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
        //mode.setGrado(Byte.parseByte(es.Box_grade.getSelectedItem().toString()));
        //mode.setSeccion(es.Box_section.getSelectedItem().toString());
        mode.setDireccion(es.Txt_Direction.getText());
        mode.setTelefono(Long.parseLong(es.Txt_telephone.getText()));
        mode.setEmail(es.Txt_email.getText());
        mode.setContraseña(es.Txt_password.getText());
        String id_Curso = mode.getGrado() + mode.getSeccion();
        mode.setId_Curso(id_Curso);
        int r = mte.modificar(mode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(Metodos_Admin.class.getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(es, "Registro actualizado!!", "Actualizado", JOptionPane.CLOSED_OPTION, icon);
        } else {
            JOptionPane.showMessageDialog(es, "Error, intente de nuevo");
        }
    }

    public void eliminar() {// Eliminar estudiante
        int fila = es.Tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un Registro", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] options = {"Sí", "No"};
            // Cargar un ícono personalizado desde un archivo de imagen
            //ImageIcon icon = new ImageIcon("/Images/boton-eliminar.png");
            ImageIcon icon = new ImageIcon(Metodos_Admin.class.getResource("/Images/boton-eliminar.png"));

            int choice = JOptionPane.showOptionDialog(
                    null, // Componente padre, null para diálogo independiente
                    "¿Deseas continuar?", // Pregunta
                    "Confirmar Eliminacion", // Título del diálogo
                    JOptionPane.YES_NO_OPTION, // Tipo de opciones
                    JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje
                    icon, // Icono personalizado, null para el icono predeterminado
                    options, // Opciones de respuesta
                    options[0] // Opción predeterminada
            );

            // Verifica la respuesta del usuario
            switch (choice) {
                case JOptionPane.YES_OPTION:

                    int doc = Integer.parseInt(es.Tabla.getValueAt(fila, 0).toString());
                    mte.eliminar(doc);
                    limpiarcajas();
                    showtable();
                    JOptionPane.showMessageDialog(admin, "Estudiante Eliminado", "Eliminado", JOptionPane.OK_OPTION, icon);
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("El usuario seleccionó 'No'");
                    break;
                default:
                    System.out.println("El usuario cerró el diálogo");
                    break;
            }

        }

        System.out.println("Registro eliminado");

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

    public void show_cursos() {//Metodo para mostrar el formulario cursos

        cu.setSize(1100, 760);
        admin.Panel_right.removeAll();
        admin.Panel_right.add(cu, BorderLayout.CENTER);
        admin.Panel_right.setComponentZOrder(cu, 0);
        admin.Panel_right.revalidate();
        admin.Panel_right.repaint();

    }

    public void showtutor() {//Metodo para mostrar el formulario cursos

        efrm.setVisible(true);
        efrm.setLocationRelativeTo(cu);

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

            ps = con.prepareStatement("Select id_Estudiante, Nombres, Apellidos,Fecha_Nacimiento, Telefono FROM estudiantes");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                int[] anchos = {1, 1, 1, 1, 1};

                for (int i = 0; i < 5; i++) {
                    es.Tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                ModeloTabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void seleccionar() {
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
                    es.btn_F.setSelected(false);
                } else if (rs.getString("Sexo").equals("F")) {
                    es.btn_F.setSelected(true);
                     es.btn_M.setSelected(false);
                }

                //String grado = rs.getString("Grado");
                //es.Box_grade.setSelectedItem(grado);
                //String seccion = rs.getString("Seccion");
                //es.Box_section.setSelectedItem(seccion);
                es.Txt_Direction.setText(rs.getString("Direccion"));
                es.Txt_telephone.setText(rs.getString("Telefono"));
                es.Txt_email.setText(rs.getString("Email"));
                es.Txt_password.setText(rs.getString("Contraseña"));
                System.out.println(rs.getByte("Grado"));

            }

        } catch (SQLException y) {
            JOptionPane.showMessageDialog(null, y);
        }
        es.Txt_DocumentStudent.setEditable(false);
        es.Txt_DocumentStudent.setForeground(Color.white);
        es.Txt_DocumentStudent.setBackground(Color.GRAY);

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
        //es.Box_grade.setSelectedItem("Seleccione");
        //es.Box_section.setSelectedItem("Seleccione");
        es.Txt_password.setText(null);

        es.Txt_DocumentStudent.setEditable(true);
        es.Txt_DocumentStudent.setForeground(Color.black);
        es.Txt_DocumentStudent.setBackground(Color.white);
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
        pmode.setProfesion(p.Materia.getSelectedItem().toString());
        int idMateria = p.Materia.getSelectedIndex();
        pmode.setidMateria(idMateria);
        System.out.println(pmode.getidMateria());
        int r = mte.createProf(pmode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(Metodos_Admin.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Registro guardado", "Guardado", JOptionPane.OK_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(p, "Error, intente de nuevo");
        }
    }

    public void modificarP() { //modificar un profesor
        pmode.setId_Profesor(Long.parseLong(p.Txt_Documentp.getText()));
        pmode.setNombres(p.Txt_namep.getText());
        pmode.setApellidos(p.Txt_LastNamep.getText());
        pmode.setDireccion(p.Txt_Directionp.getText());
        pmode.setTelefono(Long.parseLong(p.Txt_telephonep.getText()));
        pmode.setEmail(p.Txt_emailp.getText());
        pmode.setContraseña(p.Txt_passwordp.getText());
        pmode.setProfesion(p.Materia.getSelectedItem().toString());
        int idMateria = p.Materia.getSelectedIndex();
        pmode.setidMateria(idMateria);

        int r = mte.modificarP(pmode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(Metodos_Admin.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(p, "Registro actualizado!!", "Guardado", JOptionPane.CLOSED_OPTION, icon);
        } else {
            JOptionPane.showMessageDialog(p, "Error, intente de nuevo");
        }
    }

    public void asignarP() { //modificar id curso de un profesor
        int fila = efrm.Tablap.getSelectedRow();
        Long id = Long.parseLong(efrm.Tablap.getValueAt(fila, 0).toString());
        pmode.setId_Profesor(id);

        String idCurso = cu.Box_Cursos.getSelectedItem().toString();
        pmode.setidCurso(idCurso);
        System.out.println(idCurso);
        System.out.println(pmode.getidCurso());
        int r = mte.asignarcurso(pmode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(Metodos_Admin.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(p, "Tutor Aignado al curso "+idCurso+"", "Guardado", JOptionPane.CLOSED_OPTION, icon);
            efrm.dispose();
            cu.Box_Cursos.setSelectedIndex(0);
            cu.jTextField1.setText(null);
        } else {
            JOptionPane.showMessageDialog(p, "Error, intente de nuevo");
        }
    }
    
      public void Matricular() { //modificar id curso de un estudiante
        int fila = efrm.Tablap.getSelectedRow();
        Long id = Long.parseLong(efrm.Tablap.getValueAt(fila, 0).toString());
        pmode.setId_Profesor(id);

        String idCurso = cu.Box_Cursos.getSelectedItem().toString();
        pmode.setidCurso(idCurso);
        System.out.println(idCurso);
        System.out.println(pmode.getidCurso());
        int r = mte.asignarcurso(pmode);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(Metodos_Admin.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(p, "Tutor Aignado al curso "+idCurso+"", "Guardado", JOptionPane.CLOSED_OPTION, icon);
            efrm.dispose();
            cu.Box_Cursos.setSelectedIndex(0);
            cu.jTextField1.setText(null);
        } else {
            JOptionPane.showMessageDialog(p, "Error, intente de nuevo");
        }
    }

    public void eliminarP() {// Eliminar profesor
        int fila = p.Tablap.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(p, "Seleccione un Registro", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] options = {"Sí", "No"};
            // Cargar un ícono personalizado desde un archivo de imagen
            //ImageIcon icon = new ImageIcon("/Images/boton-eliminar.png");
            ImageIcon icon = new ImageIcon(Metodos_Admin.class
                    .getResource("/Images/boton-eliminar.png"));

            int choice = JOptionPane.showOptionDialog(
                    null, // Componente padre, null para diálogo independiente
                    "¿Deseas continuar?", // Pregunta
                    "Confirmar Eliminacion", // Título del diálogo
                    JOptionPane.YES_NO_OPTION, // Tipo de opciones
                    JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje
                    icon, // Icono personalizado, null para el icono predeterminado
                    options, // Opciones de respuesta
                    options[0] // Opción predeterminada
            );

            // Verifica la respuesta del usuario
            switch (choice) {
                case JOptionPane.YES_OPTION:

                    int doc = Integer.parseInt(p.Tablap.getValueAt(fila, 0).toString());
                    mte.eliminarP(doc);
                    limpiarcajasP();
                    showtableP();
                    JOptionPane.showMessageDialog(admin, "Profesor Eliminado");
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("El usuario seleccionó 'No'");
                    break;
                default:
                    System.out.println("El usuario cerró el diálogo");
                    break;
            }

            System.out.println("Registro eliminado");
        }
    }

    public void showtableP() {

        DefaultTableModel ModeloTabla = (DefaultTableModel) p.Tablap.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection con = mte.getConnection();

            ps = con.prepareStatement("Select id_Profesor, Nombres, Apellidos, Profesion, Telefono, Email FROM profesores");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                int[] anchos = {1, 1, 1, 1, 1};

                for (int i = 0; i < 5; i++) {
                    p.Tablap.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                ModeloTabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void seleccionarP() {
        PreparedStatement ps;
        ResultSet rs;

        try {

            int fila = p.Tablap.getSelectedRow();
            int id = Integer.parseInt(p.Tablap.getValueAt(fila, 0).toString());

            Connection con = mte.getConnection();

            ps = con.prepareStatement("SELECT * FROM profesores WHERE id_Profesor=? ");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                p.Txt_Documentp.setText(String.valueOf(id));
                p.Txt_namep.setText(rs.getString("Nombres"));
                p.Txt_LastNamep.setText(rs.getString("Apellidos"));
                p.Txt_Directionp.setText(rs.getString("Direccion"));
                p.Txt_telephonep.setText(rs.getString("Telefono"));
                p.Txt_emailp.setText(rs.getString("Email"));
                p.Txt_passwordp.setText(rs.getString("Contraseña"));
                String profesion = rs.getString("Profesion");
                p.Materia.setSelectedItem(profesion);

            }

        } catch (SQLException y) {
            JOptionPane.showMessageDialog(null, y);
        }
        p.Txt_Documentp.setEditable(false);
        p.Txt_Documentp.setForeground(Color.white);
        p.Txt_Documentp.setBackground(Color.GRAY);

    }

    public void limpiarcajasP() {
        p.Txt_Documentp.setText(null);
        p.Txt_namep.setText(null);
        p.Txt_LastNamep.setText(null);

        p.Txt_Directionp.setText(null);
        p.Txt_telephonep.setText(null);
        p.Txt_emailp.setText(null);
        p.Txt_passwordp.setText(null);
        p.Materia.setSelectedItem(null);

        p.Txt_Documentp.setEditable(true);
        p.Txt_Documentp.setForeground(Color.black);
        p.Txt_Documentp.setBackground(new Color(235, 235, 235));
    }

    public void seleccionarCur() {
        DefaultTableModel ModeloTabla = (DefaultTableModel) cu.tabla_e.getModel();
        ModeloTabla.setRowCount(0);
        PreparedStatement ps;
        PreparedStatement ps_p;
        ResultSet rs;
        String idCurso = cu.Box_Cursos.getSelectedItem().toString();

        try {
            Connection con = mte.getConnection();

            ps = con.prepareStatement("Select id_Estudiante, Nombres, Apellidos, Fecha_Nacimiento FROM estudiantes WHERE id_Curso=?");
            ps_p = con.prepareStatement("Select Nombres, Apellidos FROM profesores WHERE id_Curso=?");
            ps_p.setString(1, idCurso);
            ps.setString(1, idCurso);

            rs = ps.executeQuery();
            ResultSet rs_P = ps_p.executeQuery();
            int columnas = cu.tabla_e.getColumnCount();

            while (rs_P.next()) {
                String n = rs_P.getString("Nombres");
                String a = rs_P.getString("Apellidos");

                String nombre = n + " " + a;
                cu.jTextField1.setText(nombre);
                cu.jTextField1.setEditable(false);
            }

            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                ModeloTabla.addRow(fila);

            }

        } catch (SQLException y) {
            JOptionPane.showMessageDialog(null, y);
        }

    }

    public void tabla_tutor() {

        DefaultTableModel ModeloTabla = (DefaultTableModel) efrm.Tablap.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection con = mte.getConnection();

            ps = con.prepareStatement("Select id_Profesor, Nombres, Apellidos, Profesion, Telefono, Email FROM profesores");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                int[] anchos = {1, 1, 1, 1, 1};

                for (int i = 0; i < 5; i++) {
                    efrm.Tablap.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                ModeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.Estudiantes) {
            show_e();
            showtable();
            es.Txt_DocumentStudent.setEditable(true);
            es.Txt_DocumentStudent.setForeground(Color.black);
            es.Txt_DocumentStudent.setBackground(new Color(235, 235, 235));

        }

        if (e.getSource() == es.btn_create) {
            create_Student();
            limpiarcajas();
            showtable();
        }
        if (e.getSource() == es.btn_clean) {
            limpiarcajas();
            es.Txt_DocumentStudent.setFocusable(true);
            es.Txt_DocumentStudent.setBackground(new Color(235, 235, 235));
            showtable();
        }

        if (e.getSource()
                == es.btn_moficar) {
            modificar();
            showtable();

        }

        if (e.getSource() == es.Btn_Delete) {
            eliminar();
        }
        ///////////////////////////////////////////

        if (e.getSource() == admin.Profesores) {
            show_p();
            showtableP();
            p.Txt_Documentp.setEditable(true);
            p.Txt_Documentp.setForeground(Color.black);
            p.Txt_Documentp.setBackground(new Color(235, 235, 235));
            p.Materia.setSelectedItem(null);
        }

        if (e.getSource() == p.btn_crear) {
            createProf();
            limpiarcajasP();
            showtableP();
        }

        if (e.getSource() == p.btn_moficar) {
            modificarP();
            showtableP();

        }

        if (e.getSource() == p.Btn_Delete) {
            eliminarP();
        }
        if (e.getSource() == p.btn_limpiar) {
            limpiarcajasP();
            p.Txt_Documentp.setFocusable(true);
            showtableP();
        }

        if (e.getSource()
                == admin.Cursos) {
            show_cursos();
        }

        if (e.getSource()
                == admin.Horarios) {
            JOptionPane.showMessageDialog(admin, "Horarios");
        }

        if (e.getSource()
                == admin.Exit) {
            exit();
        }
        if (e.getSource() == cu.btn_buscar) {
            seleccionarCur();
        }

        if (e.getSource() == cu.btn_asignar) {
            String idCurso = cu.Box_Cursos.getSelectedItem().toString();

            if (idCurso.equals("Seleccione")) {
                JOptionPane.showMessageDialog(admin, "Seleccione un curso");
            } else {
                showtutor();
                //efrm.setVisible(true);

                tabla_tutor();
            }

        }

        if (e.getSource() == efrm.btn_asignar) {
            asignarP();
        }
        if (e.getSource() == efrm.btn_cancelar) {
            JOptionPane.showMessageDialog(null, "Cancelado");
            efrm.dispose();
        }

    }

}
