package Controlador;

import Modelo.ActModel;
import Modelo.Estudiantes_Modelo;
import Modelo.MetodosEstudiante;
import Modelo.MetodosProf;
import Modelo.ProfModel;
import Modelo.SesionProf;
import Vista.ActividadesProf;
import Vista.ActualizarProf;
import Vista.CrearActividad;
import Vista.EditarAct;
import Vista.ProfLog;
import Vista.TablaAct;
import Vista.Respuestasprof;
import Vista.TablaRes;
import Vista.VerProf;
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

public class ControladorProf implements ActionListener {

    ProfLog principal = new ProfLog(); //Menu principal 
    ActualizarProf perfil = new ActualizarProf(); // Configuración de Perfil
    ActividadesProf act = new ActividadesProf(); // Form de actividades
    CrearActividad cre = new CrearActividad(); // Form para crear actividades
    EditarAct eact = new EditarAct(); // Form para editar las actividades
    Respuestasprof res = new Respuestasprof(); // Form de respuestas
    VerProf ver = new VerProf(); // Ver respuesta
    TablaAct tablaact = new TablaAct(); //Tabla de actividades
    ProfModel modeP = new ProfModel(); //Modelo profesor
    Estudiantes_Modelo emodel = new Estudiantes_Modelo();
    TablaRes resT = new TablaRes(); //Tabla respuestas
    MetodosProf metodosP = new MetodosProf();
    SesionProf sessionManager = SesionProf.getInstance();
    ActModel amdl = new ActModel();

    public ControladorProf(ProfLog principal) {
        this.principal.Actividades.addActionListener(this);
        //this.principal.Notas.addActionListener(this);
        //this.principal.Horarios.addActionListener(this);
        this.principal.perfil.addActionListener(this);
        this.principal.Exit.addActionListener(this);
        this.perfil.btn_modificar.addActionListener(this);
        this.perfil.btn_editar.addActionListener(this);
        this.perfil.Btn_cancelar.addActionListener(this);
        this.perfil.btn_F.addActionListener(this);
        this.perfil.btn_M.addActionListener(this);
        this.act.btn_crear.addActionListener(this);
        this.act.btn_editar.addActionListener(this);
        this.act.btn_eliminar.addActionListener(this);
        this.cre.btnCrear.addActionListener(this);
        this.cre.btnCancelar.addActionListener(this);
        this.act.btn_buscar.addActionListener(this);
        this.eact.btnCancelar.addActionListener(this);
        this.eact.btnGuardad.addActionListener(this);
        this.act.Respuestas.addActionListener(this);
        this.res.atras.addActionListener(this);
        this.res.btn_ver.addActionListener(this);
        this.ver.btnCalificar.addActionListener(this);
        this.ver.btnVolver.addActionListener(this);

        tablaact.Actividades.addMouseListener(new MouseAdapter() {// Evento para seleccionar un registro en la tabla de estudiantes
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });

    }

    public void infoP() {//Información de la sesion
        perfil.Txt_DocumentP.setText(Long.toString(sessionManager.getUsername()));
        perfil.Txt_nameP.setText(sessionManager.getNombres());
        perfil.Txt_LastNameP.setText(sessionManager.getApellidos());
        String fecha = sessionManager.getFecha_Nacimiento();
        if (fecha == null) {
            perfil.Txt_Day_Born.setText(null);
        } else {
            perfil.Txt_Day_Born.setText(fecha);
        }
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

    public void obtenerAct(ActModel amdl) {

        String sql = "SELECT * From actividades WHERE idCurso = ? AND ProfesorId = ?;";
        Connection con = metodosP.getConnection();
        String curso = act.Box_Cursos.getSelectedItem().toString();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curso);
            ps.setInt(2, (int) sessionManager.getUsername());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String valor = rs.getString("idActividad");
                String titulo = rs.getString("Titulo");
                String descr = rs.getString("Descripcion");
                String materia = rs.getString("Materia");

                amdl.setMateria(materia);
                amdl.setDescripcion(descr);
                amdl.setTitulo(titulo);
                eact.TxtTitulo.setText(titulo);
                eact.TextDescrip.setText(descr);
                eact.BoxMaterias.setSelectedItem(materia);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void TblAct() {

        tablaact.setSize(1056, 521);
        act.south.removeAll();
        act.south.add(tablaact, BorderLayout.CENTER);
        act.south.setComponentZOrder(tablaact, 0);
        act.south.revalidate();
        act.south.repaint();
        cre.TxtTitulo.setText(null);
        cre.TextDescrip.setText(null);
        cre.BoxMaterias.setSelectedItem(null);

        DefaultTableModel ModeloTabla = (DefaultTableModel) tablaact.Actividades.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            String curso = act.Box_Cursos.getSelectedItem().toString();
            Connection con = metodosP.getConnection();

            ps = con.prepareStatement("SELECT * From actividades WHERE idCurso = ? AND ProfesorId = ?;");
            ps.setString(1, curso);
            ps.setInt(2, (int) sessionManager.getUsername());
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                ModeloTabla.addRow(fila);
                amdl.setIdMateria(rs.getInt("IdAsignatura"));
                amdl.setMateria(rs.getString("Materia"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void TblRes() {

        resT.setSize(1056, 521);
        res.south.removeAll();
        res.south.add(resT, BorderLayout.CENTER);
        res.south.setComponentZOrder(resT, 0);
        res.south.revalidate();
        res.south.repaint();
        res.TtlAct.setText(null);

        DefaultTableModel ModeloTabla = (DefaultTableModel) resT.Actividades.getModel();
        ModeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;

        PreparedStatement psN;
        ResultSet rsN;
        ResultSetMetaData rsmdN;

        int columnas;

        try {
            int fila = tablaact.Actividades.getSelectedRow();
            int id = Integer.parseInt(tablaact.Actividades.getValueAt(fila, 0).toString());

            String curso = (tablaact.Actividades.getValueAt(fila, 5).toString());

            amdl.setIdActividad(id);
            amdl.setIdCurso(curso);

            Connection con = metodosP.getConnection();

            ps = con.prepareStatement("SELECT IdRespuesta, IdActividad, Titulo, IdEstudiante, NombreEstudiante, IdCurso, Respuesta, FechaEnvio From respuestas WHERE IdActividad = ? AND IdCurso = ?;");
            ps.setInt(1, amdl.getIdActividad());
            ps.setString(2, amdl.getIdCurso());
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                res.TtlAct.setText(rs.getString("Titulo"));

                Object[] filas = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                ModeloTabla.addRow(filas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void seleccionar() {
        PreparedStatement ps;
        ResultSet rs;
        try {
            int fila = tablaact.Actividades.getSelectedRow();
            int id = Integer.parseInt(tablaact.Actividades.getValueAt(fila, 0).toString());

            Connection con = metodosP.getConnection();

            ps = con.prepareStatement("SELECT Titulo, Descripcion, Materia FROM actividades WHERE IdActividad=? ");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                eact.TxtTitulo.setText(rs.getString("Titulo"));
                eact.TextDescrip.setText(rs.getString("Descripcion"));
                eact.BoxMaterias.setSelectedItem(rs.getString("Materia"));
            }

        } catch (SQLException y) {
            JOptionPane.showMessageDialog(null, y);
        }
    }

    public void seleccionarRes() {
        PreparedStatement ps;
        ResultSet rs;

        PreparedStatement psN;
        ResultSet rsN;
        try {
            int fila = resT.Actividades.getSelectedRow();
            int id = Integer.parseInt(resT.Actividades.getValueAt(fila, 0).toString());
            amdl.setIdRespuesta(id);

            int fila1 = resT.Actividades.getSelectedRow();
            int id1 = Integer.parseInt(resT.Actividades.getValueAt(fila1, 3).toString());
            amdl.setIdestudiante(id1);

            Connection con = metodosP.getConnection();

            ps = con.prepareStatement("SELECT Titulo, Respuesta, NombreEstudiante, IdEstudiante, Periodo FROM respuestas WHERE IdRespuesta=? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            psN = con.prepareStatement("SELECT Nota From notas WHERE id_Alumno = ?;");
            psN.setInt(1, amdl.getIdestudiante());
            rsN = psN.executeQuery();

            while (rs.next() ) {
                ver.TxtTitulo.setText(rs.getString("Titulo"));
                ver.TextRespuesta.setText(rs.getString("Respuesta"));
                ver.Nombre.setText(rs.getString("NombreEstudiante"));
                int idestudiante = rs.getInt("IdEstudiante");
                int Periodo = rs.getInt("Periodo");
                amdl.setPeriodo(Periodo);
                amdl.setIdestudiante(idestudiante);

                ver.TxtTitulo.setEditable(false);
                ver.TextRespuesta.setEditable(false);
                ver.Nombre.setEditable(false);
            }

            while (rsN.next()) {
                float nota = rsN.getFloat("Nota");
                amdl.setNota(nota);
                if (amdl.getNota() < 1) {
                    ver.NOTA.setText("0");
                } else {
                    ver.NOTA.setText(String.valueOf(nota));
                }
            }

        } catch (SQLException y) {
            JOptionPane.showMessageDialog(null, y);
        }
    }

    public void CrearAct(ActModel amdl) {
        String idCurso = act.Box_Cursos.getSelectedItem().toString();
        amdl.setIdCurso(idCurso);
        amdl.setTitulo(cre.TxtTitulo.getText());
        amdl.setDescripcion(cre.TextDescrip.getText());
        String materia = cre.BoxMaterias.getSelectedItem().toString();
        amdl.setMateria(materia);

        int IdMateria = cre.BoxMaterias.getSelectedIndex() + 1;
        amdl.setIdMateria(IdMateria);

        int Periodo = cre.Periodo.getSelectedIndex() + 1;
        amdl.setPeriodo(Periodo);

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

        amdl.setFechaCreacion(timestamp);

        int r = metodosP.Crear(amdl);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(MetodosProf.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Actividad guardada", "Guardado", JOptionPane.OK_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(cre, "Error, intente de nuevo");
        }
    }

    public void ModAct(ActModel amdl) { //Modificar actividad
        int fila = tablaact.Actividades.getSelectedRow();
        int id = Integer.parseInt(tablaact.Actividades.getValueAt(fila, 0).toString());
        amdl.setIdActividad(id);
        String idCurso = act.Box_Cursos.getSelectedItem().toString();
        amdl.setIdCurso(idCurso);
        amdl.setTitulo(eact.TxtTitulo.getText());
        amdl.setDescripcion(eact.TextDescrip.getText());
        String materia = eact.BoxMaterias.getSelectedItem().toString();
        amdl.setMateria(materia);

        int Periodo = eact.Periodo.getSelectedIndex() + 1;
        amdl.setPeriodo(Periodo);

        int IdMateria = eact.BoxMaterias.getSelectedIndex() + 1;
        amdl.setIdMateria(IdMateria);

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

        amdl.setFechaCreacion(timestamp);

        int r = metodosP.Modificar(amdl);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(MetodosProf.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Actividad Actualizada", "Guardado", JOptionPane.OK_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
        }
    }

    public void EliminarAct(ActModel amdl) {
        int fila = tablaact.Actividades.getSelectedRow();
        int id = Integer.parseInt(tablaact.Actividades.getValueAt(fila, 0).toString());
        amdl.setIdActividad(id);

        int r = metodosP.eliminar(amdl);
        if (r == 1) {
            ImageIcon icon = new ImageIcon(MetodosProf.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Actividad Eliminada", "Eliminar", JOptionPane.OK_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
        }
    }

    public void modificarP() {//Modificar información del profesor

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

    public void Calificar() {

        int r = metodosP.Calificar(amdl);
       
        if (r == 1) {

            ImageIcon icon = new ImageIcon(MetodosProf.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Actividad Calificada", "Guardado", JOptionPane.OK_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(cre, "Error, intente de nuevo");
        }
    }

    public void ModCalificar() {

        int r = metodosP.ModCalificar(amdl);

        if (r == 1) {
            ImageIcon icon = new ImageIcon(MetodosProf.class
                    .getResource("/Images/comprobado.png"));
            JOptionPane.showMessageDialog(null, "Actividad Calificada", "Guardado", JOptionPane.OK_OPTION, icon);

        } else {
            JOptionPane.showMessageDialog(cre, "Error, intente de nuevo");
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.Actividades) {
            act.setSize(1360, 770);
            principal.Panel_right.removeAll();
            act.south.removeAll();
            principal.Panel_right.add(act, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(act, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            act.Box_Cursos.setSelectedItem("Seleccione");
            act.btn_editar.setEnabled(true);
            act.btn_crear.setEnabled(true);
            act.btn_eliminar.setEnabled(true);
            // 
        }

        if (e.getSource() == act.btn_buscar) {

            String seleccion = act.Box_Cursos.getSelectedItem().toString();

            if (seleccion.equals("Seleccione")) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN CURSO", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                TblAct();
                obtenerAct(amdl);
                act.btn_editar.setEnabled(true);
                act.btn_crear.setEnabled(true);
                act.btn_eliminar.setEnabled(true);

            }

        }

        if (e.getSource() == act.btn_crear) {
            String seleccion = act.Box_Cursos.getSelectedItem().toString();

            if (seleccion.equals("Seleccione")) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN CURSO", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                cre.setSize(1056, 521);
                act.south.removeAll();
                act.south.add(cre, BorderLayout.CENTER);
                act.south.setComponentZOrder(cre, 0);
                act.south.revalidate();
                act.south.repaint();
                cre.TxtTitulo.setText(null);
                cre.TextDescrip.setText(null);
                cre.BoxMaterias.setSelectedItem(null);
                act.btn_editar.setEnabled(false);
                act.btn_crear.setEnabled(false);
                act.btn_eliminar.setEnabled(false);
            }

        }

        if (e.getSource() == cre.btnCrear) {
            String title = cre.TxtTitulo.getText();
            String Des = cre.TextDescrip.getText();
            String mat = cre.BoxMaterias.getSelectedItem().toString();

            if (title.equals("") || Des.equals("") || mat.equals(null)) {
                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                act.btn_editar.setEnabled(false);
                act.btn_crear.setEnabled(false);
                act.btn_eliminar.setEnabled(false);
                CrearAct(amdl);
                obtenerAct(amdl);
                cre.TxtTitulo.setText(null);
                cre.TextDescrip.setText(null);
                cre.BoxMaterias.setSelectedItem(null);
            }

        }

        if (e.getSource() == cre.btnCancelar) {
            Object[] options = {"Sí", "No"};
            // Cargar un ícono personalizado desde un archivo de imagen
            //ImageIcon icon = new ImageIcon("/Images/boton-eliminar.png");
            ImageIcon icon = new ImageIcon(MetodosProf.class
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
                    tablaact.setSize(1056, 521);

                    act.south.removeAll();
                    act.south.add(tablaact, BorderLayout.CENTER);
                    act.south.setComponentZOrder(tablaact, 0);
                    act.south.revalidate();
                    act.south.repaint();
                    act.btn_editar.setEnabled(true);
                    act.btn_crear.setEnabled(true);
                    act.btn_eliminar.setEnabled(true);
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("El usuario seleccionó 'No'");
                    break;
                default:
                    System.out.println("El usuario cerró el diálogo");
                    break;
            }
        }

        if (e.getSource() == act.btn_editar) {
            if (tablaact.Actividades.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una Actividad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                eact.setSize(1056, 521);
                act.south.removeAll();
                act.south.add(eact, BorderLayout.CENTER);
                act.south.setComponentZOrder(eact, 0);
                act.south.revalidate();
                act.south.repaint();
                seleccionar();
                act.btn_editar.setEnabled(false);
                act.btn_crear.setEnabled(false);
                act.btn_eliminar.setEnabled(false);
            }

        }

        if (e.getSource() == eact.btnCancelar) {
            Object[] options = {"Sí", "No"};
            // Cargar un ícono personalizado desde un archivo de imagen
            //ImageIcon icon = new ImageIcon("/Images/boton-eliminar.png");
            ImageIcon icon = new ImageIcon(MetodosProf.class
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
                    tablaact.setSize(1056, 521);

                    act.south.removeAll();
                    act.south.add(tablaact, BorderLayout.CENTER);
                    act.south.setComponentZOrder(tablaact, 0);
                    act.south.revalidate();
                    act.south.repaint();
                    act.btn_editar.setEnabled(true);
                    act.btn_crear.setEnabled(true);
                    act.btn_eliminar.setEnabled(true);
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("El usuario seleccionó 'No'");
                    break;
                default:
                    System.out.println("El usuario cerró el diálogo");
                    break;
            }
        }

        if (e.getSource() == eact.btnGuardad) {
            String title = eact.TxtTitulo.getText();
            String Des = eact.TextDescrip.getText();
            String mat = eact.BoxMaterias.getSelectedItem().toString();

            if (title.equals("") || Des.equals("") || mat.equals(null)) {
                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ModAct(amdl);

                act.south.removeAll();
                act.south.add(tablaact, BorderLayout.CENTER);
                act.south.setComponentZOrder(tablaact, 0);
                act.south.revalidate();
                act.south.repaint();
                TblAct();
                obtenerAct(amdl);
                act.btn_editar.setEnabled(true);
                act.btn_crear.setEnabled(true);
                act.btn_eliminar.setEnabled(true);
            }
        }

        if (e.getSource() == act.btn_eliminar) {
            if (tablaact.Actividades.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una Actividad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Object[] options = {"Sí", "No"};
                // Cargar un ícono personalizado desde un archivo de imagen
                //ImageIcon icon = new ImageIcon("/Images/boton-eliminar.png");
                ImageIcon icon = new ImageIcon(MetodosProf.class
                        .getResource("/Images/boton-eliminar.png"));

                int choice = JOptionPane.showOptionDialog(
                        null, // Componente padre, null para diálogo independiente
                        "¿Eliminar Actividad?", // Pregunta
                        "Eliminar", // Título del diálogo
                        JOptionPane.YES_NO_OPTION, // Tipo de opciones
                        JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje
                        icon, // Icono personalizado, null para el icono predeterminado
                        options, // Opciones de respuesta
                        options[0]); // Opción predeterminada

                // Verifica la respuesta del usuario
                switch (choice) {
                    case JOptionPane.YES_OPTION:
                        EliminarAct(amdl);
                        TblAct();
                        obtenerAct(amdl);
                        break;
                    case JOptionPane.NO_OPTION:
                        System.out.println("El usuario seleccionó 'No'");
                        break;
                    default:
                        System.out.println("El usuario cerró el diálogo");
                        break;
                }

            }
        }

        if (e.getSource() == act.Respuestas) {
            res.setSize(1100, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(res, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(res, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            TblRes();
            res.btn_ver.setEnabled(true);
            ver.NOTA.setText(null);
            /*resT.setSize(1056, 521);
            res.south.removeAll();
            res.south.add(resT, BorderLayout.CENTER);
            res.south.setComponentZOrder(resT, 0);
            res.south.revalidate();
            res.south.repaint();*/

        }

        if (e.getSource() == res.btn_ver) {
            if (resT.Actividades.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una Respuesta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ver.setSize(1056, 521);
                res.south.removeAll();
                res.south.add(ver, BorderLayout.CENTER);
                res.south.setComponentZOrder(ver, 0);
                res.south.revalidate();
                res.south.repaint();
                seleccionarRes();
                res.btn_ver.setEnabled(false);
                ver.NOTA.setEditable(false);
                
            }
        }

        if (e.getSource() == ver.btnCalificar) {
            String notae = ver.NOTA.getText();
            float nota = amdl.getNota();

            if (nota < 1 || notae.equals(null) || notae.isEmpty()) {
                String notaN = JOptionPane.showInputDialog(null, "Ingresar Nota: ", "Calificar", JOptionPane.OK_CANCEL_OPTION);
                amdl.setNota(Float.parseFloat(notaN));
                Calificar();
                res.setSize(1100, 760);
                principal.Panel_right.removeAll();
                principal.Panel_right.add(res, BorderLayout.CENTER);
                principal.Panel_right.setComponentZOrder(res, 0);
                principal.Panel_right.revalidate();
                principal.Panel_right.repaint();
                TblRes();
                res.btn_ver.setEnabled(true);
      
            } else {
                String notaM = JOptionPane.showInputDialog(null, "Ingresar Nueva Nota: ", "Modificar Nota", JOptionPane.OK_CANCEL_OPTION);
                amdl.setNota(Float.parseFloat(notaM));
                ver.btnCalificar.setText("Modificar");
                ModCalificar();
                res.setSize(1100, 760);
                principal.Panel_right.removeAll();
                principal.Panel_right.add(res, BorderLayout.CENTER);
                principal.Panel_right.setComponentZOrder(res, 0);
                principal.Panel_right.revalidate();
                principal.Panel_right.repaint();
                TblRes();
                res.btn_ver.setEnabled(true);
            
                //MODIFICAR
            }

        }


        if (e.getSource() == ver.btnVolver) {
            res.setSize(1100, 760);
            principal.Panel_right.removeAll();
            principal.Panel_right.add(res, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(res, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            TblRes();
            res.btn_ver.setEnabled(true);
     
            ver.NOTA.setText(null);
        }

        if (e.getSource() == res.atras) {
            act.setSize(1100, 760);
            principal.Panel_right.removeAll();
            act.south.removeAll();
            principal.Panel_right.add(act, BorderLayout.CENTER);
            principal.Panel_right.setComponentZOrder(act, 0);
            principal.Panel_right.revalidate();
            principal.Panel_right.repaint();
            act.Box_Cursos.setSelectedItem("Seleccione");
            act.btn_editar.setEnabled(true);
            act.btn_crear.setEnabled(true);
            act.btn_eliminar.setEnabled(true);
        }

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
            infoP();
            perfil.btn_modificar.setEnabled(false);
            perfil.Btn_cancelar.setEnabled(false);
            perfil.btn_editar.setEnabled(true);

        }

        if (e.getSource() == perfil.btn_modificar) {

            String pass = JOptionPane.showInputDialog(null, "Ingresar Contraseña", "Confirmar Contraseña", JOptionPane.OK_OPTION);

            if (pass.equals(sessionManager.getPassword())) {
                modificarP();
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
                perfil.btn_editar.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == perfil.btn_editar) {
            perfil.btn_editar.setEnabled(false);
            perfil.btn_modificar.setEnabled(true);
            perfil.Btn_cancelar.setEnabled(true);

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
