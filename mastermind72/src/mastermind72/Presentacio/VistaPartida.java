package mastermind72.Presentacio;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JScrollBar;
import mastermind72.Classes.Pair;


public class VistaPartida extends javax.swing.JFrame {
    public static final int GROC    = 1;
    public static final int TARONJA = 2;
    public static final int VERMELL = 3;
    public static final int ROSA    = 4;
    public static final int VERD    = 5;
    public static final int BLAU    = 6;
    public static final int VIOLETA = 7;
    public static final int MARRO   = 8;
    private List<String> vColorNom;
    
    private ImageIcon iconBuida = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVacia.png"));
    private ImageIcon iconBuidaDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVaciaDestac.png"));
    
    private ImageIcon iconGroc = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucAmarilla.png"));
    private ImageIcon iconGrocDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucAmarillaDestac.png"));
    private ImageIcon iconTaronja = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucNaranja.png"));
    private ImageIcon iconTaronjaDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucNaranjaDestac.png"));
    private ImageIcon iconVerm = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucRoja.png"));
    private ImageIcon iconVermDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucRojaDestac.png"));
    private ImageIcon iconRosa = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucRosa.png"));
    private ImageIcon iconRosaDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucRosaDestac.png"));
    private ImageIcon iconVerd = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVerde.png"));
    private ImageIcon iconVerdDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVerdeDestac.png"));
    private ImageIcon iconBlau = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucAzul.png"));
    private ImageIcon iconBlauDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucAzulDestac.png"));
    private ImageIcon iconViol = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVioleta.png"));
    private ImageIcon iconViolDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucVioletaDestac.png"));
    private ImageIcon iconMarro = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucMarron.png"));
    private ImageIcon iconMarroDest = new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/solucMarronDestac.png"));
    
    private List<Integer> actuals;
    
    ControladorPresentacio cPresentacio;
    String dificultat = ""; 
    String mode = "";
    int size; //llargada de la solucio segons la dificultat
    byte seleccionada = 1; //bola seleccionada actualment
    int numJugada = 0;

    
    public VistaPartida(ControladorPresentacio cp, String dif, String mode) {
        initComponents();
        cPresentacio = cp;
        dificultat = dif;
        this.mode = mode;
        actuals = new ArrayList<>(7); for(int i = 0; i < 7; ++i) actuals.add(0);
        
        vColorNom = new ArrayList<>(8);
        vColorNom.add("Amarilla");
        vColorNom.add("Naranja");
        vColorNom.add("Roja");
        vColorNom.add("Rosa");
        vColorNom.add("Verde");
        vColorNom.add("Azul");
        vColorNom.add("Violeta");
        vColorNom.add("Marron");
        
        disponibles.setBackground(new Color(255,255,255,136));
        setLocationRelativeTo(null);
        setButtons();
        
        if (mode.equals("CM")){
            disponibles.setVisible(false);
            butAccept.setFocusable(false);
            butAccept.setEnabled(false);
            butAccept.setBackground(Color.GRAY);
            butAccept.setBorderPainted(false);
            butHelp.setFocusable(false);
            butHelp.setEnabled(false);
            butHelp.setBackground(Color.GRAY);
            butHelp.setBorderPainted(false);
            
            List<Integer> s = cPresentacio.cridaControladorPartida_getSolucio();
            
            List<Pair<List<Integer>,Pair<Integer,Integer>>>  jug = cPresentacio.cridaControladorPartida_JugarPartidaCM(s);
            
            for (Pair<List<Integer>,Pair<Integer,Integer>> p : jug){
                putOnTable(numJugada,p.getLeft(),p.getRight());
                ++numJugada;
            }
            
            setColorBola(solucio1,vColorNom.get(s.get(0) - 1));
            setColorBola(solucio2,vColorNom.get(s.get(1) - 1));
            setColorBola(solucio3,vColorNom.get(s.get(2) - 1));
            setColorBola(solucio4,vColorNom.get(s.get(3) - 1));

            if (size == 6) {
                setColorBola(solucio5,vColorNom.get(s.get(4) - 1));
                setColorBola(solucio6,vColorNom.get(s.get(5) - 1));
            }
            
        } else {
        
            // Carregar la partida
            List<Pair<List<Integer>,Pair<Integer,Integer>>>  jug = cPresentacio.cridaControladorPartida_getJugades();

            for (Pair<List<Integer>,Pair<Integer,Integer>> p : jug){
                putOnTable(numJugada,p.getLeft(),p.getRight());
                ++numJugada;
            }
        }
        
        System.out.println(cPresentacio.cridaControladorPartida_getSolucio());
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
    
    /* Inicialitza les etiquetes "hardcoded" de la solucio */
    private void setButtons(){
        if (dificultat.equals("facil")) size = 4;
        else size = 6;
          
        solucio1 = new JLabel();
        solucio1.setIcon(iconBuidaDest);
        solucio1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                seleccionada = 1;
                destaca(seleccionada);
                noDestaca(seleccionada);
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    solucio1.setIcon(iconBuida);
                    actuals.set(seleccionada, 0);
                }
            }
        });
        solucio.add(solucio1);
        
        solucio2 = new JLabel();
        solucio2.setIcon(iconBuida);
        solucio2.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                seleccionada = 2;
                destaca(seleccionada);
                noDestaca(seleccionada);
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    solucio2.setIcon(iconBuida);
                    actuals.set(seleccionada, 0);
                }
            }
        });
        solucio.add(solucio2);
        
        solucio3 = new JLabel();
        solucio3.setIcon(iconBuida);
        solucio3.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                seleccionada = 3;
                destaca(seleccionada);
                noDestaca(seleccionada);
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    solucio3.setIcon(iconBuida);
                    actuals.set(seleccionada, 0);
                }
            }
        });
        solucio.add(solucio3);
        
        solucio4 = new JLabel();
        solucio4.setIcon(iconBuida);
        solucio4.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                seleccionada = 4;
                destaca(seleccionada);
                noDestaca(seleccionada);
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    solucio4.setIcon(iconBuida);
                    actuals.set(seleccionada, 0);
                }
            }
        });
        solucio.add(solucio4);
        
        if (size == 6){
            solucio5 = new JLabel();
            solucio5.setIcon(iconBuida);
            solucio5.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent evt){
                    seleccionada = 5;
                    destaca(seleccionada);
                    noDestaca(seleccionada);
                    if (evt.getButton() == MouseEvent.BUTTON3) {
                        solucio5.setIcon(iconBuida);
                        actuals.set(seleccionada, 0);
                    }
                }
            });
            solucio.add(solucio5);

            solucio6 = new JLabel();
            solucio6.setIcon(iconBuida);
            solucio6.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent evt){
                    seleccionada = 6;
                    destaca(seleccionada);
                    noDestaca(seleccionada);
                    if (evt.getButton() == MouseEvent.BUTTON3) {
                        solucio6.setIcon(iconBuida);
                        actuals.set(seleccionada, 0);
                    }
                }
            });
            solucio.add(solucio6);
        }
        revalidate();
    }
    /* Controla la següent bola a seleccionar */
    private void augmentaSeleccionada(){
        if (seleccionada + 1 > size) seleccionada = 1;
        else ++seleccionada;
        
        destaca(seleccionada);
    }
   
    /* Destaca la bola seleccionada */
    private void destaca(int posicio){
        if (posicio == 1){
            if (solucio1.getIcon().toString().contains("Vacia"))
                solucio1.setIcon(iconBuidaDest); 
            else if (solucio1.getIcon().toString().contains("Amarilla"))
                solucio1.setIcon(iconGrocDest); 
            else if (solucio1.getIcon().toString().contains("Naranja"))
                solucio1.setIcon(iconTaronjaDest);
            else if (solucio1.getIcon().toString().contains("Roja"))
                solucio1.setIcon(iconVermDest);
            else if (solucio1.getIcon().toString().contains("Rosa"))
                solucio1.setIcon(iconRosaDest);
            else if (solucio1.getIcon().toString().contains("Verde"))
                solucio1.setIcon(iconVerdDest);
            else if (solucio1.getIcon().toString().contains("Azul"))
                solucio1.setIcon(iconBlauDest);
            else if (solucio1.getIcon().toString().contains("Violeta"))
                solucio1.setIcon(iconViolDest);
            else if (solucio1.getIcon().toString().contains("Marron"))
                solucio1.setIcon(iconMarroDest);      
        }
        else if (posicio == 2){
            if (solucio2.getIcon().toString().contains("Vacia"))
                solucio2.setIcon(iconBuidaDest); 
            else if (solucio2.getIcon().toString().contains("Amarilla"))
                solucio2.setIcon(iconGrocDest); 
            else if (solucio2.getIcon().toString().contains("Naranja"))
                solucio2.setIcon(iconTaronjaDest);
            else if (solucio2.getIcon().toString().contains("Roja"))
                solucio2.setIcon(iconVermDest);
            else if (solucio2.getIcon().toString().contains("Rosa"))
                solucio2.setIcon(iconRosaDest);
            else if (solucio2.getIcon().toString().contains("Verde"))
                solucio2.setIcon(iconVerdDest);
            else if (solucio2.getIcon().toString().contains("Azul"))
                solucio2.setIcon(iconBlauDest);
            else if (solucio2.getIcon().toString().contains("Violeta"))
                solucio2.setIcon(iconViolDest);
            else if (solucio2.getIcon().toString().contains("Marron"))
                solucio2.setIcon(iconMarroDest);      
        }
        else if (posicio == 3){
            if (solucio3.getIcon().toString().contains("Vacia"))
                solucio3.setIcon(iconBuidaDest); 
            else if (solucio3.getIcon().toString().contains("Amarilla"))
                solucio3.setIcon(iconGrocDest); 
            else if (solucio3.getIcon().toString().contains("Naranja"))
                solucio3.setIcon(iconTaronjaDest);
            else if (solucio3.getIcon().toString().contains("Roja"))
                solucio3.setIcon(iconVermDest);
            else if (solucio3.getIcon().toString().contains("Rosa"))
                solucio3.setIcon(iconRosaDest);
            else if (solucio3.getIcon().toString().contains("Verde"))
                solucio3.setIcon(iconVerdDest);
            else if (solucio3.getIcon().toString().contains("Azul"))
                solucio3.setIcon(iconBlauDest);
            else if (solucio3.getIcon().toString().contains("Violeta"))
                solucio3.setIcon(iconViolDest);
            else if (solucio3.getIcon().toString().contains("Marron"))
                solucio3.setIcon(iconMarroDest);      
        }
        else if (posicio == 4){
            if (solucio4.getIcon().toString().contains("Vacia"))
                solucio4.setIcon(iconBuidaDest); 
            else if (solucio4.getIcon().toString().contains("Amarilla"))
                solucio4.setIcon(iconGrocDest); 
            else if (solucio4.getIcon().toString().contains("Naranja"))
                solucio4.setIcon(iconTaronjaDest);
            else if (solucio4.getIcon().toString().contains("Roja"))
                solucio4.setIcon(iconVermDest);
            else if (solucio4.getIcon().toString().contains("Rosa"))
                solucio4.setIcon(iconRosaDest);
            else if (solucio4.getIcon().toString().contains("Verde"))
                solucio4.setIcon(iconVerdDest);
            else if (solucio4.getIcon().toString().contains("Azul"))
                solucio4.setIcon(iconBlauDest);
            else if (solucio4.getIcon().toString().contains("Violeta"))
                solucio4.setIcon(iconViolDest);
            else if (solucio4.getIcon().toString().contains("Marron"))
                solucio4.setIcon(iconMarroDest);      
        }
        else if (posicio == 5){
            if (solucio5.getIcon().toString().contains("Vacia"))
                solucio5.setIcon(iconBuidaDest); 
            else if (solucio5.getIcon().toString().contains("Amarilla"))
                solucio5.setIcon(iconGrocDest); 
            else if (solucio5.getIcon().toString().contains("Naranja"))
                solucio5.setIcon(iconTaronjaDest);
            else if (solucio5.getIcon().toString().contains("Roja"))
                solucio5.setIcon(iconVermDest);
            else if (solucio5.getIcon().toString().contains("Rosa"))
                solucio5.setIcon(iconRosaDest);
            else if (solucio5.getIcon().toString().contains("Verde"))
                solucio5.setIcon(iconVerdDest);
            else if (solucio5.getIcon().toString().contains("Azul"))
                solucio5.setIcon(iconBlauDest);
            else if (solucio5.getIcon().toString().contains("Violeta"))
                solucio5.setIcon(iconViolDest);
            else if (solucio5.getIcon().toString().contains("Marron"))
                solucio5.setIcon(iconMarroDest);      
        }
        else{
            if (solucio6.getIcon().toString().contains("Vacia"))
                solucio6.setIcon(iconBuidaDest); 
            else if (solucio6.getIcon().toString().contains("Amarilla"))
                solucio6.setIcon(iconGrocDest); 
            else if (solucio6.getIcon().toString().contains("Naranja"))
                solucio6.setIcon(iconTaronjaDest);
            else if (solucio6.getIcon().toString().contains("Roja"))
                solucio6.setIcon(iconVermDest);
            else if (solucio6.getIcon().toString().contains("Rosa"))
                solucio6.setIcon(iconRosaDest);
            else if (solucio6.getIcon().toString().contains("Verde"))
                solucio6.setIcon(iconVerdDest);
            else if (solucio6.getIcon().toString().contains("Azul"))
                solucio6.setIcon(iconBlauDest);
            else if (solucio6.getIcon().toString().contains("Violeta"))
                solucio6.setIcon(iconViolDest);
            else if (solucio6.getIcon().toString().contains("Marron"))
                solucio6.setIcon(iconMarroDest);      
        }
    }
    
    /* No destaca qualsevol altra bola que no sigui la seleccionada */
    private void noDestaca(int posicio){
        for (int i = 1; i < posicio; ++i){
            if (i == 1){
                if (solucio1.getIcon().toString().contains("Vacia"))
                    solucio1.setIcon(iconBuida); 
                else if (solucio1.getIcon().toString().contains("Amarilla"))
                    solucio1.setIcon(iconGroc); 
                else if (solucio1.getIcon().toString().contains("Naranja"))
                    solucio1.setIcon(iconTaronja);
                else if (solucio1.getIcon().toString().contains("Roja"))
                    solucio1.setIcon(iconVerm);
                else if (solucio1.getIcon().toString().contains("Rosa"))
                    solucio1.setIcon(iconRosa);
                else if (solucio1.getIcon().toString().contains("Verde"))
                    solucio1.setIcon(iconVerd);
                else if (solucio1.getIcon().toString().contains("Azul"))
                    solucio1.setIcon(iconBlau);
                else if (solucio1.getIcon().toString().contains("Violeta"))
                    solucio1.setIcon(iconViol);
                else if (solucio1.getIcon().toString().contains("Marron"))
                    solucio1.setIcon(iconMarro);      
            }
            else if (i == 2){
                if (solucio2.getIcon().toString().contains("Vacia"))
                    solucio2.setIcon(iconBuida); 
                else if (solucio2.getIcon().toString().contains("Amarilla"))
                    solucio2.setIcon(iconGroc); 
                else if (solucio2.getIcon().toString().contains("Naranja"))
                    solucio2.setIcon(iconTaronja);
                else if (solucio2.getIcon().toString().contains("Roja"))
                    solucio2.setIcon(iconVerm);
                else if (solucio2.getIcon().toString().contains("Rosa"))
                    solucio2.setIcon(iconRosa);
                else if (solucio2.getIcon().toString().contains("Verde"))
                    solucio2.setIcon(iconVerd);
                else if (solucio2.getIcon().toString().contains("Azul"))
                    solucio2.setIcon(iconBlau);
                else if (solucio2.getIcon().toString().contains("Violeta"))
                    solucio2.setIcon(iconViol);
                else if (solucio2.getIcon().toString().contains("Marron"))
                    solucio2.setIcon(iconMarro);      
            }
            else if (i == 3){
                if (solucio3.getIcon().toString().contains("Vacia"))
                    solucio3.setIcon(iconBuida); 
                else if (solucio3.getIcon().toString().contains("Amarilla"))
                    solucio3.setIcon(iconGroc); 
                else if (solucio3.getIcon().toString().contains("Naranja"))
                    solucio3.setIcon(iconTaronja);
                else if (solucio3.getIcon().toString().contains("Roja"))
                    solucio3.setIcon(iconVerm);
                else if (solucio3.getIcon().toString().contains("Rosa"))
                    solucio3.setIcon(iconRosa);
                else if (solucio3.getIcon().toString().contains("Verde"))
                    solucio3.setIcon(iconVerd);
                else if (solucio3.getIcon().toString().contains("Azul"))
                    solucio3.setIcon(iconBlau);
                else if (solucio3.getIcon().toString().contains("Violeta"))
                    solucio3.setIcon(iconViol);
                else if (solucio3.getIcon().toString().contains("Marron"))
                    solucio3.setIcon(iconMarro);      
            }
            else if (i == 4){
                if (solucio4.getIcon().toString().contains("Vacia"))
                    solucio4.setIcon(iconBuida); 
                else if (solucio4.getIcon().toString().contains("Amarilla"))
                    solucio4.setIcon(iconGroc); 
                else if (solucio4.getIcon().toString().contains("Naranja"))
                    solucio4.setIcon(iconTaronja);
                else if (solucio4.getIcon().toString().contains("Roja"))
                    solucio4.setIcon(iconVerm);
                else if (solucio4.getIcon().toString().contains("Rosa"))
                    solucio4.setIcon(iconRosa);
                else if (solucio4.getIcon().toString().contains("Verde"))
                    solucio4.setIcon(iconVerd);
                else if (solucio4.getIcon().toString().contains("Azul"))
                    solucio4.setIcon(iconBlau);
                else if (solucio4.getIcon().toString().contains("Violeta"))
                    solucio4.setIcon(iconViol);
                else if (solucio4.getIcon().toString().contains("Marron"))
                    solucio4.setIcon(iconMarro);      
            }
            else if (i == 5){
                if (solucio5.getIcon().toString().contains("Vacia"))
                    solucio5.setIcon(iconBuida); 
                else if (solucio5.getIcon().toString().contains("Amarilla"))
                    solucio5.setIcon(iconGroc); 
                else if (solucio5.getIcon().toString().contains("Naranja"))
                    solucio5.setIcon(iconTaronja);
                else if (solucio5.getIcon().toString().contains("Roja"))
                    solucio5.setIcon(iconVerm);
                else if (solucio5.getIcon().toString().contains("Rosa"))
                    solucio5.setIcon(iconRosa);
                else if (solucio5.getIcon().toString().contains("Verde"))
                    solucio5.setIcon(iconVerd);
                else if (solucio5.getIcon().toString().contains("Azul"))
                    solucio5.setIcon(iconBlau);
                else if (solucio5.getIcon().toString().contains("Violeta"))
                    solucio5.setIcon(iconViol);
                else if (solucio5.getIcon().toString().contains("Marron"))
                    solucio5.setIcon(iconMarro);      
            }
            else{
                if (solucio6.getIcon().toString().contains("Vacia"))
                    solucio6.setIcon(iconBuida); 
                else if (solucio6.getIcon().toString().contains("Amarilla"))
                    solucio6.setIcon(iconGroc); 
                else if (solucio6.getIcon().toString().contains("Naranja"))
                    solucio6.setIcon(iconTaronja);
                else if (solucio6.getIcon().toString().contains("Roja"))
                    solucio6.setIcon(iconVerm);
                else if (solucio6.getIcon().toString().contains("Rosa"))
                    solucio6.setIcon(iconRosa);
                else if (solucio6.getIcon().toString().contains("Verde"))
                    solucio6.setIcon(iconVerd);
                else if (solucio6.getIcon().toString().contains("Azul"))
                    solucio6.setIcon(iconBlau);
                else if (solucio6.getIcon().toString().contains("Violeta"))
                    solucio6.setIcon(iconViol);
                else if (solucio6.getIcon().toString().contains("Marron"))
                    solucio6.setIcon(iconMarro);      
            }
        }
        
        for (int i = posicio+1; i <= size; ++i){
            if (i == 1){
                if (solucio1.getIcon().toString().contains("Vacia"))
                    solucio1.setIcon(iconBuida); 
                else if (solucio1.getIcon().toString().contains("Amarilla"))
                    solucio1.setIcon(iconGroc); 
                else if (solucio1.getIcon().toString().contains("Naranja"))
                    solucio1.setIcon(iconTaronja);
                else if (solucio1.getIcon().toString().contains("Roja"))
                    solucio1.setIcon(iconVerm);
                else if (solucio1.getIcon().toString().contains("Rosa"))
                    solucio1.setIcon(iconRosa);
                else if (solucio1.getIcon().toString().contains("Verde"))
                    solucio1.setIcon(iconVerd);
                else if (solucio1.getIcon().toString().contains("Azul"))
                    solucio1.setIcon(iconBlau);
                else if (solucio1.getIcon().toString().contains("Violeta"))
                    solucio1.setIcon(iconViol);
                else if (solucio1.getIcon().toString().contains("Marron"))
                    solucio1.setIcon(iconMarro);      
            }
            else if (i == 2){
                if (solucio2.getIcon().toString().contains("Vacia"))
                    solucio2.setIcon(iconBuida); 
                else if (solucio2.getIcon().toString().contains("Amarilla"))
                    solucio2.setIcon(iconGroc); 
                else if (solucio2.getIcon().toString().contains("Naranja"))
                    solucio2.setIcon(iconTaronja);
                else if (solucio2.getIcon().toString().contains("Roja"))
                    solucio2.setIcon(iconVerm);
                else if (solucio2.getIcon().toString().contains("Rosa"))
                    solucio2.setIcon(iconRosa);
                else if (solucio2.getIcon().toString().contains("Verde"))
                    solucio2.setIcon(iconVerd);
                else if (solucio2.getIcon().toString().contains("Azul"))
                    solucio2.setIcon(iconBlau);
                else if (solucio2.getIcon().toString().contains("Violeta"))
                    solucio2.setIcon(iconViol);
                else if (solucio2.getIcon().toString().contains("Marron"))
                    solucio2.setIcon(iconMarro);      
            }
            else if (i == 3){
                if (solucio3.getIcon().toString().contains("Vacia"))
                    solucio3.setIcon(iconBuida); 
                else if (solucio3.getIcon().toString().contains("Amarilla"))
                    solucio3.setIcon(iconGroc); 
                else if (solucio3.getIcon().toString().contains("Naranja"))
                    solucio3.setIcon(iconTaronja);
                else if (solucio3.getIcon().toString().contains("Roja"))
                    solucio3.setIcon(iconVerm);
                else if (solucio3.getIcon().toString().contains("Rosa"))
                    solucio3.setIcon(iconRosa);
                else if (solucio3.getIcon().toString().contains("Verde"))
                    solucio3.setIcon(iconVerd);
                else if (solucio3.getIcon().toString().contains("Azul"))
                    solucio3.setIcon(iconBlau);
                else if (solucio3.getIcon().toString().contains("Violeta"))
                    solucio3.setIcon(iconViol);
                else if (solucio3.getIcon().toString().contains("Marron"))
                    solucio3.setIcon(iconMarro);      
            }
            else if (i == 4){
                if (solucio4.getIcon().toString().contains("Vacia"))
                    solucio4.setIcon(iconBuida); 
                else if (solucio4.getIcon().toString().contains("Amarilla"))
                    solucio4.setIcon(iconGroc); 
                else if (solucio4.getIcon().toString().contains("Naranja"))
                    solucio4.setIcon(iconTaronja);
                else if (solucio4.getIcon().toString().contains("Roja"))
                    solucio4.setIcon(iconVerm);
                else if (solucio4.getIcon().toString().contains("Rosa"))
                    solucio4.setIcon(iconRosa);
                else if (solucio4.getIcon().toString().contains("Verde"))
                    solucio4.setIcon(iconVerd);
                else if (solucio4.getIcon().toString().contains("Azul"))
                    solucio4.setIcon(iconBlau);
                else if (solucio4.getIcon().toString().contains("Violeta"))
                    solucio4.setIcon(iconViol);
                else if (solucio4.getIcon().toString().contains("Marron"))
                    solucio4.setIcon(iconMarro);      
            }
            else if (i == 5){
                if (solucio5.getIcon().toString().contains("Vacia"))
                    solucio5.setIcon(iconBuida); 
                else if (solucio5.getIcon().toString().contains("Amarilla"))
                    solucio5.setIcon(iconGroc); 
                else if (solucio5.getIcon().toString().contains("Naranja"))
                    solucio5.setIcon(iconTaronja);
                else if (solucio5.getIcon().toString().contains("Roja"))
                    solucio5.setIcon(iconVerm);
                else if (solucio5.getIcon().toString().contains("Rosa"))
                    solucio5.setIcon(iconRosa);
                else if (solucio5.getIcon().toString().contains("Verde"))
                    solucio5.setIcon(iconVerd);
                else if (solucio5.getIcon().toString().contains("Azul"))
                    solucio5.setIcon(iconBlau);
                else if (solucio5.getIcon().toString().contains("Violeta"))
                    solucio5.setIcon(iconViol);
                else if (solucio5.getIcon().toString().contains("Marron"))
                    solucio5.setIcon(iconMarro);      
            }
            else{
                if (solucio6.getIcon().toString().contains("Vacia"))
                    solucio6.setIcon(iconBuida); 
                else if (solucio6.getIcon().toString().contains("Amarilla"))
                    solucio6.setIcon(iconGroc); 
                else if (solucio6.getIcon().toString().contains("Naranja"))
                    solucio6.setIcon(iconTaronja);
                else if (solucio6.getIcon().toString().contains("Roja"))
                    solucio6.setIcon(iconVerm);
                else if (solucio6.getIcon().toString().contains("Rosa"))
                    solucio6.setIcon(iconRosa);
                else if (solucio6.getIcon().toString().contains("Verde"))
                    solucio6.setIcon(iconVerd);
                else if (solucio6.getIcon().toString().contains("Azul"))
                    solucio6.setIcon(iconBlau);
                else if (solucio6.getIcon().toString().contains("Violeta"))
                    solucio6.setIcon(iconViol);
                else if (solucio6.getIcon().toString().contains("Marron"))
                    solucio6.setIcon(iconMarro);      
            }
        }
        
    }
    
    /* Coloca el color a la bola seleccionada */
    private void colocaColor(int posicio, String color){
        //repeatInfo.setVisible(false);
        if (posicio == 1){
            solucio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png"))); // NOI18N);
        }
        else if (posicio == 2){
            solucio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png"))); // NOI18N);
        }
        else if (posicio == 3){
            solucio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png"))); // NOI18N);
        }
        else if (posicio == 4){
            solucio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png"))); // NOI18N);
        }
        else if (posicio == 5){
            solucio5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png"))); // NOI18N);
        }
        else if (posicio == 6){
            solucio6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png"))); // NOI18N);
        }
    }
    
    private void putOnTable(int n, List<Integer> s, Pair<Integer,Integer> p){
        javax.swing.JLabel nu = new javax.swing.JLabel();
        
        javax.swing.JLabel bola1 = new javax.swing.JLabel();
        javax.swing.JLabel bola2 = new javax.swing.JLabel();
        javax.swing.JLabel bola3 = new javax.swing.JLabel();
        javax.swing.JLabel bola4 = new javax.swing.JLabel();
        javax.swing.JLabel bola5 = new javax.swing.JLabel();
        javax.swing.JLabel bola6 = new javax.swing.JLabel();
        /*
        javax.swing.JLabel bn1 = new javax.swing.JLabel();
        javax.swing.JLabel bn2 = new javax.swing.JLabel();
        javax.swing.JLabel bn3 = new javax.swing.JLabel();
        javax.swing.JLabel bn4 = new javax.swing.JLabel();
        javax.swing.JLabel bn5 = new javax.swing.JLabel();
        javax.swing.JLabel bn6 = new javax.swing.JLabel();
        */
        javax.swing.JPanel ficha = new javax.swing.JPanel();
        java.awt.Font font = new java.awt.Font("Comic Sans MS", 1, 24);
        ficha.setLayout(new GridLayout());
        ficha.setOpaque(false);
        ficha.setBackground(new Color(0,0,0,30));
        repaint();
        nu.setFont(font);
        nu.setText(String.valueOf(n+1));
        // si lo queremos centrado: nu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha.add(nu);
        
        setColorBola(bola1,vColorNom.get(s.get(0) - 1));
        ficha.add(bola1);
        setColorBola(bola2,vColorNom.get(s.get(1) - 1));
        ficha.add(bola2);
        setColorBola(bola3,vColorNom.get(s.get(2) - 1));
        ficha.add(bola3);
        setColorBola(bola4,vColorNom.get(s.get(3) - 1));
        ficha.add(bola4);
        
        if (size == 6) {
            setColorBola(bola5,vColorNom.get(s.get(4) - 1));
            ficha.add(bola5);
            setColorBola(bola6,vColorNom.get(s.get(5) - 1));
            ficha.add(bola6);
        }
        
        javax.swing.JLabel bla = new javax.swing.JLabel(); bla.setFont(font);
        javax.swing.JLabel neg = new javax.swing.JLabel(); neg.setFont(font);
        bla.setText(String.valueOf(p.getLeft()));
        ficha.add(bla);
        neg.setText(String.valueOf(p.getRight()));
        ficha.add(neg);
        
        GridLayout l = (GridLayout) tablero.getLayout();
        if (n >= 5) l.setRows(l.getRows()+1);
        tablero.add(ficha);
        revalidate();
        
        tableroScroll.getVerticalScrollBar().setValue(tableroScroll.getVerticalScrollBar().getMaximum());
    }
    
    private void setColorBola(javax.swing.JLabel b, String color){
        b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/soluc" + color + ".png")));
    }
    
    private void resetJugada(){
        solucio1.setIcon(iconBuidaDest);
        solucio2.setIcon(iconBuida);
        solucio3.setIcon(iconBuida);
        solucio4.setIcon(iconBuida);
        if (size == 6){
            solucio5.setIcon(iconBuida);
            solucio6.setIcon(iconBuida);
        }
        actuals.clear();
        for(int i = 0; i < 7; ++i) actuals.add(0);
        seleccionada = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butHelp = new javax.swing.JButton();
        butExit = new javax.swing.JButton();
        butAccept = new javax.swing.JButton();
        solucio = new javax.swing.JPanel();
        disponibles = new javax.swing.JPanel();
        bolaGrog = new javax.swing.JLabel();
        bolaTaronj = new javax.swing.JLabel();
        bolaVerm = new javax.swing.JLabel();
        bolaRosa = new javax.swing.JLabel();
        bolaVerd = new javax.swing.JLabel();
        bolaBlau = new javax.swing.JLabel();
        bolaViolet = new javax.swing.JLabel();
        bolaMarro = new javax.swing.JLabel();
        tableroScroll = new javax.swing.JScrollPane();
        tablero = new javax.swing.JPanel();
        infoTop = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Partida");
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butHelp.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butHelp.setText("HELP");
        butHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butHelpActionPerformed(evt);
            }
        });
        getContentPane().add(butHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 210, 80));

        butExit.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butExit.setText("EXIT");
        butExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });
        getContentPane().add(butExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 210, 80));

        butAccept.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butAccept.setText("ACCEPT");
        butAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAcceptActionPerformed(evt);
            }
        });
        getContentPane().add(butAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 420, 80));

        solucio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        solucio.setForeground(new java.awt.Color(180, 180, 180));
        solucio.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(solucio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 480, 80));

        disponibles.setLayout(new java.awt.GridBagLayout());

        bolaGrog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaAmarilla.png"))); // NOI18N
        bolaGrog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaGrogMousePressed(evt);
            }
        });
        disponibles.add(bolaGrog, new java.awt.GridBagConstraints());

        bolaTaronj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaNaranja.png"))); // NOI18N
        bolaTaronj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaTaronjMousePressed(evt);
            }
        });
        disponibles.add(bolaTaronj, new java.awt.GridBagConstraints());

        bolaVerm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaRoja.png"))); // NOI18N
        bolaVerm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaVermMousePressed(evt);
            }
        });
        disponibles.add(bolaVerm, new java.awt.GridBagConstraints());

        bolaRosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaRosa.png"))); // NOI18N
        bolaRosa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaRosaMousePressed(evt);
            }
        });
        disponibles.add(bolaRosa, new java.awt.GridBagConstraints());

        bolaVerd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaVerde.png"))); // NOI18N
        bolaVerd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaVerdMousePressed(evt);
            }
        });
        disponibles.add(bolaVerd, new java.awt.GridBagConstraints());

        bolaBlau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaAzul.png"))); // NOI18N
        bolaBlau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaBlauMousePressed(evt);
            }
        });
        disponibles.add(bolaBlau, new java.awt.GridBagConstraints());

        bolaViolet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaVioleta.png"))); // NOI18N
        bolaViolet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaVioletMousePressed(evt);
            }
        });
        disponibles.add(bolaViolet, new java.awt.GridBagConstraints());

        bolaMarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/bolaMarron.png"))); // NOI18N
        bolaMarro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bolaMarroMousePressed(evt);
            }
        });
        disponibles.add(bolaMarro, new java.awt.GridBagConstraints());

        getContentPane().add(disponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 480, 60));

        tableroScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablero.setForeground(new java.awt.Color(180, 180, 180));
        tablero.setLayout(new java.awt.GridLayout(5, 1));
        tableroScroll.setViewportView(tablero);

        getContentPane().add(tableroScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 930, 340));

        infoTop.setFont(new java.awt.Font("Century Schoolbook L", 1, 30)); // NOI18N
        infoTop.setForeground(new java.awt.Color(254, 254, 254));
        infoTop.setText("Nº                Jugada                                          B/N");
        getContentPane().add(infoTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 850, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermind72/Presentacio/images/fondoPrincipal2.png"))); // NOI18N
        fondo.setPreferredSize(null);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bolaGrogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaGrogMousePressed
        if (dificultat.equals("facil") && actuals.contains(GROC)) return;

        if (dificultat.equals("dificil") && actuals.contains(GROC)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(GROC)) ++c;
                if (c > 1) return;
            }
        }
        
        colocaColor(seleccionada,"Amarilla");
        actuals.set(seleccionada, GROC);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaGrogMousePressed

    private void bolaTaronjMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaTaronjMousePressed
        if (dificultat.equals("facil") && actuals.contains(TARONJA)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(TARONJA)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(TARONJA)) ++c;
                if (c > 1) return;
            }
        }

        colocaColor(seleccionada,"Naranja");
        actuals.set(seleccionada, TARONJA);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaTaronjMousePressed

    private void bolaVermMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaVermMousePressed
        if (dificultat.equals("facil") && actuals.contains(VERMELL)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(VERMELL)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(VERMELL)) ++c;
                if (c > 1) return;
            }
        }

        colocaColor(seleccionada,"Roja");
        actuals.set(seleccionada, VERMELL);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaVermMousePressed

    private void bolaRosaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaRosaMousePressed
        if (dificultat.equals("facil") && actuals.contains(ROSA)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(ROSA)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(ROSA)) ++c;
                if (c > 1) return;
            }
        }
        colocaColor(seleccionada,"Rosa");
        actuals.set(seleccionada, ROSA);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaRosaMousePressed

    private void bolaVerdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaVerdMousePressed
        if (dificultat.equals("facil") && actuals.contains(VERD)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(VERD)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(VERD)) ++c;
                if (c > 1) return;
            }
        }

        colocaColor(seleccionada,"Verde");
        actuals.set(seleccionada, VERD);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaVerdMousePressed

    private void bolaBlauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaBlauMousePressed
        if (dificultat.equals("facil") && actuals.contains(BLAU)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(BLAU)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(BLAU)) ++c;
                if (c > 1) return;
            }
        }

        colocaColor(seleccionada,"Azul");
        actuals.set(seleccionada, BLAU);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaBlauMousePressed

    private void bolaVioletMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaVioletMousePressed
        if (dificultat.equals("facil") && actuals.contains(VIOLETA)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(VIOLETA)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(VIOLETA)) ++c;
                if (c > 1) return;
            }
        }

        colocaColor(seleccionada,"Violeta");
        actuals.set(seleccionada, VIOLETA);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaVioletMousePressed

    private void bolaMarroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaMarroMousePressed
        if (dificultat.equals("facil") && actuals.contains(MARRO)) return;
        
        if (dificultat.equals("dificil") && actuals.contains(MARRO)){
            int c = 0;
            for (Integer i : actuals){
                if (i.equals(MARRO)) ++c;
                if (c > 1) return;
            }
        }

        colocaColor(seleccionada,"Marron");
        actuals.set(seleccionada, MARRO);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaMarroMousePressed

    private void butExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExitActionPerformed
        if (mode.equals("CB")) cPresentacio.sincroPartida_a_MenuGuardar();
        else cPresentacio.sincroPartida_a_MenuPrincipal();
    }//GEN-LAST:event_butExitActionPerformed

    private void butAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAcceptActionPerformed
        ArrayList<Integer> Solucio = new ArrayList<Integer>(actuals.subList(1, size+1));
        for (Integer i : Solucio) if (i == 0) return;  // Avis de que la solucio esta en blanc
        Pair<Integer,Integer> re = cPresentacio.cridaControladorPartida_IntroduirJugada(Solucio);

        putOnTable(numJugada,Solucio,re);
        ++numJugada;
        
        if (re.getRight() == size){
            String name = javax.swing.JOptionPane.showInputDialog(this, "What's your name?");
            if (name != null && name.length() > 0)
                cPresentacio.cridaControladorDomini_IntroduirRecord(name,dificultat);
            cPresentacio.sincroPartida_a_MenuPrincipal();
        }
        resetJugada();
    }//GEN-LAST:event_butAcceptActionPerformed

    private void butHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butHelpActionPerformed
        int bolaAmbAjuda = -1;
        List<Integer> intro = actuals.subList(1, size+1);
        if (!intro.contains(0))
        {
            bolaAmbAjuda = cPresentacio.cridaControladorPartida_getBolaAmbAjuda();
            cPresentacio.sincroPartida_a_BolaAjuda(bolaAmbAjuda);
        }
        else{
            // No ha introduit cap jugada encara
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Has de fer una jugada primer.");
        }
    }//GEN-LAST:event_butHelpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bolaBlau;
    private javax.swing.JLabel bolaGrog;
    private javax.swing.JLabel bolaMarro;
    private javax.swing.JLabel bolaRosa;
    private javax.swing.JLabel bolaTaronj;
    private javax.swing.JLabel bolaVerd;
    private javax.swing.JLabel bolaVerm;
    private javax.swing.JLabel bolaViolet;
    private javax.swing.JButton butAccept;
    private javax.swing.JButton butExit;
    private javax.swing.JButton butHelp;
    private javax.swing.JPanel disponibles;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel infoTop;
    private javax.swing.JPanel solucio;
    private javax.swing.JPanel tablero;
    private javax.swing.JScrollPane tableroScroll;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel solucio1;
    private javax.swing.JLabel solucio2;
    private javax.swing.JLabel solucio3;
    private javax.swing.JLabel solucio4;
    private javax.swing.JLabel solucio5;
    private javax.swing.JLabel solucio6;
}