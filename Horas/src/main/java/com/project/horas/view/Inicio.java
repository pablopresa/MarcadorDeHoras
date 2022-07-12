package com.project.horas.view;

import com.project.horas.Interface.IPanel;
import com.project.horas.controller.HorasController;

/**
 *
 * @author Pablo Presa
 */
public class Inicio extends javax.swing.JFrame implements IPanel {

    HorasController controller;
    
    public Inicio(HorasController controller) {
        initComponents();
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCancelar = new javax.swing.JButton();
        btnIniciarJornada = new javax.swing.JButton();
        btnVerHoras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCancelar.setText("Salir");
        txtCancelar.setActionCommand("No");
        txtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancelarActionPerformed(evt);
            }
        });

        btnIniciarJornada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnIniciarJornada.setText("Iniciar Jornada");
        btnIniciarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarJornadaActionPerformed(evt);
            }
        });

        btnVerHoras.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnVerHoras.setText("Ver Horas");
        btnVerHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(txtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnVerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnVerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(txtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancelarActionPerformed
        controller.salir(this, null, null, null);
    }//GEN-LAST:event_txtCancelarActionPerformed

    private void btnIniciarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarJornadaActionPerformed
        controller.iniciarJornada(this, null, null);
    }//GEN-LAST:event_btnIniciarJornadaActionPerformed

    private void btnVerHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHorasActionPerformed
        controller.verHoras(this, null, null);
    }//GEN-LAST:event_btnVerHorasActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarJornada;
    private javax.swing.JButton btnVerHoras;
    private javax.swing.JButton txtCancelar;
    // End of variables declaration//GEN-END:variables
}
