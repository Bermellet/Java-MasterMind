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
public class VistaAjuda extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    /**
     * Creates new form VistaAjuda
     * @param cp
     */
    public VistaAjuda(ControladorPresentacio cp) {
        cPresentacio = cp;
        initComponents();
        setLocationRelativeTo(null);
        panelMaker.setOpaque(false);
        panelMaker.getViewport().setOpaque(false);
        infoMaker.setOpaque(false);
        infoMaker.setForeground(new Color(255,255,255)); //letras blancas
        
        panelMode.setOpaque(false);
        panelMode.getViewport().setOpaque(false);
        infoMode.setOpaque(false);
        infoMode.setForeground(new Color(255,255,255)); //letras blancas
        
        panelBreak.setOpaque(false);
        panelBreak.getViewport().setOpaque(false);
        infoBreak.setOpaque(false);
        infoBreak.setForeground(new Color(255,255,255)); //letras blancas
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

        butClose = new javax.swing.JButton();
        panelMaker = new javax.swing.JScrollPane();
        infoMaker = new javax.swing.JTextArea();
        panelMode = new javax.swing.JScrollPane();
        infoMode = new javax.swing.JTextArea();
        panelBreak = new javax.swing.JScrollPane();
        infoBreak = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        gifMode = new javax.swing.JLabel();
        gifMaker = new javax.swing.JLabel();
        gifBreak = new javax.swing.JLabel();
        titol = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajuda");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butClose.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butClose.setFont(new java.awt.Font("Centaur", 0, 24)); // NOI18N
        butClose.setText("GOT IT!");
        butClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCloseActionPerformed(evt);
            }
        });
        getContentPane().add(butClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, 200, 40));

        panelMaker.setBackground(new java.awt.Color(255, 255, 255));
        panelMaker.setBorder(null);

        infoMaker.setEditable(false);
        infoMaker.setColumns(1);
        infoMaker.setFont(new java.awt.Font("Centaur", 0, 18)); // NOI18N
        infoMaker.setLineWrap(true);
        infoMaker.setRows(1);
        infoMaker.setTabSize(1);
        infoMaker.setText("Si jugues com a Code Maker hauràs de fer la teva pròpia solució i deixar que l'ordinador la resolgui. Selecciona la bola que vols modificar i fes click sobre la que vols col·locar!");
        infoMaker.setWrapStyleWord(true);
        infoMaker.setBorder(null);
        panelMaker.setViewportView(infoMaker);

        getContentPane().add(panelMaker, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 260, 110));

        panelMode.setBackground(new java.awt.Color(255, 255, 255));
        panelMode.setBorder(null);

        infoMode.setEditable(false);
        infoMode.setColumns(1);
        infoMode.setFont(new java.awt.Font("Centaur", 0, 18)); // NOI18N
        infoMode.setLineWrap(true);
        infoMode.setRows(1);
        infoMode.setText("Selecciona el mode que vols i clica \"començar partida\". També pots carregar una partida o veure els rècords actuals des del menú principal!");
        infoMode.setWrapStyleWord(true);
        infoMode.setBorder(null);
        panelMode.setViewportView(infoMode);

        getContentPane().add(panelMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 270, 90));

        panelBreak.setBackground(new java.awt.Color(255, 255, 255));
        panelBreak.setBorder(null);

        infoBreak.setEditable(false);
        infoBreak.setColumns(1);
        infoBreak.setFont(new java.awt.Font("Centaur", 0, 18)); // NOI18N
        infoBreak.setLineWrap(true);
        infoBreak.setRows(1);
        infoBreak.setTabSize(1);
        infoBreak.setText("Si jugues com a Code Breaker hauràs d'endevinar la seqüència correcta,\n\t- Blanques: color correcte però no la seva posició\n\t- Negres: color i posició correctes");
        infoBreak.setWrapStyleWord(true);
        infoBreak.setBorder(null);
        panelBreak.setViewportView(infoBreak);

        getContentPane().add(panelBreak, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 260, 110));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 460, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 460, 10));

        gifMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/seleccionar_modeRes.gif"))); // NOI18N
        getContentPane().add(gifMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        gifMaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/introMakerRes.gif"))); // NOI18N
        getContentPane().add(gifMaker, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        gifBreak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/introBreakerRes.gif"))); // NOI18N
        getContentPane().add(gifBreak, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        titol.setFont(new java.awt.Font("Centaur", 1, 48)); // NOI18N
        titol.setForeground(new java.awt.Color(255, 255, 255));
        titol.setText("Help");
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/fondoPrincipal2.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCloseActionPerformed
        cPresentacio.sincroAjuda_a_MenuPrincipal();
    }//GEN-LAST:event_butCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butClose;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel gifBreak;
    private javax.swing.JLabel gifMaker;
    private javax.swing.JLabel gifMode;
    private javax.swing.JTextArea infoBreak;
    private javax.swing.JTextArea infoMaker;
    private javax.swing.JTextArea infoMode;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane panelBreak;
    private javax.swing.JScrollPane panelMaker;
    private javax.swing.JScrollPane panelMode;
    private javax.swing.JLabel titol;
    // End of variables declaration//GEN-END:variables
}
