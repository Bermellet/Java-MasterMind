package mastermind72.Presentacio;

/**
 *
 * @author albert
 */
public class VistaMenuPrincipal extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    /**
     * Creates new form VistaMenuPrincipal
     * @param cp
     */
    public VistaMenuPrincipal(ControladorPresentacio cp) {
        cPresentacio = cp;
        initComponents();    
        setLocationRelativeTo(null);
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

        NewGame = new javax.swing.JButton();
        LoadGame = new javax.swing.JButton();
        ExitApp = new javax.swing.JButton();
        SeeRanks = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mastermind");
        setBackground(new java.awt.Color(178, 142, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.magenta);
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewGame.setBackground(new java.awt.Color(95, 49, 11));
        NewGame.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        NewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/IconNewGame.png"))); // NOI18N
        NewGame.setToolTipText("");
        NewGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NewGame.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/IconNewGame.png"))); // NOI18N
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });
        getContentPane().add(NewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 240, 330, 80));
        NewGame.getAccessibleContext().setAccessibleName("Play Game");

        LoadGame.setBackground(new java.awt.Color(95, 49, 11));
        LoadGame.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        LoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/IconLoadGame.png"))); // NOI18N
        LoadGame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        LoadGame.setFocusable(false);
        LoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadGameActionPerformed(evt);
            }
        });
        getContentPane().add(LoadGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 350, 330, 80));

        ExitApp.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        ExitApp.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        ExitApp.setText("Exit Application");
        ExitApp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        ExitApp.setFocusable(false);
        ExitApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitAppActionPerformed(evt);
            }
        });
        getContentPane().add(ExitApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, 240, 40));

        SeeRanks.setBackground(new java.awt.Color(95, 49, 11));
        SeeRanks.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        SeeRanks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/IconSeeRanks.png"))); // NOI18N
        SeeRanks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SeeRanks.setFocusable(false);
        SeeRanks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeeRanksActionPerformed(evt);
            }
        });
        getContentPane().add(SeeRanks, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 460, 330, 80));

        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/logo.png"))); // NOI18N
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 600, 140));

        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/IconInfo.png"))); // NOI18N
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMouseClicked(evt);
            }
        });
        getContentPane().add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/IconHelp.png"))); // NOI18N
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
        });
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/fondoPrincipal2.png"))); // NOI18N
        fondo.setPreferredSize(null);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        cPresentacio.sincroMenuPrincipal_a_NovaPartida();
    }//GEN-LAST:event_NewGameActionPerformed

    private void ExitAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitAppActionPerformed
        cPresentacio.cridaControladorDomini_guardarDades();
        System.out.println("S'ha tancat l'aplicació!");
        System.exit(0);
    }//GEN-LAST:event_ExitAppActionPerformed

    private void LoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadGameActionPerformed
        cPresentacio.sincroMenuPrincipal_a_CarregarPartida();
    }//GEN-LAST:event_LoadGameActionPerformed

    private void SeeRanksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeeRanksActionPerformed
        cPresentacio.sincroMenuPrincipal_a_Rankings();
    }//GEN-LAST:event_SeeRanksActionPerformed

    private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
        javax.swing.JOptionPane.showMessageDialog(rootPane, " PROJECTE PROP Q1 2017 \n\n Fet per: "
                + "\n - Albert Carreira Muñoz"
                + "\n - Jordi Nieto Maldonado"
                + "\n - Isamel Haddad Ez-Zarraty \n");
    }//GEN-LAST:event_aboutMouseClicked

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        cPresentacio.sincroMenuPrincipal_a_Ajuda();
    }//GEN-LAST:event_helpMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitApp;
    private javax.swing.JButton LoadGame;
    private javax.swing.JButton NewGame;
    private javax.swing.JButton SeeRanks;
    private javax.swing.JLabel about;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel help;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
