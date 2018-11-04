package util;

public enum Conectivo {

    /*
     *   ARRUMAR CONECTIVOS MANUALMENTE
     *        NA CLASSE SOLVER
     *
     */

    CONJUNCAO("∧"), DISJUNCAO("∨"), DISJUNCAO_EXCLUSIVA("⊻"), IMPLICACAO("→"), EQUIVALENCIA("↔");

    private String simbolo;

    Conectivo(String simbolo){
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
