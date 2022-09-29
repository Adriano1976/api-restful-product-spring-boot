package com.example.springboot.models;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Classe responsável por representar o modelo da tabela na base de dados e servir como recurso
 * na URI da API. Ela também estende RepresentationModel para que através do seu método add(),
 * a classe ProdutoModel exiba a ligação das demais url's relacionado.
 */
@Entity // Define a classe como entidade no banco.
@Table(name = "TB_PRODUCT") // Define o nome da tabela.
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Define que o id deve ser gerado automaticamente.
    @Column(name = "id_product", nullable = false) // Define o nome da coluna do banco.
    private UUID idProduct;
    @Column(name = "name", length = 100, nullable = false) // Define o nome da coluna do banco.
    private String name;
    @Column(name = "price", length = 10, nullable = false) // Define o nome da coluna do banco.
    private BigDecimal price;

    /**
     * Define um construtor sem parâmetro.
     */
    public ProductModel() {
    }

    /**
     * Define um construtor parâmetro
     *
     * @param idProduct Objeto responsável em receber um ‘id’.
     * @param name Objeto responsável em receber um nome.
     * @param price Objeto responsável em receber um valor.
     */
    public ProductModel(UUID idProduct, String name, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = BigDecimal.valueOf(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductModel that)) return false;

        return getIdProduct() != null ? getIdProduct().equals(that.getIdProduct()) : that.getIdProduct() == null;
    }

    @Override
    public int hashCode() {
        return getIdProduct() != null ? getIdProduct().hashCode() : 0;
    }
}
