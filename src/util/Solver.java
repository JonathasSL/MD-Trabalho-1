package util;

import proposicao.Argumento;
import proposicao.ArgumentoComposto;
import proposicao.ArgumentoSimples;

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
        Argumento argumento = getProposicao(text);
        boolean[] b;
        if (argumento instanceof ArgumentoComposto) {
            b = ((ArgumentoComposto) argumento).resolver();
        }
        else if (argumento instanceof ArgumentoSimples) {
            if (argumento.not) b = new boolean[] { false, true };
            else b = new boolean[] { true, false };
        }
        else b = new boolean[] { };
        System.out.println(argumento);
        for (boolean a : b)
            System.out.print(a + ", ");
    }

    public static void clear() {
        Argumento.clear();
    }

    private static Argumento getProposicao(String texto) {
        return (Argumento) resolverParenteses(0, texto)[1];
    }

    private static Object[] resolverParenteses(int inicio, String texto) {
        Argumento argumento = null;
        Argumento acumulador = null;
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
                Argumento prop = (Argumento) o[1];
                if (acumulador != null) {
                    if (argumento != null)
                        argumento = new ArgumentoComposto(argumento, acumulador, ultimoConectivo, not);
                    else argumento = acumulador;
                }
                if (argumento != null) argumento = new ArgumentoComposto(argumento, prop, ultimoConectivo, false);
                else {
                    if (not) argumento = prop.negado();
                    else argumento = prop;
                }
                not = false;
                acumulador = null;
                continue;
            }

            //verifica se eh argumento
            if (proposicoes.contains(s[i]) && !s[i].equals("(")) {

                Argumento prop = new ArgumentoSimples(s[i].charAt(0), not);
                if (acumulador != null) acumulador = new ArgumentoComposto(acumulador, prop, ultimoConectivo, false);
                else acumulador = prop;
                not = false;
            }
            else {
                switch (s[i]) {
                    case "~":
                        not = true;
                        break;
                    case "∧":
                        ultimoConectivo = Argumento.E;
                        not = false;
                        break;
                    case "∨":
                        ultimoConectivo = Argumento.OU;
                        not = false;
                        break;
                    case "⊻":
                        ultimoConectivo = Argumento.OU_OU;
                        not = false;
                        break;
                    case "→":
                        ultimoConectivo = Argumento.SE_ENTAO;
                        not = false;
                        break;
                    case "↔":
                        ultimoConectivo = Argumento.SE_E_SOMENTE_SE;
                        not = false;
                        break;
                }
            }
            i++;
        }

        if (acumulador != null){
            if (argumento != null)
                argumento = new ArgumentoComposto(argumento, acumulador, ultimoConectivo, not);
            else
                argumento = acumulador;
        }
        //Retorna a posição em que o parênteses acaba, e a proposição encontrada
        return new Object[] { i + 1, argumento};
    }

}
