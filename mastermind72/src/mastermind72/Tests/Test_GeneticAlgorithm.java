/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind72.Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bermellet
 */
public class Test_GeneticAlgorithm {
    /*List<List<Integer>> guesses = new ArrayList<>();
    
    public float fitness_score() {
        return 0;
    }
    
    public static void main(String[] args) {
        List<Integer> init = Arrays.asList(1,1,2,2);
        
        
    }*/
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(temp);
        List<Integer> impr = temp.subList(0,4);
        System.out.println(impr);
        System.out.println(temp);
    }
    
}
