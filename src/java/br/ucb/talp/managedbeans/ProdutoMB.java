package br.ucb.talp.managedbeans;

import br.ucb.talp.beans.Produto;
import br.ucb.talp.daos.PaisOrigemDAO;
import br.ucb.talp.enums.TipoProduto;
import br.ucb.talp.service.JavaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB implements Serializable {

    private Produto produto;
    private List<Produto> produtos;
    private PaisOrigemDAO paisOrigemDAO;
    private static Integer CONT_PRODUTO = 1;

    public ProdutoMB() {
    }

    @PostConstruct
    public void init() {
        setProduto(new Produto());
        setProdutos(new ArrayList<Produto>());
        setPaisOrigemDAO(new PaisOrigemDAO());
    }

    public String add() {
        getProdutos().add(getProduto());
        getProduto().setId(CONT_PRODUTO++);
        if (getProduto().getId() > 999) {
            JavaUtil.message("Numero sequencial maior 999");
            return null;
        }
        setProduto(new Produto());
        return "LISTAR";
    }

    public String editarProduto(Produto produto) {
        if (produto != null) {
            produto.setNome(produto.getNome());
            produto.setTipoProduto(produto.getTipoProduto());
            produto.setPaisOrigem(produto.getPaisOrigem());
            produto.setQtdInicial(produto.getQtdInicial());
            setProduto(new Produto());
            return "LISTAR";
        }
        return null;
    }

    public String excluirProduto(Produto produto) {
        getProdutos().remove(produto);
        if (getProdutos().isEmpty()) {
            setProduto(new Produto());
            return "INDEX";
        }
        return null;
    }

    public void validaNomeRepetido(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value != null) {
            for (Produto p : getProdutos()) {
                if (p.getNome().equalsIgnoreCase(value.toString())) {
                    throw new ValidatorException(new FacesMessage("Nome ja existe!"));
                }
            }
        }
    }

    public List<TipoProduto> findAllTipoProduto() {
        List<TipoProduto> tipoProdutos = Arrays.asList(TipoProduto.values());
        return tipoProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public PaisOrigemDAO getPaisOrigemDAO() {
        return paisOrigemDAO;
    }

    public void setPaisOrigemDAO(PaisOrigemDAO paisOrigemDAO) {
        this.paisOrigemDAO = paisOrigemDAO;
    }

}
