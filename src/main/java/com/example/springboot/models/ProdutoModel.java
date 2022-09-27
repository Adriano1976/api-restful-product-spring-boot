package com.example.springboot.models;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * Classe responsável por representar o modelo da tabela na base de dados e servir como recurso
 * na URI da API. Ela também estende RepresentationModel para que através do seu método add(),
 * a classe ProdutoModel exiba a ligação das demais url's relacionado.
 */
@Entity // Define a classe como entidade no banco.
@Table(name = "`TB_PRODUTO`") // Define o nome da tabela.
public class ProdutoModel extends RepresentationModel<ProdutoModel> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o id deve ser gerado automaticamente.
    @Column(name = "`id_produto`", nullable = false) // Define o nome da coluna do banco.
    private Long idProduto;
    @Column(name = "`nome`", length = 100, nullable = false) // Define o nome da coluna do banco.
    private String nome;
    @Column(name = "`valor`", length = 10, nullable = false) // Define o nome da coluna do banco.
    private Double valor;

    /**
     * Define um construtor sem parâmetro.
     */
    public ProdutoModel() {
    }

    /**
     * Define um construtor parâmetro
     *
     * @param idProduto Objeto responsável em receber um ‘id’.
     * @param nome Objeto responsável em receber um nome.
     * @param valor Objeto responsável em receber um valor.
     */
    public ProdutoModel(Long idProduto, String nome, Double valor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoModel that)) return false;

        return getIdProduto() != null ? getIdProduto().equals(that.getIdProduto()) : that.getIdProduto() == null;
    }

    @Override
    public int hashCode() {
        return getIdProduto() != null ? getIdProduto().hashCode() : 0;
    }
}
