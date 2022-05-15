package mastermind72.Classes;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author albert
 * @param <T>
 */
public class Partida <T extends Codi>{
    
    int id;
    String tipusMode;
    String dificultat;
    int puntuacio;
    Boolean haDemanatAjuda = false;
    
    T codiSolucio;
    List< Jugada<T> > jugades;
    
    /**
     * Omple la llista amb totes les possibles solucions
     * @param n Nombre de colors utilitzats a la solucio
     * @param arr Array que conté els possibles colors
     * @param S Llista que volem omplir
     */
    private void fill(int n, List<Integer>  arr, List<T> S) {
        // Calculate the number of arrays we should create
        int numArrays = (int)Math.pow(arr.size(), n);
        // Create each array
        for(int i = 0; i < numArrays; i++) {
            if (dificultat.equals("facil")) S.add((T) new CodiFacil());
            else S.add((T) new CodiDificil());
        }
        // Fill up the arrays
        for(int j = 0; j < n; j++) {
            // This is the period with which this position changes, i.e.
            // a period of 5 means the value changes every 5th array
            int period = (int) Math.pow(arr.size(), n - j - 1);
            for(int i = 0; i < numArrays; i++) {
               List<Integer> current = S.get(i).getAsList();
                // Get the correct item and set it
                int index = i / period % arr.size();
                current.set(j,arr.get(index));
            }
        }
        
        int maxNumReps;
        if (dificultat.equals("facil")) maxNumReps = 1;
        else maxNumReps = 2;
        
        List<T> aBorrar = new ArrayList<>();
        for (T t : S){
            List<Integer> code = t.getAsList();
            for (int i = 0; i < code.size(); ++i){
                int count = 1;
                Boolean broke = false;
                int color = code.get(i);
                for (int j = 0; j < code.size(); ++j){
                    if (i == j) continue;
                    if (code.get(j).equals(color)) ++count;
                    if (count > maxNumReps){
                        aBorrar.add(t);
                        break;
                    }
                }
                if (broke) break;
            }
        }
        
        for (T t : aBorrar) S.remove(t);
    }
    
    /**
     * Retorna la llista de possibles candidats per a seleccionar posteriorment
     * aplicant la tècnica de minimax
     * @param allCombinations Totes les combinacions possibles
     * @param S Llista de candidats filtrada anteriorment
     * @return La llista de possibles candidats a ser seleccionats
     */
    private List<T> minimax(List<T> allCombinations, List<T> S) {
        int max, min; max = 0; min = Integer.MAX_VALUE;
        Map<Pair<Integer,Integer>,Integer> counters = new HashMap<>();
        Map<T,Integer> punctuation = new HashMap<>();
        List<T> possibleCandidates = new ArrayList<>();
        
        for (T candidateGuess : allCombinations){            
            for (T tempSecret : S){
                Pair<Integer,Integer> result = Codi.compara(candidateGuess, tempSecret);

                if (counters.containsKey(result)){
                    counters.put(result, counters.get(result)+1);
                }
                else {
                    counters.put(result, 1);
                }
            }
            
            //get the maximum of all the counters
            for (Map.Entry<Pair<Integer,Integer>,Integer> elem : counters.entrySet()){
                if (elem.getValue() > max) max = elem.getValue();
            }
            punctuation.put(candidateGuess, max);
            counters.clear();
        }
        
        //get the minimum of all the punctuations
        for (Map.Entry<T,Integer> elem : punctuation.entrySet()){
            if (elem.getValue() < min) min = elem.getValue();
        }
        
        for (T key : punctuation.keySet()){
            int temp = punctuation.get(key);
            if (temp == min) possibleCandidates.add(key);
        }
        
        return possibleCandidates;
    }

    /**
     * Genera una solucio aleatòria 
     */
    private void generaSolucioAleatoria(){
        codiSolucio.codiAleatori();
    }
    
    /**
     * Constructora de la classe, inicialitza jugades
     */
    public Partida(){
        jugades = new ArrayList<>();
    }
    
    /**
     * Constructora amb paràmetres, inicialitza totes els atributs
     * @param id Identificador de la partida
     * @param tipusMode Mode en el que es juga la partida
     * @param dificultat Dificultat en la que es juga la partida
     * @param solucio Codi corresponent a la solució
     */
    public Partida(int id, String tipusMode, String dificultat, T solucio){
        this.id = id;
        this.tipusMode = tipusMode;
        this.dificultat = dificultat;
        jugades = new ArrayList<>();
        codiSolucio = solucio;
        if (tipusMode.equals("CB")) generaSolucioAleatoria();
    }
    /**
     * Constructor per a poder carregar una partida
     * @param id Identificador de la partida
     * @param tipusMode Mode en el que es juga la partida
     * @param dificultat Dificultat en la que es juga la partida
     * @param solucio Codi corresponent a la solució
     * @param jugades Llista de jugades que ja s'havien fet
     * @param demanatAjuda Si el jugador havia demanat ajuda abans o no
     */
    public Partida(int id, String tipusMode, String dificultat, T solucio, List<Pair<T,Pair<Integer,Integer>>> jugades, Boolean demanatAjuda){
        this.id = id;
        this.tipusMode = tipusMode;
        this.dificultat = dificultat;
        
        this.jugades = new ArrayList();
        for (Pair<T,Pair<Integer,Integer>> j : jugades){
            this.jugades.add( 
                new Jugada<T>( 
                        j.getLeft() , 
                        j.getRight() 
                ) 
            );
        }
        
        this.codiSolucio = solucio;
        this.haDemanatAjuda = demanatAjuda;
    }
    
    /**
     * Retorna la puntuació actual
     * @return La puntuació actual
     */
    public int      getPuntuacio()  { calculaPuntuacio(); return puntuacio;}
    /**
     * Retorna el mode actual
     * @return El mode actual
     */
    public String   getMode()       { return tipusMode;}
    /**
     * Retorna la dificultat actual
     * @return La dificultat actual
     */
    public String   getDificultat() { return dificultat;}
    /**
     * Retorna la solució actual
     * @return La llista amb la solució actual
     */
    public List<Integer>   getSolucio() { return codiSolucio.getAsList();}
    /**
     * Retorna la llista de jugades (codi i resultat)
     * @return Llista de jugades amb el codi i cada resultat
     */
    public List<Pair<List<Integer>,Pair<Integer,Integer>>>   getJugades() { 
        List<Pair<List<Integer>,Pair<Integer,Integer>>> temp = new ArrayList<Pair<List<Integer>,Pair<Integer,Integer>>>();
        for (Jugada<T> j : this.jugades){
            temp.add(new Pair(j.getCodi().getAsList(),j.getBN()));
        }
        return temp;
    }
    /**
     * Retorna si l'usuari ha demanat ajuda o no
     * @return Si l'usuari ha demanat ajuda
     */
    public Boolean getDemanatAjuda() { return haDemanatAjuda;}
        
    /**
     * S'executa la partida en mode CM
     * @param solucio Codi de la solució a resoldre
     * @return Llista de jugades fetes fins arribar a la solució
     */
    public List<Pair<List<Integer>,Pair<Integer,Integer>>> jugarPartidaCM(List<Integer> solucio){
        int number_of_colors_used = codiSolucio.size();
        int number_of_colors = 8;
        int different_permutations = (int) pow(number_of_colors,number_of_colors_used);
        
        List<T> S = new ArrayList<>(different_permutations);

        //Fill the pool 
            List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[number_of_colors]));
            for (int i = 1; i <= number_of_colors; ++i) numbers.set(i-1, i);
            fill(number_of_colors_used,numbers,S);
 
        List<T> allCombinations = new ArrayList<>(); 
        allCombinations.addAll(S); //containing all possible combinations
            
        // 2. Always start with the guess of 1122 33 44...
        
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[number_of_colors_used]));
        for(int i=0; i<number_of_colors_used; i++) {
            list.set(i, (i/2)+1);
        }
        T guess;
        if (dificultat.equals("facil")) guess = (T)new CodiFacil(list);
        else guess = (T)new CodiDificil(list);
        
        allCombinations.remove(guess);
        S.remove(guess);
        
        List<Jugada<T>> partials = new ArrayList<>();
        while(true){     
            Jugada<T> jugadaInicial = new Jugada(guess);
            jugadaInicial.executarJugada(codiSolucio);
            Pair<Integer,Integer> BN = jugadaInicial.getBN();
            
            partials.add(jugadaInicial);
  
            if (BN.getRight() == 4){ // 4. SOLUTION FOUND!! :D
                System.out.println("Solucio trobada: " + guess.getAsList());
                List<Pair<List<Integer>,Pair<Integer,Integer>>> codis = new ArrayList<>();
                for (Jugada<T> t : partials) {
                    // Es a dir, el codi de la jugada + el parell de blanques i negres
                    Pair<List<Integer>,Pair<Integer,Integer>> p = 
                            new Pair(t.getCodi().getAsList(), t.getBN());
                    codis.add(p);
                }
                return codis;
            } 
            else{ 
                // 5. Remove from S all possibilities that would not give the same response if the guess 
                // were the code
                List<T> aBorrar = new ArrayList<>();
                Pair<Integer,Integer> resposta = jugadaInicial.getBN();
                
                for (int index = 0; index < S.size(); ++index){
                    T code = S.get(index);                  
                    Jugada<T> jugada = new Jugada(code);
                    jugada.executarJugada(guess);
                    Pair<Integer,Integer> result = jugada.getBN();
                    if (!resposta.equals(result)){
                        aBorrar.add(code);
                    }
                }
                
                for (T t: aBorrar){
                    S.remove(t);
                }
                
                //get Minimax 
                List<T> possibleCandidates = minimax(allCombinations, S);
                                
                //chose one of the possible candidates, priorizing the first in S
                int index = -1;
                for (int i = 0; i < possibleCandidates.size(); i++) {
                    if (S.contains(possibleCandidates.get(i))){
                        index = i;
                        break;
                    }                           
                }
                if (index == -1){
                    for (int i = 0; i < possibleCandidates.size(); i++) {
                        if (allCombinations.contains(possibleCandidates.get(i))){
                            index = i;
                            break;
                        }
                    }                           
                }
                guess = possibleCandidates.get(index);
            }
        }
    } 
    
    /**
     * Introdueix un codi i retorna el resultat
     * @param codi Codi a introduir
     * @return Resultat de jugar el codi (B/N)
     */
    public Pair<Integer,Integer> introduirJugada(T codi){
        Jugada<T> j = new Jugada(codi);
        
        j.executarJugada(codiSolucio); // Compara i guarda el resultat
        jugades.add(j);     // Afegim la jugada amb BN calculat (si guardem abans BN = null)
        
        Pair<Integer,Integer> BN = j.getBN();
        return BN;
    }
    
    /**
     * Calcula la puntuació segons el nombre de jugades o si ha demanat ajuda
     */
    public void calculaPuntuacio(){
        puntuacio = jugades.size();
        if (haDemanatAjuda) puntuacio += 10;
    }    
    
    /**
     * Retorna una bola al atzar de les que apareixen a la solució i que no
     * s'ha introduit a la jugada amb més resultats correctes
     * @return El color de la bola escollida que apareix a la solució i no s'ha 
     * jugat a la jugada amb millor resultat
     */
    public int bolaAmbAjuda(){
        haDemanatAjuda = true;
        
        // Ens quedem amb la jugada que ha tret més negres
        int index = -1;
        for (int max = -1, i = 0; i < jugades.size(); ++i){
            Jugada<T> j = jugades.get(i);
            if (j.getBN().getRight() > max) index = i;
        }
        if (index == -1) return -1; //No ha introduit cap jugada -> invalid
        T codiAmbMesNegres = jugades.get(index).getCodi();
        
        return Codi.colorAleatori(codiSolucio, codiAmbMesNegres);
    }
}