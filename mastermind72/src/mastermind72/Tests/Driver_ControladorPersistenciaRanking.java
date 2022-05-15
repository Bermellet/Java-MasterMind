package mastermind72.Tests;

import java.util.*;
import mastermind72.Classes.*;
import mastermind72.Persistencia.ControladorPersistenciaRanking;

/**
 * @author Bermellet
 */
public class Driver_ControladorPersistenciaRanking {
     
    public static void main(String[] args) {
        ControladorPersistenciaRanking cPersist = new ControladorPersistenciaRanking();
        
        List<Pair<String,Integer>> ranking = new ArrayList<>();
        Pair<String,Integer> p = new Pair("Albert", 5);
        ranking.add(p);
        p = new Pair("Isma", 10);
        ranking.add(p);
        
        System.out.println("- Guardem el Ranking Facil amb les entrades: (Albert,5), (Isma,10)");
        cPersist.guardaRanking(true, ranking);
        
        ranking = new ArrayList<>();
        p = new Pair("Jordi", 50);
        ranking.add(p);
        
        System.out.println("- Guardem el Ranking Dificil amb la entrada: (Jordi,50)");
        cPersist.guardaRanking(false, ranking);
        
        System.out.println("\nMirem si hi ha algun Ranking guardat al sistema (han de donar TRUE):");
        System.out.println("  -Ranking facil: " + cPersist.existeixRanking(true));
        System.out.println("  -Ranking dificil: " + cPersist.existeixRanking(false));
        
        
        System.out.println("\nCarreguem els Rankings i els imprimim per pantalla:");
        System.out.println("\nRANKING FACIL:");
        ranking = cPersist.carregaRanking(true);
        int i=0;
        for (Pair<String,Integer> temp : ranking) {
            System.out.println(i + " - Nom:\t" + temp.getLeft());
            System.out.println("  Puntuació:\t" + temp.getRight());
            i++;
        }
        
        System.out.println("\nRANKING DIFICIL:");
        i=0;
        ranking = cPersist.carregaRanking(false);
        for (Pair<String,Integer> temp : ranking) {
            System.out.println(i + " - Nom:\t" + temp.getLeft());
            System.out.println("  Puntuació:\t" + temp.getRight());
            i++;
        }
    }
    
}
