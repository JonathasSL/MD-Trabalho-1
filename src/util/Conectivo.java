package util;

public enum Conectivo {
    NAO('~'), E('∧'), OU('∨'), OU_OU('⊻'), IMPLICACAO('→'), EQUIVALENCIA('↔'), UNDEFINED();

    public char simbolo;

    Conectivo(char simbolo){
        this.simbolo = simbolo;
    }

    Conectivo(){
        this('0');
    }
}