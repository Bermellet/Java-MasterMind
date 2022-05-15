package mastermind72.Tests;

import mastermind72.Classes.*;

/**
 * @author albert.carreira
 */
public class Driver_ControladorRanking {
    
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
        ControladorRanking cRanking = new ControladorRanking();
        System.out.println("Provant el mètode addRanking: ");
        System.out.println("\tAfegim un nou record al Ranking facil: (NomFacil1, 10)");
        System.out.println("\tAfegim un nou record al Ranking dificil (NomDificil1, 100)");
        Pair<String,Integer> p1,p2;
        p1 = new Pair("NomFacil", 10);
        p2 = new Pair("NomDificil", 100);
        
        cRanking.addRanking("facil",p1);
        cRanking.addRanking("dificil",p2);
        
        System.out.println("\nProvant el mètode getRanking:");
        System.out.println("  -Obtenim el ranking fàcil:");
        Ranking R = cRanking.getRanking("facil");
        imprimeixRanking(R);
        
        System.out.println("  -Obtenim el ranking dificil:");
        R = cRanking.getRanking("dificil");
        imprimeixRanking(R);
        
        System.out.println("\nAfegim nous registres als Rankings: ");
        System.out.println("\tAfegim un nou record a ranking facil: (NomFacil2, 20)");
        System.out.println("\tAfegim un nou record a ranking dificil (NomDificil2, 200)");
        p1 = new Pair("NomFacil2",20);
        p2 = new Pair("NomDificl2",200);
        cRanking.addRanking("facil", p1);
        cRanking.addRanking("dificil", p2);
        
        System.out.println("\nMostrem els rècords actualitzats:");
        R = cRanking.getRanking("facil");
        imprimeixRanking(R);
        R = cRanking.getRanking("dificil");
        imprimeixRanking(R);
    }
    
}
