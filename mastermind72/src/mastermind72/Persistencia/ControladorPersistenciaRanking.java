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
import java.util.ArrayList;
import java.util.List;

import mastermind72.Classes.Pair;

/**
 * @author jordi.nieto.maldonado
 */
public class ControladorPersistenciaRanking extends ControladorPersistencia {
    /////// FUNCIONS //////
    
    public ControladorPersistenciaRanking() {}
    
    public void guardaRanking(Boolean facil, List<Pair<String,Integer>> ranking) {
        try {
            String arxiu;
            if (facil) arxiu = folder+"facil.ranking";
            else arxiu = folder+"dificil.ranking";
            
            File f = new File(arxiu);
            f.getParentFile().mkdirs(); // Creem els directoris si no existeixen
            f.createNewFile();  // Creem arxiu si no existeix
            
            FileOutputStream f_out = new FileOutputStream (arxiu);
            ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
            
            obj_out.writeObject (ranking);
            
            obj_out.close();
            f_out.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public Boolean existeixRanking(Boolean facil) {
        String arxiu;
        if (facil) arxiu = folder+"facil.ranking";
        else arxiu = folder+"dificil.ranking";
        
        File f = new File(arxiu);
        return f.exists();
    }
    
    public List<Pair<String,Integer>> carregaRanking(Boolean facil) {
        List<Pair<String,Integer>> ranking = new ArrayList<>();
        String arxiu;
        if (facil) arxiu = folder+"facil.ranking";
        else arxiu = folder+"dificil.ranking";
        
        try {
            File f = new File(arxiu);
            FileInputStream f_in = new FileInputStream(f);
            ObjectInputStream obj_in =new ObjectInputStream(f_in);
            
            ranking = (List<Pair<String,Integer>>) obj_in.readObject();
            
            obj_in.close();
            f_in.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
        return ranking;
    }
}
