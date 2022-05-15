package mastermind72.Tests;

import java.util.*;
import mastermind72.Classes.*;

/**
 * @author Bermellet
 */
public class Driver_CodiFacil {
     
    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,3,8,6};
        List<Integer> input = new ArrayList<>(Arrays.asList(array));
        
        CodiFacil codi1 = new CodiFacil(input);
        CodiFacil codi2 = new CodiFacil(input);
        
        System.out.println("TEST DE LA CLASSE CodiFacil");
        System.out.println("-----------------------------");
        
        // Comprovem els valors dels codis i mostrem el càlcul de Boles BN varies vegades:
        System.out.println("CODI1 = " + codi1.getAsList());
        System.out.println("CODI2 = " + codi2.getAsList());
        
        Pair<Integer,Integer> p = Codi.compara(codi1,codi2);
        System.out.println("Boles => Blanques: "+ p.getLeft() + "\tNegres: "+ p.getRight()+"\n");
        
        array[2] = 4;
        array[3] = 8;
        input = new ArrayList<>(Arrays.asList(array));
        codi2 = new CodiFacil(input);
        
        System.out.println("CODI1 = " + codi1.getAsList());
        System.out.println("CODI2 = " + codi2.getAsList());
        
        p = Codi.compara(codi1,codi2);
        System.out.println("Boles => Blanques: "+ p.getLeft() + "\tNegres: "+ p.getRight()+"\n");
        
        array = new Integer[] {6,8,3,1};
        input = new ArrayList<>(Arrays.asList(array));
        codi2 = new CodiFacil(input);
        
        System.out.println("CODI1 = " + codi1.getAsList());
        System.out.println("CODI2 = " + codi2.getAsList());
        
        p = Codi.compara(codi1,codi2);
        System.out.println("Boles => Blanques: "+ p.getLeft() + "\tNegres: "+ p.getRight()+"\n");
        
        // Comparem dos codis generats aleatòriament
        codi1.codiAleatori();
        codi2.codiAleatori();
        System.out.println("Generem dos Codis Aleatoris i els comparem (B/N):");
        System.out.println("CODI1 = " + codi1.getAsList());
        System.out.println("CODI2 = " + codi2.getAsList());
        
        p = Codi.compara(codi1,codi2);
        System.out.println("Boles => Blanques: "+ p.getLeft() + "\tNegres: "+ p.getRight()+"\n");
        
        
        System.out.println("Control d'errors en les creadores:");
        // Creadora per defecte omple de 0:
        codi1 = new CodiFacil();
        System.out.println("- CODI per defecte(tot 0) = " + codi1.getAsList());
        
        // CREADORA INCORRECTA (tamany < 4 o > 4)
        input = new ArrayList<>(Arrays.asList(8,7,6,5,4,3,2,1));
        codi1 = new CodiFacil(input);
        System.out.println("- Tamany de codiFacil MAJOR de 4 (el retallem): " + codi1.getAsList());
        System.out.println("\tLa llista original era: "+input);
        
        input = new ArrayList<>(Arrays.asList(5,5));
        codi1 = new CodiFacil(input);
        System.out.println("- Tamany de codiFacil MENOR de 4 (posem un codi per defecte): " + codi1.getAsList());
        
        // Mida del codi (sempre 4)
        System.out.println("\nMida de codi (sempre 4): " + codi1.size()+"\n");
    }
    
}
