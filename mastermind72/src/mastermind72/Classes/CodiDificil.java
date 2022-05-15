package mastermind72.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Bermellet
 */

public class CodiDificil extends Codi {
    // CodiDificil ha de ser de mida 6
    private final int tamMax = 6;
    
    public CodiDificil() {
        codi = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
    }
    
    public CodiDificil(List<Integer> inp){
        if (inp.size() == tamMax)
            codi = inp;
        else if (inp.size() > tamMax)
            codi = inp.subList(0, tamMax);
        else        // Si el tamany és < tamMax posem un codi per defecte
            codi = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    }
    
    @Override
    public void codiAleatori() {
        Random rand = new Random();
        codi = new ArrayList<>(Arrays.asList(new Integer[tamMax]));
        // Per assegurar maxim 2 repetits
        List<Integer> quant = new ArrayList<>(Arrays.asList(new Integer[8]));
        Collections.fill(quant,0);
        
        for (int i=0; i<tamMax; i++) {
            int value;
            do {
                value = rand.nextInt(8)+1;
            } while (quant.get(value-1)>1);   // Com a molt 2 repetits
                     // rand.nextInt((max - min) + 1) + min;
            codi.set(i,value);
            quant.set(value-1,quant.get(value-1)+1);
        }
    }
}