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
public class PanelVerHoras extends javax.swing.JFrame {

    HorasController controller;
    /**
     * Creates new form PanelHoras
     */
    public PanelVerHoras(HorasController controller) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstJornadas = new javax.swing.JList<>();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnMesAnterior = new javax.swing.JButton();
        btnMesSiguiente = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnCalcularSueldo = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstJornadas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lstJornadas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstJornadas);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("-");

        btnVolver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnVolver.setText("Inicio");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnMesAnterior.setText("Mes Anterior");
        btnMesAnterior.setActionCommand("btnMesAnterior");
        btnMesAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesAnteriorActionPerformed(evt);
            }
        });

        btnMesSiguiente.setText("Mes siguiente");
        btnMesSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesSiguienteActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnSalir1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnCalcularSueldo.setText("Calcular Sueldo");
        btnCalcularSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularSueldoActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMesAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExportar)
                                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnMesSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalcularSueldo)
                                    .addComponent(btnSalir1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesAnterior)
                    .addComponent(btnMesSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(btnCalcularSueldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir1)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         controller.iniciarJornada(null, this, null);   
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnMesSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesSiguienteActionPerformed
        controller.mesSiguiente(this);
    }//GEN-LAST:event_btnMesSiguienteActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        controller.salir(null, this, null, null);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        
        if(lblMensaje.getText().equals("Jeje todavia no lo hice")){
            lblMensaje.setText("No hay nada amigo");
        }
        else if(lblMensaje.getText().equals("No hay nada amigo")){
            lblMensaje.setText("No me toques mas gil");
            
        }
        else if(lblMensaje.getText().equals("No me toques mas gil")){
            
            lblMensaje.setText("Ah sos chistoso");
        }
        else if(lblMensaje.getText().equals("Ah sos chistoso")){
            
            lblMensaje.setText("Por que no me exportas esta");
        }
        else if(lblMensaje.getText().equals("Por que no me exportas esta")){
            
            lblMensaje.setText("Alla la estan exportando");
        }        
        else if(lblMensaje.getText().equals("Alla la estan exportando")){
            
            lblMensaje.setText("Bueno dale, toca una vez mas");
        }
        else if(lblMensaje.getText().equals("Bueno dale, toca una vez mas")){
            lblMensaje.setText("Dale, te exporto. Rompehuevos");
        }
//        else if(lblMensaje.getText().equals("Alla la estan exportando")){
//            
//            lblMensaje.setText("Posta, una mas y me voy");
//        }
//        else if(lblMensaje.getText().equals("Posta, una mas y me voy")){
//            lblMensaje.setText("Jodete");
//            lblMensaje.repaint();
//            btnExportarActionPerformed(evt);
//        }
//        else if(lblMensaje.getText().equals("Jodete")){
//            try{
//                Thread.sleep(3000);
//            }
//            catch(Exception e){
//                
//            }
//            controller.salir(null, this, null, null);
//        }
     
     
        else{
            controller.exportarXls();
            lblMensaje.setText("Jeje todavia no lo hice");
        }
        
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnMesAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesAnteriorActionPerformed
        controller.mesAnterior(this);
    }//GEN-LAST:event_btnMesAnteriorActionPerformed

    private void btnCalcularSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularSueldoActionPerformed
        controller.vistaCalcularSueldo(this);
    }//GEN-LAST:event_btnCalcularSueldoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularSueldo;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnMesAnterior;
    private javax.swing.JButton btnMesSiguiente;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> lstJornadas;
    // End of variables declaration//GEN-END:variables

    public void setListHoras(List<String> jornadasMesActual) {
        String[] lista = new String[jornadasMesActual.size()];
        
        for(int i=0; i<jornadasMesActual.size(); i++){
            lista[i]=jornadasMesActual.get(i);
        }
        lstJornadas.setListData(lista);
        lstJornadas.repaint();
    }
    
    public void setMesLabel(){
        lblTitulo.setText(controller.getMesActualString() + " " + controller.getAnioActual());
    }
}
