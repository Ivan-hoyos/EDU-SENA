package Controlador;

import Modelo.ActModel;
import Modelo.Estudiantes_Modelo;
import Modelo.MetodosEstudiante;
import Modelo.SesionEstudiante;
import Vista.ActividadesEs;
import Vista.ActualizarEs;
import Vista.EditarActEs;
import Vista.Estudiante_log;
import Vista.NotasEs;
import Vista.TablaActEs;
import Vista.TablaNotasEs;
import Vista.VerAct;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorEstudiante implements ActionListener {

    Estudiante_log principal = new Estudiante_log(); //Menu principal 
    ActualizarEs perfil = new ActualizarEs(); // Configuración de Perfil
    Estudiantes_Modelo mode = new Estudiantes_Modelo(); //Modelo estudiante
    ActModel amodel = new ActModel(); //Modelo de actividades
    ActividadesEs actes = new ActividadesEs(); // Form para ver las actividades
    VerAct ver = new VerAct(); // Panel para ver la actividad
    NotasEs notas = new NotasEs(); // Panel de notas
    EditarActEs edit = new EditarActEs(); // Panel para responder actividad
    TablaNotasEs tnotas = new TablaNotasEs(); //Tabla de notas
    TablaActEs tbl = new TablaActEs();
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
        this.actes.btn_ver.addActionListener(this);
        this.actes.btn_responder.addActionListener(this);
        this.ver.btnResponder.addActionListener(this);
        this.ver.btnVolver.addActionListener(this);
        this.edit.btnResponder.addActionListener(this);
        this.edit.btnCancelar.addActionListener(this);
        this.notas.Periodo1.addActionListener(this);
        this.notas.Periodo2.addActionListener(this);
        this.notas.Periodo3.addActionListener(this);
        this.notas.Periodo4.addActionListener(this);

        tbl.Tabla.addMouseListener(new MouseAdapter() {// Evento para seleccionar un registro en la tabla de estudiantes
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
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

        mode.setid_Estudiante(Integer.parseInt(perfil.Txt_Document.getText()));
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

    public void TblAct() {
        DefaultTableModel ModeloTabla = (DefaultTableModel) tbl.Tabla.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;

        PreparedStatement psN;
        ResultSet rsN;
        ResultSetMetaData rsmdN;
        int columnas;

        try {
            String curso = sessionManager.getIdCurso();
            Connection con = metodos.getConnection();

            ps = con.prepareStatement("SELECT IdActividad, Titulo, FechaCreacion, ProfesorId, Materia From actividades WHERE idCurso = ?;");
            ps.setString(1, curso);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            psN = con.prepareStatement("SELECT Nota From notas WHERE id_Alumno = ?;");
            int id = sessionManager.getUsername();
            psN.setInt(1, id);
            rsN = psN.executeQuery();
            rsmdN = rsN.getMetaData();

            while (rs.next() && rsN.next()) {

                Object[] fila = new Object[columnas + 1];

                /*for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }*/
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);

                }
                fila[columnas] = rsN.getObject(1);

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
            int fila = tbl.Tabla.getSelectedRow();
            int id = Integer.parseInt(tbl.Tabla.getValueAt(fila, 0).toString());

            Connection con = metodos.getConnection();

            ps = con.prepareStatement("SELECT Titulo, Descripcion, Materia, Periodo FROM actividades WHERE IdActividad=? ");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                ver.TxtTitulo.setText(rs.getString("Titulo"));
                ver.TextDescrip.setText(rs.getString("Descripcion"));
                ver.BoxMaterias.setSelectedItem(rs.getString("Materia"));
                int Periodo = Integer.parseInt(rs.getString("Periodo"));
                amodel.setPeriodo(Periodo);
                edit.TxtTitulo.setText(rs.getString("Titulo"));

            }

        } catch (SQLException y) {
            JOptionPane.showMessageDialog(null, y);
        }
    }

    public void respuesta() {

        amodel.setTitulo(edit.TxtTitulo.getText());
        amodel.setRespuesta(edit.TextDesarr.getText());

        int fila = tbl.Tabla.getSelectedRow();
        String materia = (String) tbl.Tabla.getValueAt(fila, 4);
        amodel.setMateria(materia);

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

        amodel.setFechaCreacion(timestamp);

        int r = metodos.responder(amodel);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(ActModel.class.getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Respuesta guardada", "Guardado", JOptionPane.OK_OPTION, icon);
            edit.TxtTitulo.setText(null);
            edit.TextDesarr.setText(null);

        } else {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
        }
    }

    public void TblNotas() {

        DefaultTableModel ModeloTabla = (DefaultTableModel) tnotas.Tabla.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            String curso = sessionManager.getIdCurso();
            Connection con = metodos.getConnection();

            ps = con.prepareStatement("SELECT IdActividad, Titulo, FechaCreacion, ProfesorId, Materia From actividades WHERE idCurso = ?;");
            ps.setString(1, curso);
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

        if (e.getSource() == principal.Actividades) {
            actes.setSize(1100, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(actes, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(actes, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            tbl.setSize(1056, 536);
            actes.south.removeAll();
            actes.south.add(tbl, BorderLayout.CENTER);
            actes.south.setComponentZOrder(tbl, 0);
            actes.south.revalidate();
            actes.south.repaint();
            TblAct();
            actes.btn_responder.setEnabled(true);
            actes.btn_ver.setEnabled(true);

        }

        if (e.getSource() == actes.btn_ver) {
            if (tbl.Tabla.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una Actividad", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                ver.setSize(1056, 521);
                actes.south.removeAll();
                actes.south.add(ver, BorderLayout.CENTER);
                actes.south.setComponentZOrder(ver, 0);
                actes.south.revalidate();
                actes.south.repaint();
                seleccionar();
                ver.BoxMaterias.setEnabled(false);
                ver.TxtTitulo.setEnabled(false);
                ver.TextDescrip.setEditable(false);
            }
        }

        if (e.getSource() == actes.btn_responder || e.getSource() == ver.btnResponder) {
            if (tbl.Tabla.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una Actividad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int fila = tbl.Tabla.getSelectedRow();
                int id = Integer.parseInt(tbl.Tabla.getValueAt(fila, 0).toString());

                amodel.setIdActividad(id);

                edit.setSize(1056, 521);
                actes.south.removeAll();
                actes.south.add(edit, BorderLayout.CENTER);
                actes.south.setComponentZOrder(edit, 0);
                actes.south.revalidate();
                actes.south.repaint();
                seleccionar();
                actes.btn_ver.setEnabled(false);
                actes.btn_responder.setEnabled(false);

            }

        }

        if (e.getSource() == edit.btnResponder) {
            String title = edit.TxtTitulo.getText();
            String Des = edit.TextDesarr.getText();

            if (title.equals("") || Des.equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                respuesta();
                actes.setSize(1100, 760);
                principal.Panel_right.removeAll();
                principal.Panel_right.add(actes, BorderLayout.CENTER);
                principal.Panel_right.setComponentZOrder(actes, 0);
                principal.Panel_right.revalidate();
                principal.Panel_right.repaint();
                tbl.setSize(1056, 536);
                actes.south.removeAll();
                actes.south.add(tbl, BorderLayout.CENTER);
                actes.south.setComponentZOrder(tbl, 0);
                actes.south.revalidate();
                actes.south.repaint();
                TblAct();
                actes.btn_responder.setEnabled(true);
                actes.btn_ver.setEnabled(true);
            }

        }

        if (e.getSource() == edit.btnCancelar) {
            Object[] options = {"Sí", "No"};
            // Cargar un ícono personalizado desde un archivo de imagen
            //ImageIcon icon = new ImageIcon("/Images/boton-eliminar.png");
            ImageIcon icon = new ImageIcon(MetodosEstudiante.class
                    .getResource("/Images/boton-eliminar.png"));

            int choice = JOptionPane.showOptionDialog(
                    null, // Componente padre, null para diálogo independiente
                    "¿Descartar Cambios??", // Pregunta
                    "Cancelar Registro", // Título del diálogo
                    JOptionPane.YES_NO_OPTION, // Tipo de opciones
                    JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje
                    icon, // Icono personalizado, null para el icono predeterminado
                    options, // Opciones de respuesta
                    options[0]); // Opción predeterminada

            // Verifica la respuesta del usuario
            switch (choice) {
                case JOptionPane.YES_OPTION:

                    JOptionPane.showMessageDialog(null, "Cambios Descartados");
                    actes.setSize(1100, 760);
                    principal.Panel_right.removeAll();
                    principal.Panel_right.add(actes, BorderLayout.CENTER);
                    principal.Panel_right.setComponentZOrder(actes, 0);
                    principal.Panel_right.revalidate();
                    principal.Panel_right.repaint();
                    edit.TextDesarr.setText(null);

                    tbl.setSize(1056, 536);
                    actes.south.removeAll();
                    actes.south.add(tbl, BorderLayout.CENTER);
                    actes.south.setComponentZOrder(tbl, 0);
                    actes.south.revalidate();
                    actes.south.repaint();
                    TblAct();
                    actes.btn_responder.setEnabled(true);
                    actes.btn_ver.setEnabled(true);
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("El usuario seleccionó 'No'");
                    break;
                default:
                    System.out.println("El usuario cerró el diálogo");
                    break;
            }
        }

        if (e.getSource() == ver.btnVolver) {
            actes.setSize(1100, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(actes, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(actes, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            tbl.setSize(1056, 536);
            actes.south.removeAll();
            actes.south.add(tbl, BorderLayout.CENTER);
            actes.south.setComponentZOrder(tbl, 0);
            actes.south.revalidate();
            actes.south.repaint();
            TblAct();
            actes.btn_responder.setEnabled(true);
            actes.btn_ver.setEnabled(true);
        }

        if (e.getSource() == principal.Notas) {
            notas.setSize(1300, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(notas, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(notas, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
        }

    }

}
