/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author Aprendiz
 */
public class Teachers extends javax.swing.JPanel {

    public Teachers() {
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
        North_panel = new javax.swing.JPanel();
        btn_crear = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_moficar = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Form = new javax.swing.JPanel();
        Lbl_Student = new javax.swing.JLabel();
        Lbl_Document = new javax.swing.JLabel();
        Txt_Documentp = new javax.swing.JTextField();
        Lbl_Name1 = new javax.swing.JLabel();
        Txt_namep = new javax.swing.JTextField();
        Lbl_LastName = new javax.swing.JLabel();
        Txt_LastNamep = new javax.swing.JTextField();
        Lbl_Direction = new javax.swing.JLabel();
        Txt_Directionp = new javax.swing.JTextField();
        Lbl_Telephone = new javax.swing.JLabel();
        Txt_telephonep = new javax.swing.JTextField();
        Lbl_Email = new javax.swing.JLabel();
        Txt_emailp = new javax.swing.JTextField();
        Lbl_password = new javax.swing.JLabel();
        Txt_passwordp = new javax.swing.JTextField();
        Materia = new javax.swing.JComboBox<>();
        Lbl_Email1 = new javax.swing.JLabel();
        table_container = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablap = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setBackground(new java.awt.Color(255, 255, 255));

        North_panel.setBackground(new java.awt.Color(0, 173, 0));
        North_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        North_panel.setOpaque(false);

        btn_crear.setBackground(new java.awt.Color(0, 173, 0));
        btn_crear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_crear.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear.setText("Crear");
        btn_crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        btn_limpiar.setBackground(new java.awt.Color(0, 173, 0));
        btn_limpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setText("Limpiar Campos");
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_moficar.setBackground(new java.awt.Color(0, 173, 0));
        btn_moficar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_moficar.setForeground(new java.awt.Color(255, 255, 255));
        btn_moficar.setText("Modificar");
        btn_moficar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_moficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moficarActionPerformed(evt);
            }
        });

        Btn_Delete.setBackground(new java.awt.Color(0, 173, 0));
        Btn_Delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Btn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Delete.setText("Eliminar");
        Btn_Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout North_panelLayout = new javax.swing.GroupLayout(North_panel);
        North_panel.setLayout(North_panelLayout);
        North_panelLayout.setHorizontalGroup(
            North_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(North_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(North_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_moficar, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        North_panelLayout.setVerticalGroup(
            North_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, North_panelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_moficar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        Form.setBackground(new java.awt.Color(255, 255, 255));
        Form.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Lbl_Student.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Lbl_Student.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Student.setText("Nuevo Profesor");

        Lbl_Document.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_Document.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Document.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Document.setText("N. Documento");

        Txt_Documentp.setBackground(new java.awt.Color(235, 235, 235));
        Txt_Documentp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_Name1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_Name1.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Name1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Name1.setText("Nombres");

        Txt_namep.setBackground(new java.awt.Color(235, 235, 235));
        Txt_namep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_LastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_LastName.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_LastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_LastName.setText("Apellidos");

        Txt_LastNamep.setBackground(new java.awt.Color(235, 235, 235));
        Txt_LastNamep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_Direction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_Direction.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Direction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Direction.setText("Dirección");

        Txt_Directionp.setBackground(new java.awt.Color(235, 235, 235));
        Txt_Directionp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_Telephone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_Telephone.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Telephone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Telephone.setText("Teléfono");

        Txt_telephonep.setBackground(new java.awt.Color(235, 235, 235));
        Txt_telephonep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_Email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_Email.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Email.setText("Email");

        Txt_emailp.setBackground(new java.awt.Color(235, 235, 235));
        Txt_emailp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_password.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_password.setText("Contraseña");

        Txt_passwordp.setBackground(new java.awt.Color(235, 235, 235));
        Txt_passwordp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matemáticas", "Ciencias Naturales", "Lenguaje y Literatura", "Historia", "Geografía", "Educación Física", "Artes", "Música", "Inglés", "Tecnología" }));

        Lbl_Email1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lbl_Email1.setForeground(new java.awt.Color(0, 173, 0));
        Lbl_Email1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Email1.setText("Profesión");

        javax.swing.GroupLayout FormLayout = new javax.swing.GroupLayout(Form);
        Form.setLayout(FormLayout);
        FormLayout.setHorizontalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_Student)
                    .addGroup(FormLayout.createSequentialGroup()
                        .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FormLayout.createSequentialGroup()
                                .addComponent(Lbl_Document)
                                .addGap(42, 42, 42)
                                .addComponent(Txt_Documentp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(FormLayout.createSequentialGroup()
                                        .addComponent(Lbl_Name1)
                                        .addGap(229, 229, 229)
                                        .addComponent(Lbl_LastName))
                                    .addGroup(FormLayout.createSequentialGroup()
                                        .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Lbl_Email)
                                            .addComponent(Lbl_Email1))
                                        .addGap(52, 52, 52)
                                        .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Txt_namep, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                            .addComponent(Txt_emailp)
                                            .addComponent(Materia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lbl_Telephone))))
                            .addGroup(FormLayout.createSequentialGroup()
                                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lbl_Direction)
                                    .addComponent(Lbl_password))
                                .addGap(67, 67, 67)
                                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txt_Directionp, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(Txt_passwordp))))
                        .addGap(18, 18, 18)
                        .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_telephonep)
                            .addComponent(Txt_LastNamep, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FormLayout.setVerticalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lbl_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Lbl_Document, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Lbl_Name1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txt_namep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Lbl_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txt_LastNamep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txt_Documentp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Direction, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Directionp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_emailp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_Telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_telephonep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_passwordp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_Email1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        table_container.setBackground(new java.awt.Color(255, 255, 255));
        table_container.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Tablap.setBackground(new java.awt.Color(255, 255, 255));
        Tablap.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Tablap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Documento", "Nombres", "Apellidos", "Profesión", "Telefono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tablap);
        if (Tablap.getColumnModel().getColumnCount() > 0) {
            Tablap.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout table_containerLayout = new javax.swing.GroupLayout(table_container);
        table_container.setLayout(table_containerLayout);
        table_containerLayout.setHorizontalGroup(
            table_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        table_containerLayout.setVerticalGroup(
            table_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_containerLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(table_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addComponent(Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(North_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(132, 132, 132))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(North_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 790));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed


    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed

    }//GEN-LAST:event_btn_crearActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    private void btn_moficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moficarActionPerformed
        // Modificar

    }//GEN-LAST:event_btn_moficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_Delete;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Form;
    private javax.swing.JLabel Lbl_Direction;
    private javax.swing.JLabel Lbl_Document;
    private javax.swing.JLabel Lbl_Email;
    private javax.swing.JLabel Lbl_Email1;
    private javax.swing.JLabel Lbl_LastName;
    private javax.swing.JLabel Lbl_Name1;
    private javax.swing.JLabel Lbl_Student;
    private javax.swing.JLabel Lbl_Telephone;
    private javax.swing.JLabel Lbl_password;
    public javax.swing.JComboBox<String> Materia;
    private javax.swing.JPanel North_panel;
    public javax.swing.JTable Tablap;
    public javax.swing.JTextField Txt_Directionp;
    public javax.swing.JTextField Txt_Documentp;
    public javax.swing.JTextField Txt_LastNamep;
    public javax.swing.JTextField Txt_emailp;
    public javax.swing.JTextField Txt_namep;
    public javax.swing.JTextField Txt_passwordp;
    public javax.swing.JTextField Txt_telephonep;
    public javax.swing.JButton btn_crear;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_moficar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel table_container;
    // End of variables declaration//GEN-END:variables

}
