package mastermind72.Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Bermellet
 */

public class Ranking {
    // VARIABLES
    private List<Pair<String,Integer>> ranking;
    // LEFT -> NOMBRE       RIGHT -> PUNTUACION
    
    
    public Ranking() {
        ranking = new ArrayList<>();
    }
    
    // Creadora para un ranking cargado
    public Ranking(List<Pair<String,Integer>> r) {
        ranking = r;
        ordenaLista();  // Nos aseguramos que esté ordenada
        if (ranking.size()>10) // Nos aseguramos que sea de tamaño máximo 10
            ranking = ranking.subList(0, 10);
    }
    
    // Ordenem els records ascendentment
    private void ordenaLista() {
        Collections.sort(ranking, new Comparator<Pair<String,Integer>>(){
            public int compare(Pair<String,Integer> p1, Pair<String,Integer> p2) {
                return p1.getRight().compareTo(p2.getRight());  // SI SON IGUALES ¿?
            }
        });
        //Collections.reverse(ranking); // Si ho volguessim ordenar al reves
    }
    
    // TRUE -> ERA RECORD, AÑADIDO      // FALSE -> NO ERA RECORD
    public Boolean add(Pair<String,Integer> p){
        Integer pos = buscaPos(p.getRight());
        if (pos==-1) return false;
        else {
            ranking.add(pos, p);
            if (ranking.size()>10) ranking.remove(10);
            return true;
        }
    }
    
    public Boolean add(String s, Integer i){
        Pair p = new Pair(s,i);
        return add(p);
    }
    
    // Return posicion a la que iría o -1
    private Integer buscaPos(Integer puntuacio) {
        if (ranking.isEmpty()) return 0;
        else {
            int pos=-1;
            for (int i=0; i<ranking.size() && pos == -1; i++) {
                if (ranking.get(i).getRight() >= puntuacio) pos = i;
            }
            
            if (ranking.size()<10 && pos==-1) pos = ranking.size(); // -1 ¿?¿?
            return pos;
        }
    }
    
    public Boolean esRecord(Integer puntuacio) {
        if (ranking.size() < 10) return true;
        return (puntuacio <= ranking.get(ranking.size()-1).getRight());
    }
    
    public List<Pair<String,Integer>> getListRanking() {
        return ranking;
    }

}