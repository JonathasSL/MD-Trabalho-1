package util;

import proposicao.Proposicao;
import proposicao.ProposicaoComposta;
import proposicao.ProposicaoSimples;

import java.util.ArrayList;

public class Solver {
    public static ArrayList<String> proposicoes = new ArrayList<>();

    public Solver(){

        proposicoes = new ArrayList<>();
        proposicoes.add("p");
        proposicoes.add("q");
        proposicoes.add("r");
        proposicoes.add("t");
    }

    public void solve(String text) {
        System.out.println(text);
        Proposicao proposicao = getProposicao(text);
        boolean[] b;
        if (proposicao instanceof ProposicaoComposta) {
            b = ((ProposicaoComposta) proposicao).resolver();
        }
        else if (proposicao instanceof ProposicaoSimples) {
            if (proposicao.not) b = new boolean[] { false, true };
            else b = new boolean[] { true, false };
        }
        else b = new boolean[] { };
        System.out.println(proposicao);
        for (boolean a : b)
            System.out.print(a + ", ");
    }

    public static void clear() {
        Proposicao.clear();
    }

    private static Proposicao getProposicao(String texto) {
        return (Proposicao) resolverParenteses(0, texto)[1];
    }

    private static Object[] resolverParenteses(int inicio, String texto) {
        Proposicao proposicao = null;
        Proposicao acumulador = null;
        int i = inicio + 1, ultimoConectivo = -1;
        boolean not = false;
        String[] s = texto.split(" ");
        while (i < s.length && !s[i].equals(")")) {
            //Iterar até fechar o parênteses ou acabar o texto
            if (s[i].equals("(")) {
                //Quando abrir parênteses, fazer chamada recursiva que resolverá este parênteses
                //E então aqui ir para a posição em que ele acaba
                Object[] o = resolverParenteses(i, texto);
                i = (int) o[0];
                Proposicao prop = (Proposicao) o[1];
                if (acumulador != null) {
                    if (proposicao != null)
                        proposicao = new ProposicaoComposta(proposicao, acumulador, ultimoConectivo, not);
                    else proposicao = acumulador;
                }
                if (proposicao != null) proposicao = new ProposicaoComposta(proposicao, prop, ultimoConectivo, false);
                else {
                    if (not) proposicao = prop.negado();
                    else proposicao = prop;
                }
                not = false;
                acumulador = null;
                continue;
            }

            if (proposicoes.contains(s[i]) && !s[i].equals("(")) {
                System.err.println("ACHEI UMA PROPOSICAO SIMPLES!!!!!!!");
                // Caso seja uma proposição simples
                Proposicao prop = new ProposicaoSimples(s[i].charAt(0), not);
                if (acumulador != null) acumulador = new ProposicaoComposta(acumulador, prop, ultimoConectivo, false);
                else acumulador = prop;
                not = false;
            }
            else {
                switch (s[i]) {
                    case "~":
                        not = true;
                        break;
                    case "∧":
                        ultimoConectivo = Proposicao.E;
                        not = false;
                        break;
                    case "∨":
                        ultimoConectivo = Proposicao.OU;
                        not = false;
                        break;
                    case "⊻":
                        ultimoConectivo = Proposicao.OU_OU;
                        not = false;
                        break;
                    case "→":
                        ultimoConectivo = Proposicao.SE_ENTAO;
                        not = false;
                        break;
                    case "↔":
                        ultimoConectivo = Proposicao.SE_E_SOMENTE_SE;
                        not = false;
                        break;
                }
            }
            i++;
        }

        if (acumulador != null){
            if (proposicao != null)
                proposicao = new ProposicaoComposta(proposicao, acumulador, ultimoConectivo, not);
            else
                proposicao = acumulador;
        }
        //Retorna a posição em que o parênteses acaba, e a proposição encontrada
        return new Object[] { i + 1, proposicao };
    }

}
