package mastermind72.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Bermellet
 */

public class CodiFacil extends Codi {
    // CodiFacil ha de ser de mida 4
    private final int tamMax = 4;
    
    public CodiFacil() {
        codi = new ArrayList<>(Arrays.asList(0,0,0,0));
    }
    
    public CodiFacil(List<Integer> inp){
        if (inp.size() == tamMax)
            codi = inp;
        else if (inp.size() > tamMax)
            codi = inp.subList(0, tamMax);
        else        // Si el tamany és < tamMax posem un codi per defecte
            codi = new ArrayList<>(Arrays.asList(1,2,3,4));
    }
    
    @Override
    public void codiAleatori() {
        Random rand = new Random();
        codi = new ArrayList<>(Arrays.asList(new Integer[tamMax]));
        
        for (int i=0; i<tamMax; i++) {
            int value;
            do {
                value = rand.nextInt(8)+1;
            } while (codi.contains(value));
                     // rand.nextInt((max - min) + 1) + min;
            codi.set(i,value);
        }
    }
}