/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Presentacio;

/**
 *
 * @author albert
 */
public class VistaBolaAjuda extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    int bolaAMostrar;
    
    public VistaBolaAjuda(ControladorPresentacio cp, int bola) {
        cPresentacio = cp;
        bolaAMostrar = bola;
        initComponents();
        setLocationRelativeTo(null);
        setBolaCorrecta();
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
    private void setBolaCorrecta(){
        if (bolaAMostrar == 1)
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucAmarillaDestac.png")));
        else if (bolaAMostrar == 2) 
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucNaranjaDestac.png")));
        else if (bolaAMostrar == 3) 
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucRojaDestac.png")));
        else if (bolaAMostrar == 4)
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucRosaDestac.png")));
        else if (bolaAMostrar == 5) 
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVerdeDestac.png")));
        else if (bolaAMostrar == 6) 
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucAzulDestac.png")));
        else if (bolaAMostrar == 7) 
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVioletaDestac.png")));
        else if (bolaAMostrar == 8) 
            bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucMarronDestac.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titol = new javax.swing.JLabel();
        bola = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajuda");
        setMinimumSize(new java.awt.Dimension(300, 320));
        setPreferredSize(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titol.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        titol.setText("Aquesta bola està a la solució:");
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 44));

        bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucMarronDestac.png"))); // NOI18N
        getContentPane().add(bola, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        jButton1.setFont(new java.awt.Font("Centaur", 0, 18)); // NOI18N
        jButton1.setText("Tanca");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 260, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cPresentacio.sincroBolaAjuda_a_Partida();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bola;
    private javax.swing.JButton butClose;
    private javax.swing.JButton butClose1;
    private javax.swing.JButton butClose2;
    private javax.swing.JButton butClose3;
    private javax.swing.JButton butClose4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel titol;
    // End of variables declaration//GEN-END:variables
}
