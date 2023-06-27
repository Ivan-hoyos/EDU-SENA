/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class Respuestasprof extends javax.swing.JPanel {



    public Respuestasprof() {
        initComponents();
      
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        Form = new javax.swing.JPanel();
        Lbl_Cursos = new javax.swing.JLabel();
        North = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        TtlAct = new javax.swing.JLabel();
        south = new FondoPanel();
        North_Action = new javax.swing.JPanel();
        btn_ver = new javax.swing.JButton();
        btn_calif = new javax.swing.JButton();
        comentario = new javax.swing.JToggleButton();
        atras = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setBackground(new java.awt.Color(255, 255, 255));

        Form.setBackground(new java.awt.Color(255, 255, 255));
        Form.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Form.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Lbl_Cursos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Lbl_Cursos.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Cursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Cursos.setText("Respuestas");

        North.setBackground(new java.awt.Color(255, 255, 255));
        North.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actividad Seleccionada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 173, 0))); // NOI18N

        Titulo.setBackground(new java.awt.Color(255, 255, 255));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 173, 0));
        Titulo.setText("Titulo");

        TtlAct.setText("jLabel1");
        TtlAct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout NorthLayout = new javax.swing.GroupLayout(North);
        North.setLayout(NorthLayout);
        NorthLayout.setHorizontalGroup(
            NorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addComponent(TtlAct, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        NorthLayout.setVerticalGroup(
            NorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NorthLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(NorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo)
                    .addComponent(TtlAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        south.setBackground(new java.awt.Color(255, 255, 255));
        south.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        southLayout.setVerticalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        North_Action.setBackground(new java.awt.Color(255, 255, 255));
        North_Action.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 173, 0))); // NOI18N

        btn_ver.setBackground(new java.awt.Color(0, 173, 0));
        btn_ver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_ver.setForeground(new java.awt.Color(255, 255, 255));
        btn_ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        btn_ver.setText("Inspeccionar");

        btn_calif.setBackground(new java.awt.Color(0, 173, 0));
        btn_calif.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_calif.setForeground(new java.awt.Color(255, 255, 255));
        btn_calif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar1.png"))); // NOI18N
        btn_calif.setText("Calificar");

        comentario.setBackground(new java.awt.Color(0, 173, 0));
        comentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/charla.png"))); // NOI18N
        comentario.setText("Comentario");

        javax.swing.GroupLayout North_ActionLayout = new javax.swing.GroupLayout(North_Action);
        North_Action.setLayout(North_ActionLayout);
        North_ActionLayout.setHorizontalGroup(
            North_ActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(North_ActionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_ver)
                .addGap(18, 18, 18)
                .addComponent(btn_calif, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        North_ActionLayout.setVerticalGroup(
            North_ActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, North_ActionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(North_ActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ver)
                    .addComponent(btn_calif, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comentario))
                .addContainerGap())
        );

        atras.setText("Actividades");

        javax.swing.GroupLayout FormLayout = new javax.swing.GroupLayout(Form);
        Form.setLayout(FormLayout);
        FormLayout.setHorizontalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLayout.createSequentialGroup()
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(south, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(FormLayout.createSequentialGroup()
                                .addComponent(Lbl_Cursos)
                                .addGap(18, 18, 18)
                                .addComponent(atras)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(FormLayout.createSequentialGroup()
                        .addComponent(North, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(North_Action, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FormLayout.setVerticalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLayout.createSequentialGroup()
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_Cursos)
                    .addComponent(atras))
                .addGap(18, 18, 18)
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(North_Action, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(North, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(south, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 730));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Form;
    private javax.swing.JLabel Lbl_Cursos;
    private javax.swing.JPanel North;
    private javax.swing.JPanel North_Action;
    private javax.swing.JLabel Titulo;
    public javax.swing.JLabel TtlAct;
    public javax.swing.JButton atras;
    public javax.swing.JButton btn_calif;
    public javax.swing.JButton btn_ver;
    public javax.swing.JToggleButton comentario;
    public javax.swing.JPanel south;
    // End of variables declaration//GEN-END:variables
    
    class FondoPanel extends JPanel{
    private Image imagen;
    
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/Images/jdesktop.png")).getImage();
        
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
        
        setOpaque(false);
        super.paint(g);
    }
}


}
