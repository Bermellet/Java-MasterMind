/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import mastermind72.Classes.*;

/**
 *
 * @author albert.carreira
 */
public class Testing_Dominio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ControladorPartida cp = new ControladorPartida();
        //ControladorRanking cr = new ControladorRanking();
        
        // CREEM LES DADES
        int id;
        String tipusMode;
        String dificultat;
        List<Integer> solucio = new ArrayList<>();
        
        id=1;
        tipusMode = "CM";
        dificultat = "facil";
        
        if (dificultat.equals("facil")) {
            solucio.add(1);
            solucio.add(2);
            solucio.add(8);
            solucio.add(5);
        } else {
            solucio.add(1);
            solucio.add(2);
            solucio.add(8);
            solucio.add(5);
            solucio.add(6);
            solucio.add(3);
        }
        
        Partida p = new Partida(id, tipusMode, dificultat, new CodiFacil(solucio));
        //Pair<String,Integer> resultat = cp.jugarPartidaActual(dificultat,reader);
        //cr.addRanking(dificultat, resultat);
        
        
        //// TEST GUARDAR OBJECTES SERIALIZABLE ////
        try {
            String arxiu = "./saved_data/test.data";
            File f = new File(arxiu);
            f.getParentFile().mkdirs(); // Creem els directoris
            f.createNewFile();  // Si existeix no el crea
            
            FileOutputStream f_out = new FileOutputStream (arxiu);
            ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
            obj_out.writeObject (p);
            
            obj_out.close();
            f_out.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}
