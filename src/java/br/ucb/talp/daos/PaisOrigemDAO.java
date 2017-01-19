package br.ucb.talp.daos;

import br.ucb.talp.beans.PaisOrigem;
import java.util.Arrays;
import java.util.List;

public class PaisOrigemDAO {

    public static List<PaisOrigem> select() {
        List<PaisOrigem> paises = Arrays.asList(
                new PaisOrigem("Argentina", "Cristina Kirchner"),
                new PaisOrigem("Brasil", "Dilma Rousseff"),
                new PaisOrigem("Paraguai", "Horacio Cartes"),
                new PaisOrigem("Uruguai", "Tabare Vazquez"),
                new PaisOrigem("Venezuela", "Nicolas Maduro")
        );
        return paises;
    }

    public static PaisOrigem selectByName(String name) {
        List<PaisOrigem> paises = select();
        for (PaisOrigem pais : paises) {
            if (pais.getNome().equalsIgnoreCase(name)) {
                return pais;
            }
        }
        return null;
    }
}
