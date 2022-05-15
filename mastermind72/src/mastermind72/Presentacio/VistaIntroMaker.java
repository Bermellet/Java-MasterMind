package mastermind72.Presentacio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

/**
 *
 * @author albert
 */
public class VistaIntroMaker extends javax.swing.JFrame {
    public static final int GROC    = 1;
    public static final int TARONJA = 2;
    public static final int VERMELL = 3;
    public static final int ROSA    = 4;
    public static final int VERD    = 5;
    public static final int BLAU    = 6;
    public static final int VIOLETA = 7;
    public static final int MARRO   = 8;
    
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
    int size; //llargada de la solucio segons la dificultat
    byte seleccionada = 1; //bola seleccionada actualment
    /**
     * Creates new form VistaIntroMaker
     * @param cp
     * @param dif
     */
    public VistaIntroMaker(ControladorPresentacio cp, String dif) {
        initComponents();
        setDefaultCloseOP();
        cPresentacio = cp;
        dificultat = dif;
        actuals = new ArrayList<>(7); for(int i = 0; i < 7; ++i) actuals.add(0);
        setLocationRelativeTo(null);
        
        setButtons();
        repeatInfo.setVisible(false);
    }
    
    // Si es clica la X no es tanca l'aplicació, es torna a NovaPartida
    private void setDefaultCloseOP(){
        this.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e){
                    cPresentacio.sincroIntroMaker_a_NovaPartida();
                }
            });
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
   
    private Boolean jaConteDosColors(int color){
        int count = 0;
        for (int i = 0; i < actuals.size(); ++i){
            if (actuals.get(i).equals(color)) ++count;
            if (count == 2) return true;
        }
        return false;
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
        repeatInfo.setVisible(false);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butCancel = new javax.swing.JButton();
        butAccept = new javax.swing.JButton();
        repeatInfo = new javax.swing.JLabel();
        titol = new javax.swing.JLabel();
        disponibles = new javax.swing.JPanel();
        bolaGrog = new javax.swing.JLabel();
        bolaTaronj = new javax.swing.JLabel();
        bolaVerm = new javax.swing.JLabel();
        bolaRosa = new javax.swing.JLabel();
        bolaVerd = new javax.swing.JLabel();
        bolaBlau = new javax.swing.JLabel();
        bolaViolet = new javax.swing.JLabel();
        bolaMarro = new javax.swing.JLabel();
        solucio = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Introdueix la solució");
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butCancel.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butCancel.setText("CANCEL");
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });
        getContentPane().add(butCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 110, 40));

        butAccept.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        butAccept.setText("ACCEPT");
        butAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAcceptActionPerformed(evt);
            }
        });
        getContentPane().add(butAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 110, 40));

        repeatInfo.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        repeatInfo.setForeground(new java.awt.Color(204, 0, 0));
        repeatInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(repeatInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 260, 470, 30));

        titol.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        titol.setText("Introdueix la solució que vols que la màquina resolgui: ");
        getContentPane().add(titol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

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

        getContentPane().add(disponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 480, 60));

        solucio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        solucio.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(solucio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 460, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        cPresentacio.sincroIntroMaker_a_NovaPartida();
    }//GEN-LAST:event_butCancelActionPerformed
    
    private void bolaGrogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaGrogMousePressed
        if (dificultat.equals("facil") && actuals.contains(GROC)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(GROC)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
            
        colocaColor(seleccionada,"Amarilla");
        actuals.set(seleccionada, GROC);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaGrogMousePressed

    private void bolaTaronjMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaTaronjMousePressed
        if (dificultat.equals("facil") && actuals.contains(TARONJA)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(TARONJA)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        
        colocaColor(seleccionada,"Naranja");
        actuals.set(seleccionada, TARONJA);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaTaronjMousePressed

    private void bolaVermMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaVermMousePressed
        if (dificultat.equals("facil") && actuals.contains(VERMELL)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(VERMELL)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        
        colocaColor(seleccionada,"Roja");
        actuals.set(seleccionada, VERMELL);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaVermMousePressed

    private void bolaRosaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaRosaMousePressed
        if (dificultat.equals("facil") && actuals.contains(ROSA)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(ROSA)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        colocaColor(seleccionada,"Rosa");
        actuals.set(seleccionada, ROSA);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaRosaMousePressed

    private void bolaVerdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaVerdMousePressed
        if (dificultat.equals("facil") && actuals.contains(VERD)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(VERD)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        
        colocaColor(seleccionada,"Verde");
        actuals.set(seleccionada, VERD);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaVerdMousePressed

    private void bolaBlauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaBlauMousePressed
        if (dificultat.equals("facil") && actuals.contains(BLAU)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(BLAU)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        
        colocaColor(seleccionada,"Azul");
        actuals.set(seleccionada, BLAU);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaBlauMousePressed

    private void bolaVioletMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaVioletMousePressed
        if (dificultat.equals("facil") && actuals.contains(VIOLETA)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(VIOLETA)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        
        colocaColor(seleccionada,"Violeta");
        actuals.set(seleccionada, VIOLETA);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaVioletMousePressed

    private void bolaMarroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolaMarroMousePressed
        if (dificultat.equals("facil") && actuals.contains(MARRO)){
            // No es pot posar un color repetit
            repeatInfo.setText("No es poden posar repetits en dificultat fàcil.");
            repeatInfo.setVisible(true);
            return;
        }
        if (dificultat.equals("DIFFICULT") && jaConteDosColors(MARRO)){
            // No es poden posar mes de dos colors repetits en dificil
            repeatInfo.setText("No es poden posar més de dos repetits en difícil.");
            repeatInfo.setVisible(true);
            return;
        }
        
        colocaColor(seleccionada,"Marron");
        actuals.set(seleccionada, MARRO);
        augmentaSeleccionada();
    }//GEN-LAST:event_bolaMarroMousePressed

    private void butAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAcceptActionPerformed
        List<Integer> Solucio = actuals.subList(1, size+1);
        for (int i : Solucio){
            if (i == 0){
                repeatInfo.setText("La solució no està completa");
                repeatInfo.setVisible(true);
                return;
            }
        }
        System.out.println(Solucio);
        String dif;
        if (dificultat.equals("facil")) dif = "facil";
        else dif = "dificil";
        cPresentacio.cridaControladorPartida_CrearPartida(dif, "CM", Solucio);
        cPresentacio.sincroIntroMaker_a_Partida(dif);
    }//GEN-LAST:event_butAcceptActionPerformed

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
    private javax.swing.JButton butCancel;
    private javax.swing.JPanel disponibles;
    private javax.swing.JLabel repeatInfo;
    private javax.swing.JPanel solucio;
    private javax.swing.JLabel titol;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel solucio1;
    private javax.swing.JLabel solucio2;
    private javax.swing.JLabel solucio3;
    private javax.swing.JLabel solucio4;
    private javax.swing.JLabel solucio5;
    private javax.swing.JLabel solucio6;
}   
