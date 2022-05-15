package mastermind72.Classes;

public class Jugada <T extends Codi> {
    private T codi;
    private Pair<Integer,Integer> BN;

    public Jugada() {}
    
    public Jugada(T jugada) {
        codi = jugada;
    }
    
    public Jugada(T jugada, Pair<Integer,Integer> BN) {
        this.codi = jugada;
        this.BN = BN;
    }

    public T getCodi() {
        return this.codi;
    }

    public Pair<Integer,Integer> getBN() {
        return this.BN;
    }

    public Pair<Integer,Integer> executarJugada(T codiSolucio) {
        BN = Codi.compara(codi,codiSolucio);
        return BN;
    }
}
