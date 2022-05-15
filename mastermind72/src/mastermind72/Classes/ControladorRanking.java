package mastermind72.Classes;

import mastermind72.Persistencia.ControladorPersistenciaRanking;

/**
 * @author Bermellet
 */

public class ControladorRanking {
    private ControladorPersistenciaRanking cPersist;
    private Ranking rankingFacil;
    private Ranking rankingDificil;
    
    public ControladorRanking(){
        cPersist = new ControladorPersistenciaRanking();
        // Carrega ranking facil si n'hi ha guardat
        if(cPersist.existeixRanking(true))
            rankingFacil = new Ranking(cPersist.carregaRanking(true));
        else
            rankingFacil = new Ranking();
        // Carrega ranking dificil si n'hi ha guardat
        if(cPersist.existeixRanking(false))
            rankingDificil = new Ranking(cPersist.carregaRanking(false));
        else
            rankingDificil = new Ranking();
    }
    
    public Ranking getRanking(String dificultat){
        if (dificultat.equals("facil")) return rankingFacil;
        else return rankingDificil;
    }
    
    public void addRanking(String dificultat, Pair<String,Integer> resultat){
        if (dificultat.equals("facil")){
            if (rankingFacil.esRecord(resultat.getRight()))
                rankingFacil.add(resultat);
        } else {
            if (rankingDificil.esRecord(resultat.getRight()))
                rankingDificil.add(resultat);
        }
        guardaRanking(dificultat);
    }
    
    // PERSISTENCIA
    private void guardaRanking(String dificultat) {
        if (dificultat.equals("facil"))
            cPersist.guardaRanking(true, rankingFacil.getListRanking());
        else
            cPersist.guardaRanking(false, rankingDificil.getListRanking());
    }
}
