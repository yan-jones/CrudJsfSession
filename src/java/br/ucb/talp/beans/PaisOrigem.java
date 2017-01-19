package br.ucb.talp.beans;

import java.io.Serializable;
import java.util.Objects;

public class PaisOrigem implements Serializable {

    //nome, presidente
    private String nome;
    private String presidente;

    public PaisOrigem() {
    }

    public PaisOrigem(String nome, String presidente) {
        setNome(nome);
        setPresidente(presidente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.presidente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final PaisOrigem other = (PaisOrigem) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.presidente, other.presidente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaisOrigem{" + "nome=" + getNome() + ", presidente=" + getPresidente() + '}';
    }

}
