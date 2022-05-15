/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mastermind72.Classes.Pair;

/**
 * @author jordi.nieto.maldonado
 */
public class ControladorPersistenciaPartida extends ControladorPersistencia {
    private int id;
    private String nom;
    private String tipusMode;
    private String dificultat;
    private List<Integer> codiSolucio;
    private List<Pair<List<Integer>,Pair<Integer,Integer>>> jugades;
    private Boolean haDemanatAjuda;
    
    /////// FUNCIONS //////
    
    public ControladorPersistenciaPartida() {
        emptyVariables();
    }
    
    private void emptyVariables() {
        id = -1;
        nom = null;
        tipusMode = null;
        dificultat = null;
        codiSolucio = null;
        jugades = null;
        haDemanatAjuda = null;
    }
    
    // Mirar que hi hagi partida guardada ¿?
    public int getPartidaId() { return id; }
    public String getPartidaNom() { return nom; }
    public String getPartidaMode() { return tipusMode; }
    public String getPartidaDificultat() { return dificultat; }
    public List<Integer> getPartidaSolucio() { return codiSolucio; }
    public List<Pair<List<Integer>,Pair<Integer,Integer>>> getPartidaJugades() { return jugades; }
    public Boolean getPartidaDemanatAjuda() { return haDemanatAjuda; }
    
    
    
    // CANVIAR A MIRAR EXTENSIÓ .partida
    public List<Pair<String,String>> llistaPartidesGuardades() {
        List<Pair<String,String>> res = new ArrayList<>();
        File f = new File(folder);
        File[] listFiles = f.listFiles();
        
        if (listFiles == null) return res;
        
        for (File file : listFiles){
            if (file.isFile() && file.getName().endsWith(".partida")) {
                String nom_temp="";
                try {
                    File f1 = new File(folder+file.getName());
                    FileInputStream f_in = new FileInputStream(f1);
                    ObjectInputStream obj_in =new ObjectInputStream(f_in);
                    
                    int id_temp = (int) obj_in.readObject();
                    nom_temp = (String) obj_in.readObject();
                    
                    obj_in.close();
                    f_in.close();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                
                res.add(new Pair(file.getName(),nom_temp));
            }
        }
        return res;
    }

    
    // Carregar partida seleccionada
    public void carregaPartida(String arxiu) {
        // En assegurem que les variables estiguin buides
        emptyVariables();
        
        try {
            File f = new File(folder+arxiu);
            FileInputStream f_in = new FileInputStream(f);
            ObjectInputStream obj_in =new ObjectInputStream(f_in);
            
            id = (int) obj_in.readObject();
            nom = (String) obj_in.readObject();
            tipusMode = (String) obj_in.readObject();
            dificultat = (String) obj_in.readObject();
            codiSolucio = (List<Integer>) obj_in.readObject();
            jugades = (List<Pair<List<Integer>,Pair<Integer,Integer>>>) obj_in.readObject();
            haDemanatAjuda = (Boolean) obj_in.readObject();
            
            obj_in.close();
            f_in.close();
            
            // Com la partida ja esta carregada, eliminem les dades del fitxer
            f.delete();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    
    public void guardaPartida(int id, String nom, String tipusMode, String dificultat,
            List<Integer> codiSolucio, List<Pair<List<Integer>,Pair<Integer,Integer>>> jugades, Boolean haDemanatAjuda) {
        
        try {
            String date = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
            String arxiu = folder+id+"-"+date+".partida";
            
            File f = new File(arxiu);
            f.getParentFile().mkdirs(); // Creem els directoris si no existeixen
            f.createNewFile();  // Creem arxiu si no existeix
            
            FileOutputStream f_out = new FileOutputStream (arxiu);
            ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
            
            obj_out.writeObject (id);
            obj_out.writeObject (nom);
            obj_out.writeObject (tipusMode);
            obj_out.writeObject (dificultat);
            obj_out.writeObject (codiSolucio);
            obj_out.writeObject (jugades);
            obj_out.writeObject (haDemanatAjuda);
            
            obj_out.close();
            f_out.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public int getIdToAssign(){
        int idToAssign=0;
        try {
            File f = new File(folder+"dades.game");
            if(f.exists()) {
                FileInputStream f_in = new FileInputStream(f);
                ObjectInputStream obj_in =new ObjectInputStream(f_in);

                idToAssign = (int) obj_in.readObject();

                obj_in.close();
                f_in.close();
            }
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return idToAssign;
    }
    
    public void guardaIdToAssign(int id){
        try {
            String arxiu = folder+"dades.game";
            
            File f = new File(arxiu);
            f.getParentFile().mkdirs(); // Creem els directoris si no existeixen
            f.createNewFile();  // Creem arxiu si no existeix
            
            FileOutputStream f_out = new FileOutputStream (arxiu);
            ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
            
            obj_out.writeObject (id);
            
            obj_out.close();
            f_out.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
