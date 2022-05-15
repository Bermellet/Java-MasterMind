package mastermind72.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author Bermellet
 */
abstract public class Codi {
    // CONSTANTS DELS COLORS
    public static final int GROC    = 1;
    public static final int TARONJA = 2;
    public static final int VERMELL = 3;
    public static final int ROSA    = 4;
    public static final int VERD    = 5;
    public static final int BLAU    = 6;
    public static final int VIOLETA = 7;
    public static final int MARRO   = 8;
    
    // VARIABLES
    protected List<Integer> codi;
    
    
    // FUNCIONS    
    abstract void codiAleatori();
    
    // Funció estàtica per comparar dos codis
    public static Pair<Integer,Integer> compara(Codi c1, Codi c2) {
        int negres = 0;
        int blanques = 0;
        
        List<Boolean> visitat = new ArrayList<>(Arrays.asList(new Boolean[c1.codi.size()]));
        Collections.fill(visitat,Boolean.FALSE);
        
        for (int i=0; i < c1.codi.size(); i++) {
            if (Objects.equals(c1.codi.get(i), c2.codi.get(i))){
                negres++;
                visitat.set(i,Boolean.TRUE);
            } else {
                for (int j=0; j < c2.codi.size(); j++){
                    if (Objects.equals(c1.codi.get(i), c2.codi.get(j)) && !visitat.get(j) && !Objects.equals(c1.codi.get(j), c2.codi.get(j))) {
                        blanques++;
                        visitat.set(j,Boolean.TRUE);
                        break;
                    }
                }
            }
        }
        
        return new Pair(blanques,negres);
    }
    
    public static Integer colorAleatori(Codi sol, Codi codiAmbMesNegres){
        Random rand = new Random();
        List<Integer> noReps = new ArrayList<>();
        
        for (int i : sol.getAsList()){
            if (!codiAmbMesNegres.getAsList().contains(i)) noReps.add(i);
        }
        int value;
        do {
            value = rand.nextInt(8)+1;
        } while (!noReps.contains(value));
        return value;
    }
    
    public int size() {
        return codi.size();
    }
    
    public List<Integer> getAsList() {
        return codi;
    }
    
}