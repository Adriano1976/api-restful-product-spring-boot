package com.example.springboot.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Classe responsável em representar um Objeto correspondente a estrutura JWT e gerar o token.
 * A estrutura JWT é um Objeto JSON criptografado, composto por uma representação deste objeto e do
 * mecanismo de geração e interpretação do token.
 */
public class JWTObject {

    private String subject; // Nome do usuário.
    private Date issuedAt; // Data de criação do token.
    private Date expiration; // Data de expiração do token.
    private List<String> roles; // Perfis de acesso.


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setRoles(String... roles) {
        this.roles = Arrays.asList(roles);
    }
}
