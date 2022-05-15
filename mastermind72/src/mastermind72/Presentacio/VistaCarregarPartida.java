package mastermind72.Presentacio;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import mastermind72.Classes.Pair;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class VistaCarregarPartida extends javax.swing.JFrame {
    ControladorPresentacio cPresentacio;
    JTextField partidaSeleccionada = null;
    
    public VistaCarregarPartida(ControladorPresentacio cp) {
        initComponents();
        cPresentacio = cp;
        setLocationRelativeTo(null);
        
        info.setOpaque(false);
        info.getViewport().setOpaque(false);
        info1.setOpaque(false);
        info1.setForeground(new Color(255,255,255));
        info1.setForeground(new Color(255,255,255));
        
        setPartides();
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
    public void setPartides(){
        List<Pair<String,String>> l = cPresentacio.cridaControladorPartida_consultarllistaPartidesGuardades();

        panelPartides.removeAll();
       
        for (Pair<String,String> r : l){//1-2018_01_05-13_29_48
                JTextField nom = new JTextField(r.getRight()+"   -   "
                        +r.getLeft().substring(r.getLeft().length()-27,r.getLeft().length()-23)+" "
                        +r.getLeft().substring(r.getLeft().length()-22,r.getLeft().length()-20)+" "
                        +r.getLeft().substring(r.getLeft().length()-19,r.getLeft().length()-17)+" / "
                        +r.getLeft().substring(r.getLeft().length()-16,r.getLeft().length()-14)+":"
                        +r.getLeft().substring(r.getLeft().length()-13,r.getLeft().length()-11)+":"
                        +r.getLeft().substring(r.getLeft().length()-10,r.getLeft().length()-8)
                );
                nom.setToolTipText(r.getLeft());
                nom.setEditable(false);
                nom.setOpaque(false);
                nom.setBorder(null);
                nom.setForeground(Color.WHITE);
                nom.setFont(new java.awt.Font("Centaur", 1, 20));
                nom.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        partidaSeleccionada = nom;
                        nom.setForeground(Color.cyan);
                        noDestaca();
                    }
                });
                if (panelPartides.getComponentCount() < 10) panelPartides.add(nom);
                else panelPartides.remove(0); panelPartides.add(nom);
        }
        
        repaint();
    }
    private void noDestaca(){
        for (Component c: panelPartides.getComponents()){
            if (c.getClass().equals(JTextField.class)){
                if (!c.equals(partidaSeleccionada)) 
                    c.setForeground(Color.WHITE);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butLoad = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        panelPartides = new javax.swing.JPanel();
        info = new javax.swing.JScrollPane();
        info1 = new javax.swing.JTextArea();
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

        butLoad.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.buttonShadow"));
        butLoad.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        butLoad.setText("Load");
        butLoad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        butLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLoadActionPerformed(evt);
            }
        });
        getContentPane().add(butLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 190, 40));

        name.setFont(new java.awt.Font("Centaur", 1, 30)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Choose a game to load");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        panelPartides.setBackground(new java.awt.Color(39, 39, 44));
        panelPartides.setOpaque(false);
        panelPartides.setLayout(new java.awt.GridLayout(10, 1));
        getContentPane().add(panelPartides, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 710, 340));

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setBorder(null);

        info1.setEditable(false);
        info1.setColumns(1);
        info1.setFont(new java.awt.Font("Centaur", 2, 20)); // NOI18N
        info1.setLineWrap(true);
        info1.setRows(1);
        info1.setText("Pots guardar i carregar fins a un màxim de 10 partides. Es borrarà la més antiga si ja n'hi ha 10.");
        info1.setWrapStyleWord(true);
        info1.setBorder(null);
        info.setViewportView(info1);

        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 790, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 670, 10));

        titol.setFont(new java.awt.Font("Centaur", 1, 64)); // NOI18N
        titol.setForeground(new java.awt.Color(255, 255, 255));
        titol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titol.setText("Load game");
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 74, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, 90, 80));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/fondoPrincipal2.png"))); // NOI18N
        fondo.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        fondo.setPreferredSize(null);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 700));

        getAccessibleContext().setAccessibleName("Partides actuals");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        cPresentacio.sincroCarregarPartida_a_MenuPrincipal();
    }//GEN-LAST:event_backMouseClicked

    private void butLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLoadActionPerformed
        // Ya tenemos la partida, con el nombre seleccionado -> llamar a persistencia, que cargue la partida y
        // hacer la sincro a Partida con la dificultad 
        /*List<Pair<String,String>> l = cPresentacio.cridaControladorPartida_consultarllistaPartidesGuardades();
        for (Pair<String,String> r : l){
            if (r.getLeft().equals(partidaSeleccionada.getText())){
                break;
            }
        }*/
        try{
            cPresentacio.sincroCarregarPartida_a_Partida(cPresentacio.cridaControladorPartida_CarregarPartida(partidaSeleccionada.getToolTipText()));
        }
        catch (NullPointerException ex){
            System.out.println("S'ha intentat carregar una partida amb valor null");
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_butLoadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton butLoad;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane info;
    private javax.swing.JTextArea info1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel name;
    private javax.swing.JPanel panelPartides;
    private javax.swing.JLabel titol;
    // End of variables declaration//GEN-END:variables
    
}