package br.ucb.talp.beans;

import br.ucb.talp.enums.TipoProduto;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Produto implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private TipoProduto tipoProduto;
    private PaisOrigem paisOrigem;
    private Integer qtdInicial;

    public Produto() {
    }

    public Produto(String nome) {
        setNome(nome);
    }

    public Produto(Integer id, String nome, TipoProduto tipoProduto, PaisOrigem paisOrigem, Integer qtdInicial) {
        setId(id);
        setNome(nome);
        setTipoProduto(tipoProduto);
        setPaisOrigem(paisOrigem);
        setQtdInicial(qtdInicial);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public PaisOrigem getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(PaisOrigem paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Integer getQtdInicial() {
        return qtdInicial;
    }

    public void setQtdInicial(Integer qtdInicial) {
        this.qtdInicial = qtdInicial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{ id=" + getId() + "nome=" + getNome() + ", tipoProduto=" + getTipoProduto().name() + ", "
                + "paisOrigem=" + getPaisOrigem() + ", qtdInicial=" + getQtdInicial() + '}';
    }

}
