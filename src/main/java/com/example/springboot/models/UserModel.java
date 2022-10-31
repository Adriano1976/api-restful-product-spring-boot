package com.example.springboot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por representar o modelo da tabela na base de dados do usuário e servir
 * como recurso na URI da API. Ela também estende RepresentationModel para que através do seu
 * método add(), a classe UserModel exiba a ligação das demais url's relacionado.
 *
 * @author Adriano Santos
 */
@Entity // Define a classe como entidade no banco.
@Table(name = "tab_user") // Define o nome da tabela.
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o id deve ser gerado automaticamente.
    @Column(name = "id_user") // Define o nome da coluna do banco.
    private Integer id;
    @Column(length = 50, nullable = false) // Define a configuraçaõ da coluna do banco.
    private String name;
    @Column(length = 20, nullable = false) // Define a configuraçaõ da coluna do banco.
    private String username;
    @Column(length = 100, nullable = false) // Define a configuraçaõ da coluna do banco.
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

    /**
     * Define um construtor sem parâmetro.
     */
    public UserModel() {
    }

    /**
     * Define um construtor parâmetro
     * @param id Objeto responsável em receber um ‘id’ do usuário.
     * @param name Objeto responsável em receber um ‘nome’ do usuário.
     * @param username Objeto responsável em receber um ‘nome de usuário’.
     * @param password Objeto responsável em receber um ‘a senha’ do usuário.
     */
    public UserModel(Integer id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel userModel)) return false;

        return getId() != null ? getId().equals(userModel.getId()) : userModel.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
