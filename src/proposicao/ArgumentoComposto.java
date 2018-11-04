package proposicao;

import util.Conectivo;
import util.Solver;

import java.util.ArrayList;
import java.util.HashMap;

public class ArgumentoComposto extends Argumento {

    public Argumento a = null, b = null;
    public int conectivo;


    public ArgumentoComposto(Argumento a, Argumento b, int conectivo) {
        super();
        this.a = a;
        this.b = b;
        this.conectivo = conectivo;
    }

    public ArgumentoComposto(ArgumentoComposto p, boolean not) {
        this(p.a, p.b, p.conectivo, not);
    }

    public ArgumentoComposto(Argumento a, Argumento b, int conectivo, boolean not) {
        this(a, b, conectivo);
        this.not = not;
    }

    @Override
    public String toString() {
        String conec = getConec();
        if (not) return "~(" + a + conec + b + ")";
        else return "(" + a + conec + b + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArgumentoComposto) {
            ArgumentoComposto p = (ArgumentoComposto) o;
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

        switch(conectivo){
            case E:
                for (int i = 0; i < a.length; i++)
                    resposta[i] = a[i] && b[i];
                break;

            case OU:
                for (int i = 0; i < a.length; i++)
                    resposta[i] = a[i] || b[i];
                break;

            case OU_OU:
                for (int i = 0; i < a.length; i++)
                    resposta[i] = a[i] ^ b[i];
                break;

            case SE_ENTAO:
                for (int i = 0; i < a.length; i++)
                    resposta[i] = !((a[i]) && (!b[i]));
                break;

            case SE_E_SOMENTE_SE:
                for (int i = 0; i < a.length; i++)
                    resposta[i] = a[i] == b[i];
                break;


        }
        super.resposta = resposta;
        respostas.put(this.toString(), resposta);

        Solver.respostas.put(this, resposta);
        Solver.argumentos.add(this);
        return resposta;
    }

    public int getNumProposicoesSimples() {
        ArrayList<ArgumentoSimples> proposicoesSimples = new ArrayList<>();
        return getNumProposicoesSimples(a, proposicoesSimples) + getNumProposicoesSimples(b, proposicoesSimples);
    }

    public int getNumProposicoesSimples(Argumento p, ArrayList<ArgumentoSimples> proposicoesSimples) {
        int num = 0;
        if (!proposicoesSimples.contains(p)) {
            if (p instanceof ArgumentoSimples) {
                num += 1;
                proposicoesSimples.add((ArgumentoSimples) p);
            }
            else if (p != null) {
                ArgumentoComposto ps = (ArgumentoComposto) p;
                if (ps.a != null) num += getNumProposicoesSimples(ps.a, proposicoesSimples);
                if (ps.b != null) num += getNumProposicoesSimples(ps.b, proposicoesSimples);
            }
        }
        return num;
    }

    @Override
    public Object clone() {
        ArgumentoComposto p = new ArgumentoComposto(a, b, conectivo, not);
        return p;
    }

    public String getConec(){
        String conec;
        switch (conectivo) {
            case NAO:
                conec = "~";
                break;
            case E:
                conec = Conectivo.CONJUNCAO.toString();
                break;
            case OU:
                conec = Conectivo.DISJUNCAO.toString();
                break;
            case OU_OU:
                conec = Conectivo.DISJUNCAO_EXCLUSIVA.toString();
                break;
            case SE_ENTAO:
                conec = Conectivo.IMPLICACAO.toString();
                break;
            case SE_E_SOMENTE_SE:
                conec = Conectivo.EQUIVALENCIA.toString();
                break;
            default:
                conec = null;
                break;
        }
        return conec;
    }
}
