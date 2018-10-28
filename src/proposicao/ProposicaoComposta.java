package proposicao;

import java.util.ArrayList;
import java.util.HashMap;

public class ProposicaoComposta extends Proposicao {

    protected Proposicao a = null, b = null;
    protected int conectivo;


    public ProposicaoComposta(Proposicao a, Proposicao b, int conectivo) {
        super();
        this.a = a;
        this.b = b;
        this.conectivo = conectivo;
    }

    public ProposicaoComposta(ProposicaoComposta p, boolean not) {
        this(p.a, p.b, p.conectivo, not);
    }

    public ProposicaoComposta(Proposicao a, Proposicao b, int conectivo, boolean not) {
        this(a, b, conectivo);
        this.not = not;
    }

    @Override
    public String toString() {
        String conec;
        switch (conectivo) {
            case NAO:
                conec = "~";
                break;
            case E:
                conec = "∧";
                break;
            case OU:
                conec = "∨";
                break;
            case OU_OU:
                conec = "⊻";
                break;
            case SE_ENTAO:
                conec = "→";
                break;
            case SE_E_SOMENTE_SE:
                conec = "↔";
                break;
            default:
                conec = null;
                break;
        }
        if (not) return "~ ( " + a + " " + conec + " " + b + " )";
        else return "( " + a + " " + conec + " " + b + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ProposicaoComposta) {
            ProposicaoComposta p = (ProposicaoComposta) o;
            if (p.a.equals(this.a) && p.b.equals(this.b) && p.conectivo == this.conectivo)
                return true;
            else
                return false;
        }
        else return false;
    }

    public boolean[] resolver() {
        return resolver(getNumProposicoesSimples(), new HashMap<>());
    }

    @Override
    public boolean[] resolver(int numProposicoesSimples, HashMap<String, boolean[]> respostas) {
        if (respostas.containsKey(this.toString())) {
            return respostas.get(this.toString());
        }
        if (this.toString().startsWith("~")) {
            boolean[] a = not ? this.negado().resolver(numProposicoesSimples, respostas) : this.resolver(numProposicoesSimples, respostas);
            boolean[] b = new boolean[a.length];
            for (int i = 0; i < a.length; i++)
                b[i] = !a[i];
            return b;
        }
        boolean[] a = this.a.resolver(numProposicoesSimples, respostas);
        boolean[] b = this.b.resolver(numProposicoesSimples, respostas);
        boolean[] resposta = new boolean[a.length];

        if (conectivo == E)
            for (int i = 0; i < a.length; i++)
                resposta[i] = a[i] && b[i];
        else if (conectivo == OU)
            for (int i = 0; i < a.length; i++)
                resposta[i] = a[i] || b[i];
        else if (conectivo == OU_OU)
            for (int i = 0; i < a.length; i++)
                resposta[i] = a[i] ^ b[i];
        else if (conectivo == SE_ENTAO)
            for (int i = 0; i < a.length; i++)
                resposta[i] = !((a[i]) && (!b[i]));
        else if (conectivo == SE_E_SOMENTE_SE)
            for (int i = 0; i < a.length; i++)
                resposta[i] = a[i] == b[i];
        super.resposta = resposta;
        respostas.put(this.toString(), resposta);
        return resposta;
    }

    public int getNumProposicoesSimples() {
        ArrayList<ProposicaoSimples> proposicoesSimples = new ArrayList<>();
        return getNumProposicoesSimples(a, proposicoesSimples) + getNumProposicoesSimples(b, proposicoesSimples);
    }

    public int getNumProposicoesSimples(Proposicao p, ArrayList<ProposicaoSimples> proposicoesSimples) {
        int num = 0;
        if (!proposicoesSimples.contains(p)) {
            if (p instanceof ProposicaoSimples) {
                num += 1;
                proposicoesSimples.add((ProposicaoSimples) p);
            }
            else if (p != null) {
                ProposicaoComposta ps = (ProposicaoComposta) p;
                if (ps.a != null) num += getNumProposicoesSimples(ps.a, proposicoesSimples);
                if (ps.b != null) num += getNumProposicoesSimples(ps.b, proposicoesSimples);
            }
        }
        return num;
    }

    @Override
    public Object clone() {
        ProposicaoComposta p = new ProposicaoComposta(a, b, conectivo, not);
        return p;
    }

}
