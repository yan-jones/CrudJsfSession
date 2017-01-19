package br.ucb.talp.enums;

public enum TipoProduto {

    FABRICADO, COMPRADO_NACIONAL, COMPRADO_INTERNACIONAL;

    public static TipoProduto getFindByOrdinal(Integer ordinal) {
        for (TipoProduto tipo : values()) {
            if (tipo.ordinal() == ordinal) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoProduto getFindByName(String name) {
        for (TipoProduto tipo : values()) {
            if (tipo.name().equalsIgnoreCase(name)) {
                return tipo;
            }
        }
        return null;
    }
}
