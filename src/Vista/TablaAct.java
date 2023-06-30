/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.table.TableColumn;

/**
 *
 * @author CPE
 */
public class TablaAct extends javax.swing.JPanel {

    /**
     * Creates new form TablaAct
     */
    public TablaAct() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Actividades = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 173, 0))); // NOI18N

        Actividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Actividad", "Nombre Actividad", "Descripción", "Fecha Creación", "Documento Prof", "Curso", "Cod Materia", "Materia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Actividades);
        if (Actividades.getColumnModel().getColumnCount() > 0) {
            Actividades.getColumnModel().getColumn(0).setResizable(false);
            Actividades.getColumnModel().getColumn(1).setResizable(false);
            Actividades.getColumnModel().getColumn(2).setResizable(false);
            Actividades.getColumnModel().getColumn(3).setResizable(false);
            Actividades.getColumnModel().getColumn(4).setResizable(false);
            Actividades.getColumnModel().getColumn(5).setResizable(false);
            Actividades.getColumnModel().getColumn(6).setResizable(false);
            Actividades.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Actividades;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
