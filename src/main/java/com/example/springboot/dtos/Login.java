package com.example.springboot.dtos;

/**
 * Classe responsável em receber os dados para a realização do Login na aplicação.
 */
public class Login {

    private String username;
    private String password;


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
}
