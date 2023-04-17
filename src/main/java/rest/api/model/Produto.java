package rest.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
    protected Long id;
    protected String produto;
    protected Double valor;
    protected Integer quantidade;

    public Produto() {}

    public Produto(String produto, Double valor, Integer quantidade) {
        super();
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto(Long id, String produto, Double valor, Integer quantidade) {
        super();
        this.id = id;
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}