package util;

public enum Conectivo {
    E(""), OU(""), OU_OU(""), SE_ENTAO(""), SE_SOMENTE_SE("");

    private String simbolo;

    Conectivo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return simbolo;
    }

}
