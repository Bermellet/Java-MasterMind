package mastermind72.Tests;

import java.util.*;
import mastermind72.Classes.*;

/**
 * @author Bermellet
 */
public class Driver_Ranking {
    
    private static void imprimeixRanking(Ranking r) {
        int i=1;
        for (Pair<String,Integer> temp : r.getListRanking()) {
            System.out.println(i + "-Nom:\t\t" + temp.getLeft());
            System.out.println("   Puntuació:\t" + temp.getRight());
            i++;
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        
        String nom = "Albert2";
        Integer puntuacio = 50;
        ranking.add(nom,puntuacio);     // Podem afegir com a String i Integer
        imprimeixRanking(ranking);
        
        nom = "Isma";
        puntuacio = 500;
        ranking.add(nom,puntuacio);
        imprimeixRanking(ranking);
        
        
        nom = "Jordi";
        puntuacio = 5;
        Pair<String,Integer> p = new Pair(nom,puntuacio);
        ranking.add(p);     // Podem afegir com a Pair<String,Integer>
        imprimeixRanking(ranking);
        
        System.out.println("\nComprovem que és de mida 10:");
        
        for(int i=0; i<8; i++) ranking.add(p);
        imprimeixRanking(ranking);
        
        System.out.println("\nComprova be si és o no record:");
        System.out.println("\tHa de donar TRUE -> "+ranking.esRecord(puntuacio));
        System.out.println("\tHa de donar FALSE -> "+ranking.esRecord(500));
        
        
        System.out.println("\nComprovem que tenen prioritat els nous records(en cas d'igualtat):");
        ranking.add(p);
        nom = "BermeCheto";
        ranking.add(nom,puntuacio);
        imprimeixRanking(ranking);
        
        
        System.out.println("\nComprovem que al carregar un Ranking existent l'ordena i el deixa de tamany 10:");
        
        p = new Pair("Test",20);
        List<Pair<String,Integer>> llista = new ArrayList<>();
        
        for(Integer i=20; i>0; i--) {
            p = new Pair("Test",i);
            llista.add(p);
        }
        
        System.out.println("Llista original: ");
        int i=0;
        for (Pair<String,Integer> temp : llista) {
            if (i>0)
                System.out.print(", ");
            if ((i%5) == 0)
                System.out.println();
            
            System.out.print("(" + temp.getLeft() + "," + temp.getRight() + ")");
            i++;
        }
        System.out.println();
        
        ranking = new Ranking (llista);
        System.out.println("\nRanking al carregar-se:");
        imprimeixRanking(ranking);
    }
    
}
