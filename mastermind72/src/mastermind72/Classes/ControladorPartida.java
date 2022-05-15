package mastermind72.Classes;

import java.util.*;
import mastermind72.Persistencia.ControladorPersistenciaPartida;

public class ControladorPartida {
    private ControladorPersistenciaPartida cPersist;
    private Partida partida;
    private int idToAssign = 0;
    
    public ControladorPartida() {
        cPersist = new ControladorPersistenciaPartida();
        idToAssign = cPersist.getIdToAssign();
    }

    public void crearPartida(String tipusMode, String dificultat, List<Integer> solucio) {      
        ++idToAssign;      
        if (dificultat.equals("facil"))
            partida = new Partida<>(idToAssign,tipusMode,"facil", new CodiFacil(solucio));
        else
            partida = new Partida<>(idToAssign,tipusMode,"dificil", new CodiDificil(solucio));      
    }
    
    public void guardarPartida(String nom) {
        cPersist.guardaPartida(idToAssign, nom, partida.getMode(), partida.getDificultat(), partida.getSolucio(), partida.getJugades(), partida.getDemanatAjuda());
    }
    
    public String carregarPartida(String arxiu) {
        cPersist.carregaPartida(arxiu);
        
        if (cPersist.getPartidaDificultat().equals("facil")) {
            List<Pair<List<Integer>,Pair<Integer,Integer>>> temp = cPersist.getPartidaJugades();
            List<Pair<CodiFacil,Pair<Integer,Integer>>> paramLista = new ArrayList<>();
            
            for (Pair<List<Integer>,Pair<Integer,Integer>> t : temp){
                paramLista.add(new Pair<> (
                        new CodiFacil(t.getLeft()), 
                        t.getRight()
                ));
            }
                        
            partida = new Partida<>(
                    cPersist.getPartidaId(),
                    cPersist.getPartidaMode(),
                    cPersist.getPartidaDificultat(),
                    new CodiFacil(cPersist.getPartidaSolucio()),
                    paramLista, cPersist.getPartidaDemanatAjuda());
        }
        else {
            List<Pair<List<Integer>,Pair<Integer,Integer>>> temp = cPersist.getPartidaJugades();
            List<Pair<CodiDificil,Pair<Integer,Integer>>> paramLista = new ArrayList<>();
            
            for (Pair<List<Integer>,Pair<Integer,Integer>> t : temp){
                paramLista.add(new Pair<>(
                        new CodiDificil(t.getLeft()), 
                        t.getRight()
                ));
            }
            
            partida = new Partida<>(
                    cPersist.getPartidaId(),
                    cPersist.getPartidaMode(),
                    cPersist.getPartidaDificultat(),
                    new CodiDificil(cPersist.getPartidaSolucio()),
                    paramLista, cPersist.getPartidaDemanatAjuda());
        }
        
        return cPersist.getPartidaDificultat();
    }
    
    public List<Pair<String,String>> consultarllistaPartidesGuardades() {
        return cPersist.llistaPartidesGuardades();
    }
    
    public Pair<Integer,Integer> introduirJugada(List<Integer> jugada){
        Codi j;
        if (partida.getDificultat().equals("facil")) j = new CodiFacil(jugada);
        else j = new CodiDificil(jugada);
        return partida.introduirJugada(j);
    }
    
    public List<Pair<List<Integer>,Pair<Integer,Integer>>> jugarPartidaCM(List<Integer> solucio){
        return partida.jugarPartidaCM(solucio);
    }
    public int getBolaAmbAjuda(){
       return partida.bolaAmbAjuda();
    }
    
    public int getPuntuacio(){
        partida.calculaPuntuacio();
        return partida.getPuntuacio();
    }
    
    public List<Integer> getSolucio(){
        return partida.getSolucio();
    }    
    
    public List<Pair<List<Integer>,Pair<Integer,Integer>>> getJugades(){
        return partida.getJugades();
    }
    
    public void guardarDades(){
        cPersist.guardaIdToAssign(idToAssign);
    }
}
