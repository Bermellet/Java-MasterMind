/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Presentacio;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import javax.swing.UIManager;

public class VistaNovaPartida extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    Boolean botoDificultatClicat = false;
    Boolean botoModeClicat = false;

    public VistaNovaPartida(ControladorPresentacio cp) {
        initComponents();
        cPresentacio = cp;
        
        setLocationRelativeTo(null);
        wrongPlayMode.setVisible(false);
        wrongPlayDif.setVisible(false); //set wrong info initially not visible
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

        titol = new javax.swing.JLabel();
        difText = new javax.swing.JLabel();
        butEasy = new javax.swing.JButton();
        butDif = new javax.swing.JButton();
        difInfo = new javax.swing.JLabel();
        modeText = new javax.swing.JLabel();
        butBreaker = new javax.swing.JButton();
        butMaker = new javax.swing.JButton();
        modeInfo = new javax.swing.JLabel();
        juga = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        wrongPlayDif = new javax.swing.JLabel();
        wrongPlayMode = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nova Partida");
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titol.setFont(new java.awt.Font("Centaur", 1, 64)); // NOI18N
        titol.setForeground(new java.awt.Color(255, 255, 255));
        titol.setText("New Game");
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 320, 50));

        difText.setFont(new java.awt.Font("Centaur", 1, 36)); // NOI18N
        difText.setForeground(new java.awt.Color(255, 255, 255));
        difText.setText("Set dificulty:");
        getContentPane().add(difText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        butEasy.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butEasy.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butEasy.setText("EASY");
        butEasy.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butEasy.setFocusable(false);
        butEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEasyActionPerformed(evt);
            }
        });
        getContentPane().add(butEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 120, 40));

        butDif.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butDif.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butDif.setText("DIFFICULT");
        butDif.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butDif.setFocusable(false);
        butDif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDifActionPerformed(evt);
            }
        });
        getContentPane().add(butDif, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 150, 40));

        difInfo.setFont(new java.awt.Font("Centaur", 2, 24)); // NOI18N
        difInfo.setForeground(new java.awt.Color(204, 204, 204));
        difInfo.setDoubleBuffered(true);
        getContentPane().add(difInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 450, 80));

        modeText.setFont(new java.awt.Font("Centaur", 1, 36)); // NOI18N
        modeText.setForeground(new java.awt.Color(255, 255, 255));
        modeText.setText("Set mode:");
        getContentPane().add(modeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        butBreaker.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butBreaker.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butBreaker.setText("Code BREAKER");
        butBreaker.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butBreaker.setFocusable(false);
        butBreaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBreakerActionPerformed(evt);
            }
        });
        getContentPane().add(butBreaker, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 190, 40));

        butMaker.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butMaker.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butMaker.setText("Code MAKER");
        butMaker.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butMaker.setFocusable(false);
        butMaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMakerActionPerformed(evt);
            }
        });
        getContentPane().add(butMaker, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 190, 40));

        modeInfo.setFont(new java.awt.Font("Centaur", 2, 24)); // NOI18N
        modeInfo.setForeground(new java.awt.Color(204, 204, 204));
        modeInfo.setDoubleBuffered(true);
        getContentPane().add(modeInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 450, 80));

        juga.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        juga.setFont(new java.awt.Font("Centaur", 1, 36)); // NOI18N
        juga.setText("PLAY!");
        juga.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        juga.setFocusable(false);
        juga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugaActionPerformed(evt);
            }
        });
        getContentPane().add(juga, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 530, 230, 60));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/back.png"))); // NOI18N
        back.setToolTipText("");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, 90, 80));

        wrongPlayDif.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        wrongPlayDif.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(wrongPlayDif, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 380, 50));

        wrongPlayMode.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        wrongPlayMode.setForeground(new java.awt.Color(204, 0, 0));
        wrongPlayMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wrongPlayMode.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(wrongPlayMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 380, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/fondoPrincipal2.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butDifActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (!botoDificultatClicat) botoDificultatClicat = true;
        if (wrongPlayDif.isVisible()) wrongPlayDif.setVisible(false);
        
        butDif.setFocusable(false);
        butDif.setEnabled(false);
        butDif.setBackground(Color.GRAY);
        butDif.setBorderPainted(false);
        
        butEasy.setFocusable(true);
        butEasy.setEnabled(true);
        butEasy.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        butEasy.setBorderPainted(true);
        
        difInfo.setText("<html>Dificultat difícil: 8 colors disponibles<br>i 6 utilitzats. Poden haver-hi dos repetits.</html>");
    }                                      

    private void butEasyActionPerformed(java.awt.event.ActionEvent evt) { 
        if (!botoDificultatClicat) botoDificultatClicat = true;
        if (wrongPlayDif.isVisible()) wrongPlayDif.setVisible(false);
        
        butEasy.setFocusable(false);
        butEasy.setEnabled(false);
        butEasy.setBackground(Color.GRAY);
        butEasy.setBorderPainted(false);
        
        butDif.setFocusable(true);
        butDif.setEnabled(true);
        butDif.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        butDif.setBorderPainted(true);
        
        difInfo.setText("<html>Dificultat fàcil: 8 colors disponibles<br>i 4 utilitzats. No poden haver-hi repetits.</html>");
    }                                       

    private void butMakerActionPerformed(java.awt.event.ActionEvent evt) {
        if (!botoModeClicat) botoModeClicat = true;
        if (wrongPlayMode.isVisible()) wrongPlayMode.setVisible(false);
        
        butMaker.setFocusable(false);
        butMaker.setEnabled(false);
        butMaker.setBackground(Color.GRAY);
        butMaker.setBorderPainted(false);
        
        butBreaker.setFocusable(true);
        butBreaker.setEnabled(true);
        butBreaker.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        butBreaker.setBorderPainted(true);
        
        modeInfo.setText("<html>Code Maker: fes el teu codi i deixa<br>que la màquina intenti resoldre'l!</html>");
    }                                        

    private void butBreakerActionPerformed(java.awt.event.ActionEvent evt) {
        if (!botoModeClicat) botoModeClicat = true;
        if (wrongPlayMode.isVisible()) wrongPlayMode.setVisible(false);
        
        butBreaker.setFocusable(false);
        butBreaker.setEnabled(false);
        butBreaker.setBackground(Color.GRAY);
        butBreaker.setBorderPainted(false);
        
        butMaker.setFocusable(true);
        butMaker.setEnabled(true);
        butMaker.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        butMaker.setBorderPainted(true);
        
        modeInfo.setText("<html>Code Breaker: seràs capaç de resoldre<br>el codi que la màquina et genera?</html>");
    }                                          

    private void jugaActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (!botoDificultatClicat){
            wrongPlayDif.setVisible(true);
            wrongPlayDif.setText("<html><div style='text-align: center;'>Has de seleccionar una dificultat abans<br>d'iniciar la partida.</html>");
            return;
        }
        else if (!botoModeClicat){
            wrongPlayMode.setVisible(true);
            wrongPlayMode.setText("<html><div style='text-align: center;'>Has de seleccionar un mode abans d'iniciar<br>la partida.</html>");
            return;
        }
        
        String dif, mode;
        if (butBreaker.isEnabled()) mode = butMaker.getText();
        else mode = butBreaker.getText();
        
        if (butEasy.isEnabled()) dif = butDif.getText();
        else dif = butEasy.getText();
        
        // Corregim el valor llegit de dificultat
        if (dif.equals("EASY")) dif = "facil";
        else dif = "dificil";
        
        if (!butMaker.isEnabled()){ // Si ha seleccionado la opcion de Maker passem a introduir la solucio
            cPresentacio.sincroNovaPartida_a_IntroMaker(dif);
        }
        else{ //Si ha seleccionat l'opcio de Breaker podem començar directament
            List<Integer> buida = new ArrayList<>();
            
            cPresentacio.cridaControladorPartida_CrearPartida(dif, "CB", buida);
            cPresentacio.sincroNovaPartida_a_Partida(dif);
        }
    }                                    

    private void backMouseClicked(java.awt.event.MouseEvent evt) {                                  
        cPresentacio.sincroNovaPartida_a_MenuPrincipal();       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton butBreaker;
    private javax.swing.JButton butDif;
    private javax.swing.JButton butEasy;
    private javax.swing.JButton butMaker;
    private javax.swing.JLabel difInfo;
    private javax.swing.JLabel difText;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton juga;
    private javax.swing.JLabel modeInfo;
    private javax.swing.JLabel modeText;
    private javax.swing.JLabel titol;
    private javax.swing.JLabel wrongPlayDif;
    private javax.swing.JLabel wrongPlayMode;
    // End of variables declaration//GEN-END:variables
}
