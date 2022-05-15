/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Presentacio;

import java.awt.Color;

/**
 *
 * @author albert
 */
public class VistaIntroGuardar extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    Boolean first = true;
    /**
     * Creates new form VistaIntroGuardar
     * @param cp
     */
    public VistaIntroGuardar(ControladorPresentacio cp) {
        initComponents();
        cPresentacio = cp;
        setLocationRelativeTo(null);
        setDefaultHint();
    }
    private void setDefaultHint(){
        nomPartida.setFont(new java.awt.Font("Ebrima", 2, 14));
        nomPartida.setForeground(new Color(191,191,191));
        nomPartida.setText("Introdueix el nom desitjat");
        nomPartida.setCaretPosition(0);
    }
    public void ferVisible(){
        pack();
        setVisible(true);
    }
    public void ferInvisible(){
        setVisible(false);
    }
    public void activar(){
        setEnabled(true);
    }
    public void desactivar(){
        setEnabled(false);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butCancel = new javax.swing.JButton();
        butAccept = new javax.swing.JButton();
        nomPartida = new javax.swing.JTextField();
        titol = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 250));
        setPreferredSize(new java.awt.Dimension(500, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butCancel.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butCancel.setText("CANCEL");
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });
        getContentPane().add(butCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, 40));

        butAccept.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butAccept.setText("ACCEPT");
        butAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAcceptActionPerformed(evt);
            }
        });
        getContentPane().add(butAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 110, 40));

        nomPartida.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        nomPartida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomPartidaKeyPressed(evt);
            }
        });
        getContentPane().add(nomPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 420, 40));

        titol.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        titol.setText("Introdueix el nom per a guardar la teva partida:");
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 20, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        cPresentacio.sincroIntroGuardar_a_Partida();
    }//GEN-LAST:event_butCancelActionPerformed

    private void butAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAcceptActionPerformed
        cPresentacio.sincroIntroGuardar_a_MenuPrincipal(nomPartida.getText());
    }//GEN-LAST:event_butAcceptActionPerformed

    private void nomPartidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomPartidaKeyPressed
        if (first && evt.getKeyCode() != 8){ //No comptem backspaces
            nomPartida.setForeground(new Color(20,20,20));
            nomPartida.setFont(new java.awt.Font("Ebrima", 1, 14));
            nomPartida.setText(""); //borrem pista
            first = false;
        }
        else if (nomPartida.getText().length() == 1 && evt.getKeyCode() == 8){
            setDefaultHint();
            first = true;
        }
    }//GEN-LAST:event_nomPartidaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAccept;
    private javax.swing.JButton butCancel;
    private javax.swing.JTextField nomPartida;
    private javax.swing.JLabel titol;
    // End of variables declaration//GEN-END:variables
}
