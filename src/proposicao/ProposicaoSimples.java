package proposicao;

import java.util.HashMap;

public class ProposicaoSimples extends Proposicao {

    private int id = 0;
    private char p;

    public ProposicaoSimples(char p) {
        super();
        this.p = p;
    }

    public ProposicaoSimples(char p, boolean not) {
        this(p);
        this.not = not;
    }

    @Override
    public String toString() {
        if (not)
            return "~(" + p + ")";
        else
            return "(" + p + ")";
    }

    @Override
    public boolean equals(Object o) {
        boolean equals=false;
        if (o instanceof ProposicaoSimples) {
            if (((ProposicaoSimples) o).p == this.p)
                equals = true;
        }

        return equals;
    }

    @Override
    public boolean[] resolver(int numProposicoesSimples, HashMap<String, boolean[]> respostas) {
        if (respostas.containsKey(this.toString())) {
            return respostas.get(this.toString());
        }
        if (this.toString().startsWith("~")) {
            if (respostas.containsKey("" + this.toString().subSequence(4, this.toString().length())) || respostas.containsKey("~ " + this.toString())) {
                boolean[] a = respostas.get("" + this.toString().subSequence(4, this.toString().length()));
                boolean[] b = new boolean[a.length];
                for (int i = 0; i < a.length; i++)
                    b[i] = !a[i];
                return b;
            }
        }
        id = ++numSimples;
        boolean[] b = new boolean[(int) Math.pow(2, numProposicoesSimples)];
        int numConsecutivos = b.length / (int) (Math.pow(2, id));
        int j = 0;
        for (int i = 0; i < (b.length / numConsecutivos) / 2; i++) {
            for (int k = j; k < j + numConsecutivos; k++)
                b[k] = !not;

            j += numConsecutivos;
            for (int k = j; k < j + numConsecutivos; k++)
                b[k] = not;

            j += numConsecutivos;
        }
        this.resposta = b;
        respostas.put(this.toString(), b);
        return b;
    }

    @Override
    public Object clone() {
        ProposicaoSimples p = new ProposicaoSimples(this.p, this.not);
        return p;
    }

}
