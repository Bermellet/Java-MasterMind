package mastermind72.Presentacio;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import mastermind72.Classes.Pair;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class VistaRankings extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    
    public VistaRankings(ControladorPresentacio cp) {
        initComponents();
        cPresentacio = cp;
        setLocationRelativeTo(null);
        
        // Posem el facil per defecte
        butEasy.setFocusable(false);
        butEasy.setEnabled(false);
        butEasy.setBackground(Color.GRAY);
        butEasy.setBorderPainted(false);
        panelRecords.setOpaque(false);
        setRanking("facil");
    }
    private void setRanking(String dif){
        List<Pair<String,Integer>> rankings = cPresentacio.cridaControladorRanking_GetRankings(dif);
        int incrY = 35;
        int i = 0;

        panelRecords.removeAll();
        repaint();
        for (Pair<String,Integer> r : rankings){
            nom = new JLabel(r.getLeft());
            nom.setVisible(true);
            nom.setForeground(Color.WHITE);
            nom.setFont(new java.awt.Font("Centaur", 1, 24));
            panelRecords.add(nom, new AbsoluteConstraints(10,-80 + i*incrY,200,200));
            
            punct = new JLabel(String.valueOf(r.getRight()));
            punct.setBackground(Color.WHITE);
            punct.setForeground(Color.WHITE);
            punct.setFont(new java.awt.Font("Centaur", 1, 24));
            panelRecords.add(punct, new AbsoluteConstraints(480,-80 + i*incrY,200,200));
            
            ++i;
        }
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

        butDif = new javax.swing.JButton();
        butEasy = new javax.swing.JButton();
        punctuation = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        panelRecords = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        titol = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rankings actuals");
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butDif.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butDif.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butDif.setText("DIFFICULT");
        butDif.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butDif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDifActionPerformed(evt);
            }
        });
        getContentPane().add(butDif, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 590, 190, 40));

        butEasy.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butEasy.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butEasy.setText("EASY");
        butEasy.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEasyActionPerformed(evt);
            }
        });
        getContentPane().add(butEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 590, 190, 40));

        punctuation.setFont(new java.awt.Font("Centaur", 1, 30)); // NOI18N
        punctuation.setForeground(new java.awt.Color(255, 255, 255));
        punctuation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punctuation.setText("Punctuation");
        getContentPane().add(punctuation, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        name.setFont(new java.awt.Font("Centaur", 1, 30)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Name");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        panelRecords.setBackground(new java.awt.Color(39, 39, 44));
        panelRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 690, 350));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 670, 10));

        titol.setFont(new java.awt.Font("Centaur", 1, 64)); // NOI18N
        titol.setForeground(new java.awt.Color(255, 255, 255));
        titol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titol.setText("See rankings");
        titol.setPreferredSize(null);
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 74, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, 90, 80));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/fondoPrincipal2.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        cPresentacio.sincroRankings_a_MenuPrincipal();
    }//GEN-LAST:event_backMouseClicked

    private void butEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEasyActionPerformed
        butEasy.setFocusable(false);
        butEasy.setEnabled(false);
        butEasy.setBackground(Color.GRAY);
        butEasy.setBorderPainted(false);
        
        butDif.setFocusable(true);
        butDif.setEnabled(true);
        butDif.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        butDif.setBorderPainted(true);
        setRanking("facil");
    }//GEN-LAST:event_butEasyActionPerformed

    private void butDifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDifActionPerformed
        butDif.setFocusable(false);
        butDif.setEnabled(false);
        butDif.setBackground(Color.GRAY);
        butDif.setBorderPainted(false);
        
        butEasy.setFocusable(true);
        butEasy.setEnabled(true);
        butEasy.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        butEasy.setBorderPainted(true);
        setRanking("dificil");
    }//GEN-LAST:event_butDifActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton butDif;
    private javax.swing.JButton butEasy;
    private javax.swing.JLabel fondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel name;
    private javax.swing.JPanel panelRecords;
    private javax.swing.JLabel punctuation;
    private javax.swing.JLabel titol;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel nom;
    private javax.swing.JLabel punct;
    
}
