package mastermind72.Tests;

import java.util.*;
import mastermind72.Classes.*;
import mastermind72.Persistencia.ControladorPersistenciaPartida;

/**
 * @author Bermellet
 */
public class Driver_ControladorPersistenciaPartida {
     
    public static void main(String[] args) {
        ControladorPersistenciaPartida cPersist = new ControladorPersistenciaPartida();
        
        // Simularem que volem guardar una partida
        int id = 72;
        String nom = "TestPartida1", tipusMode="CB", dificultat="facil";
        List<Integer> codiSolucio = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Pair<List<Integer>,Pair<Integer,Integer>>> jugades = new ArrayList();
        Boolean haDemanatAjuda = false;
        
        System.out.println("Guardem una partida amb les dades:");
        System.out.println("  -ID: " + id);
        System.out.println("  -Nom: " + nom);
        System.out.println("  -TipusMode: " + tipusMode);
        System.out.println("  -Dificultat: " + dificultat);
        System.out.println("  -CodiSolució: " + codiSolucio);
        System.out.println("  -Jugades: " + jugades);
        System.out.println("  -HaDemanatAjuda: " + haDemanatAjuda);
        
        cPersist.guardaPartida(id, nom, tipusMode, dificultat, codiSolucio, jugades, haDemanatAjuda);
        
        String partidaAct="";
        System.out.println("\nMirem quines partides tenim guardades:");
        List<Pair<String,String>> partides = cPersist.llistaPartidesGuardades();
        for (Pair<String,String> temp : partides) {
            if (temp.getRight().equals(nom) && temp.getLeft().contains(id+"-")) {
                partidaAct = temp.getLeft();
            }
            System.out.println("\t- "+temp.getRight());
        }
        
        System.out.println("\nCarreguem la partida que acabem de guardar i imprimim les dades:");
        cPersist.carregaPartida(partidaAct);
        System.out.println("  -ID: " + cPersist.getPartidaId());
        System.out.println("  -Nom: " + cPersist.getPartidaNom());
        System.out.println("  -TipusMode: " + cPersist.getPartidaMode());
        System.out.println("  -Dificultat: " + cPersist.getPartidaDificultat());
        System.out.println("  -CodiSolució: " + cPersist.getPartidaSolucio());
        System.out.println("  -Jugades: " + cPersist.getPartidaJugades());
        System.out.println("  -HaDemanatAjuda: " + cPersist.getPartidaDemanatAjuda());
    }
    
}
