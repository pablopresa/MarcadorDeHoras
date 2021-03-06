/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.project.horas.view;

import com.project.horas.controller.HorasController;
import java.util.List;

/**
 *
 * @author Pablo Presa
 */
public class CalcularSueldo extends javax.swing.JFrame {

    HorasController controller;
    /**
     * Creates new form CalcularSueldo
     */
    public CalcularSueldo(HorasController controller) {
        initComponents();
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSueldoBase = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDesglose = new javax.swing.JList<>();
        btnSalir = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnHoras = new javax.swing.JButton();
        lblHorasExtra = new javax.swing.JLabel();
        txtHorasExtra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSueldoBase.setToolTipText("Sueldo base nominal");
        txtSueldoBase.setName(""); // NOI18N

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel1.setText("Sueldo base (Nominal)");

        jScrollPane1.setViewportView(lstDesglose);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnHoras.setText("Horas");
        btnHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorasActionPerformed(evt);
            }
        });

        lblHorasExtra.setText("Horas extra (opcional)");

        txtHorasExtra.setToolTipText("Sueldo base nominal");
        txtHorasExtra.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblHorasExtra)
                                        .addComponent(txtHorasExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(btnCalcular))
                                        .addComponent(txtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnSalir)
                        .addGap(18, 18, 18)
                        .addComponent(btnInicio)
                        .addGap(18, 18, 18)
                        .addComponent(btnHoras)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHorasExtra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHorasExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnInicio)
                    .addComponent(btnHoras))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lblHorasExtra.getAccessibleContext().setAccessibleName("lblHorasExtra");
        txtHorasExtra.getAccessibleContext().setAccessibleDescription("Horas extra");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        controller.calcularSueldo(txtSueldoBase.getText(), txtHorasExtra.getText(), this);
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        controller.salir(null, null, null, this);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        controller.iniciarJornada(null, null, this);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorasActionPerformed
        controller.verHoras(null, null, this);
    }//GEN-LAST:event_btnHorasActionPerformed

    public void imprimir(List<String> impresiones){
        String[] lista = new String[impresiones.size()];
        
        for(int i=0; i<impresiones.size(); i++){
            lista[i]=impresiones.get(i);
        }
        lstDesglose.setListData(lista);
        lstDesglose.repaint();
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnHoras;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHorasExtra;
    private javax.swing.JList<String> lstDesglose;
    private javax.swing.JTextField txtHorasExtra;
    private javax.swing.JTextField txtSueldoBase;
    // End of variables declaration//GEN-END:variables
}
