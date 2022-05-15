/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Persistencia;

import java.util.ArrayList;
import java.util.List;
import mastermind72.Classes.Pair;

/**
 *
 * @author Bermellet
 */
public class testPersistencia {
    public static void main(String[] args) {
            //// TEST GUARDAR RECORD FACIL OBJECTES SERIALIZABLE ////
        ControladorPersistenciaRanking cp = new ControladorPersistenciaRanking();
        
        Integer id = 69;
        List<Pair<String,Integer>> llista = new ArrayList<>();
        Pair<String,Integer> p = new Pair("Jordi",15);
        llista.add(p);
        p = new Pair("Albertka",100);
        llista.add(p);
        
        cp.guardaRanking(true,llista);
        
        List<Pair<String,Integer>> resultat = cp.carregaRanking(true);
        
        for (Pair<String,Integer> temp : resultat) {
            System.out.println(temp.getLeft() + ":   " + temp.getRight());
        }
    }
}
