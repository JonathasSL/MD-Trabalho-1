package proposicao;

import java.util.HashMap;

public abstract class Argumento {

    public static final int NAO=0, E=1, OU=2, OU_OU=3, SE_ENTAO=4, SE_E_SOMENTE_SE=5;
    protected static int numSimples = 0;
    protected boolean[] resposta = null;
    public boolean not = false;
    public int pos;

    public static void clear(){ numSimples = 0; }

    public Argumento negado() {
        Argumento p = (Argumento) this.clone();
        p.not = !p.not;
        return p;
    }

    public boolean[] getResposta() {
        return resposta;
    }

    // Métodos abstratos
    @Override public abstract boolean equals(Object o);
    @Override public abstract Object clone();
    public abstract boolean[] resolver(int numProposicoesSimples, HashMap<String, boolean[]> respostas);


}
